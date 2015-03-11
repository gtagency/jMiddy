package org.gtagency.shared;

/**
    This class is a representation of a note
    @Author Casey Barnette cbarnette@gatech.edu
**/
public class Note {
    private byte pitch;
    private long startTick;
    private long endTick;

    /**
        Constructor for the Note class
        @param freq The frequency for the note.
    **/ 
    public Note(byte b, long startTick) {
        this.pitch = b;
        this.startTick = startTick;
    }
    
    public void setEndTick(long endTick) {
        this.endTick = endTick;
    }

    public byte getPitch() {
        return pitch;
    }

    public long getStartTick() {
        return startTick;
    }

    public long getEndTick() {
        return endTick;
    }
    
    public String toString() {
        return pitch + "";
//        return String.format("Pitch: %s, "
//            + "Start: %d, End: %d", pitch, startTick, endTick);
    }
   
}
