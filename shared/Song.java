package shared;
import java.util.ArrayList;
import java.util.Collection;
/**
    A representation of a Song in Midi format
    @Author Casey Barnette cbarnette@gatech.edu
**/
public class Song {
    
    private ArrayList<Track> tracks;

    /**
        Default Constructor for a song
    **/    
    public Song() {
        tracks = new ArrayList<Track>();
    }
    
    /**
        Constructor that makes a song out of an initial track
        @param t the track to initialize the song with
    **/
    public Song(Track t) {
        tracks.add(t);
    }
    
    /**
        Constructor that makes a song given a collection of tracks
        @param inTracks the collection of tracks to initialize the song with
    **/
    public Song(Collection<Track> inTracks) {
        tracks.addAll(inTracks);
    }
    
    /**
        Constructor that makes a song given an array of tracks
        @param inTracks the array of tracks to initialize the song with
    **/
    public Song(Track[] inTracks) {
        for(Track t : inTracks) {
            tracks.add(t);
        }
    }
    
    /**
        Gets a specific track in the song
        @param index the index of the track
        @return the track at the specified index
    **/
    public Track getTrack(int index) {
        if (index < 0 || index > tracks.size()) {
            throw new IllegalArgumentException("Index is not valid");
        }
        return tracks.get(index);
    }
    
    /**
        Getter for the backing collection of Tracks
        @return the backing collection of Tracks
    **/
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**
        Sets a specific track to be a new track
        @param newTrack the new Track to set
        @param index the index to set the new track to
    **/
    public void setTrack(Track newTrack, int index) {
        if (index < 0 || index > tracks.size()) {
            throw new IllegalArgumentException("Index is not valid");
        }
        
        tracks.get(index).setNotes(newTrack.getNotes());
    }

    /**
        Sets the backing collection of tracks
        @param newTracks the new backing collection of tracks
    **/
    public void setTracks(ArrayList<Track> newTracks) {
        tracks = newTracks;
    }

    /**
        Adds a new track at a specified index
        @param t the track to add
        @param index the index to add the track
    **/    
    public void addTrack(Track t, int index) {
        if (index < 0 || index > tracks.size()) {
            throw new IllegalArgumentException("Index is not valid");
        }

        if (t == null) {
            throw new IllegalArgumentException("Input track can't be null");
        }
        tracks.add(index, t);
    }

    /**
        Adds a track to the back of the collection
        @param t the track to add
    **/
    public void addTrack(Track t) {
        tracks.add(tracks.size(), t);
    }

    /**
        Adds a collection of tracks to the backing Collection
        @param newTracks the tracks to add
    **/
    public void append(Collection<Track> newTracks) {
        tracks.addAll(newTracks);
    }

}
