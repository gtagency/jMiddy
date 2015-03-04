package parser;

import javax.sound.midi.*;
import java.io.*;

public class Parser {

    private Sequence midiSequence;
    private Track[] tracks;

    public Parser(File file) {
        try {
            this.midiSequence = MidiSystem.getSequence(file);
        } catch (InvalidMidiDataException e) {
            System.out.println("Invalid midi format!"); 
        } catch (IOException e) {
            System.out.println("Could not open file!");
        }
        this.tracks = this.midiSequence.getTracks();
    }

    public void parse() {
        for (Track track: tracks) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                long eventTick = event.getTick();
                byte[] msg = event.getMessage().getMessage();
                System.out.print("Event@" + eventTick);
                for (int j = 0; j <  msg.length; j++) {
                    System.out.print(" " + msg[j]);
                }
                System.out.println();
            }
        }
    }
}
