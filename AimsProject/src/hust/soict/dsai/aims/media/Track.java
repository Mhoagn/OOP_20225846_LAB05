package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return this.title != null && this.title.equalsIgnoreCase(track.title)
               && this.length == track.length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " minutes");
    }
}
