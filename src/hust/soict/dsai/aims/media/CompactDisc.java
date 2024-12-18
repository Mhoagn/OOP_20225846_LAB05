package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, null, 0, cost);
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be null or empty");
        }
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String artist, float cost, ArrayList<Track> tracks) {
        super(title, category, null, 0, cost); 
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be null or empty");
        }
        if (tracks == null || tracks.isEmpty()) {
            throw new IllegalArgumentException("Track list cannot be null or empty");
        }
        this.artist = artist;
        this.tracks = tracks;
    }



    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null");
        }
        if (tracks.contains(track)) {
            System.out.println("The track is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("The track has been added.");
        }
    }

    public void removeTrack(Track track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null");
        }
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track does not exist: " + track.getTitle());
        }
    }


    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            System.err.println("Error: CD length is not valid.");
            throw new PlayerException("CD length is not valid");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.artist);

        if (tracks.isEmpty()) {
            System.out.println("No tracks available to play.");
            return;
        }

        for (Track track : tracks) {
            if (track.getLength() <= 0) {
                System.err.println("Error: Track length is not valid.");
                throw new PlayerException("Track length is not valid");
            }
            
            try {
                track.play();
            } catch (PlayerException e) {
                // Bắt ngoại lệ PlayerException từ track và in ra thông báo lỗi
                System.err.println("Error while playing track: " + track.getTitle() + " - " + e.getMessage());
                throw e;  // Ném lại ngoại lệ để ngừng phát CD nếu có lỗi trong bất kỳ track nào
            }
        }
    }



    @Override
    public String toString() {
        return "CD: Artist=" + artist + ", Title=" + this.getTitle() + ", Category=" + this.getCategory() + ", Cost=" + this.getCost();
    }

}
