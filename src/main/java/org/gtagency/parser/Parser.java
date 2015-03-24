package org.gtagency.parser;

import javax.sound.midi.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.gtagency.shared.Note;

public class Parser {

    private Sequence midiSequence;
    private Track[] tracks;
    private ArrayList<List<Note>> allNotes;
    private double tps;

    public Parser(File file) {
        try {
            this.midiSequence = MidiSystem.getSequence(file);
        } catch (InvalidMidiDataException e) {
            System.out.println("Invalid midi format!"); 
        } catch (IOException e) {
            System.out.println("Could not open file: " + file.getName() + "!");
        }
        this.tracks = this.midiSequence.getTracks();

        parse();
    }

    private void parse() {
        long maxTicks = 0;
        for (Track t : tracks) {
            if (t.ticks() > maxTicks) maxTicks = t.ticks();
        }
        double seconds = midiSequence.getMicrosecondLength() / Math.pow(10, 6);
        tps = (double) maxTicks / seconds;

        System.out.printf("Song Length: %f, Ticks Per Second: %f\n", seconds, tps);

        System.out.println(maxTicks);
        
        //casting to int for now. If something goes wrong, we'll fix it
        allNotes = new ArrayList<List<Note>>((int)maxTicks);

        for (int i = 0; i <= (int)maxTicks; i++) {
            allNotes.add(new ArrayList<>());
        }

        for (Track track: tracks) {
            ArrayList<List<Note>> channels = new ArrayList<>(16);
            for (int i = 0; i < 16; i++) {
                channels.add(new ArrayList<>());
            }

            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                long eventTick = event.getTick();
                byte[] msgData = event.getMessage().getMessage();
                
                byte command = (byte) (msgData[0] & 0xf0);
                byte channel = (byte) (msgData[0] & 0xf);
                if (command == (byte) (ShortMessage.NOTE_ON & 0xff)) {
                    channels.get(channel).add(new Note(msgData[1], eventTick));
                } else if (command == (byte) (ShortMessage.NOTE_OFF & 0xff)) {
                    for (Note n : channels.get(channel)) {
                        if (n.getEndTick() == 0 && n.getPitch() == msgData[1]){
                            n.setEndTick(eventTick);
                        }
                    }
                }
            }
            for (List<Note> channel : channels) {
                for (Note note : channel) {
                    for (int i = (int) note.getStartTick(); i <= (int) note.getEndTick(); i++) {
                        allNotes.get(i).add(note);
                    }
                }
            }

        }
    }
    public ArrayList<List<Note>> getNotes() {
        return allNotes;
    }

    public ArrayList<List<Note>> downSample(int samplesPerSecond) {
        ArrayList<List<Note>> downSampled = new ArrayList<>();
        for (int i = 0; i < allNotes.size(); i += tps / samplesPerSecond) {
            downSampled.add(allNotes.get(i));
        }
        return downSampled;
    }

}
