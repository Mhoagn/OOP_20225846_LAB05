package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, null, 0, cost);
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, String artist, float cost, ArrayList<Track> tracks) {
        super(title, category, null, 0, cost);  // Gọi constructor của lớp cha (Disc)
        this.artist = artist;
        this.tracks = tracks;
    }


    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("The track has been added.");
        }
    }


    public void removeTrack(Track track) {
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
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD: Artist=" + artist + ", Title=" + this.getTitle() + ", Category=" + this.getCategory() + ", Cost=" + this.getCost();
    }

}
