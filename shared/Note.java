package shared;

/**
    This class is a representation of a note
    @Author Casey Barnette cbarnette@gatech.edu
**/
public class Note {

    float frequency;
   
    /**
        Constructor for the Note class
        @param freq The frequency for the note.
    **/ 
    public Note(float freq) {
        frequency = freq;
    }
    
    /**
        Getter for the frequency
        @return The frequency.
    **/
    public float getFrequency() {
        return frequency;
    }
    
    /**
        Setter for the frequency
        @param newFreq The new frequency.
    **/
    public void setFrequency(float newFreq) {
        frequency = newFreq;
    }
}
