package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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

    public void play() throws PlayerException {
        if (getLength() <= 0) {
            // Ném ngoại lệ nếu độ dài của track không hợp lệ
            throw new PlayerException("Track length is not valid: " + getTitle());
        }
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength() + " minutes");
    }

}
