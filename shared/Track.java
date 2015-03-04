package shared;
import java.util.ArrayList;
import java.util.Collection;

/**
    Class to represent a Midi Track
    @Author Casey Barnette cbarnette@gatech.edu
**/
public class Track {
    
    private ArrayList<Note> notes;
    
    /**
        Default constructor for a Track
    **/
    public Track() {
        notes = new ArrayList<Note>();
    }

    /**
        Constructor for Track that takes in a Note array
        @param inNotes the notes to initialize the track with.
    **/
    public Track(Note[] inNotes) {
        for (Note n : inNotes) {
            notes.add(n);
        }
    }

    /**
        Constructor for Track that takes in a Collection for Notes
        @param inNotes the notes the initialize the track with.
    **/
    public Track(Collection<Note> inNotes) {
        notes.addAll(inNotes);
    }

    /**
        Consructor for Track that takes in a Note
        @param n the note to initialize the track with.
    **/
    public Track(Note n) {
        notes.add(n);
    }

    /**
        Getter for the backing Notes
        @return the backing note ArrayList
    **/
    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
        Setter for the backing note ArrayList
        @param inNotes a new backing note ArrayList
    **/
    public void setNotes(ArrayList<Note> inNotes) {
        if (inNotes == null) {
            throw new IllegalArgumentException("The list of notes must not be null");
        } 
        notes = inNotes;
    }

    /**
        Gets a note at a specific index.
        @param index the index to retrieve the note from
        @return the note at the index
    **/
    public Note getNote(int index) {
        if (index < 0 || index > notes.size()) {
            throw new IllegalArgumentException("Index not valid");
        }
        return notes.get(index);
    }
    
    /**
        Setter for a note at a specific index
        @param n the new note
        @param index the index to set
    **/
    public void setNote(Note n, int index) {
        if (n == null) {
            throw new IllegalArgumentException("Passed in Note should not be null");
        }
        notes.get(index).setFrequency(n.getFrequency());
    }

    /**
        Adds a note at a specific index
        @param n the note to add to the ArrayList
        @param index the index to add the note to
    **/
    public void addNote(Note n, int index) {
        if (index > notes.size() || index < 0) {
            throw new IllegalArgumentException("Index is invalid");
        }
        
        if (n == null) {
            throw new IllegalArgumentException("Passed in Note should not be null");
        }
        
        notes.add(index, n);
    }

    /**
        Adds a note to the end of the backing structure
        @param n the new note to add
    **/
    public void addNote(Note n) {
        addNote(n, notes.size());
    }

    /**
        Appends a collection of notes to the backing structure
        @param inNotes the notes to append
    **/
    public void append(Collection<Note> inNotes) {
        if (inNotes == null) {
            throw new IllegalArgumentException("Passed in note list should not be null");
        }
        notes.addAll(inNotes);
    }

}
