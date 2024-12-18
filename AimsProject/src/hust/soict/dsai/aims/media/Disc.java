package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {}

    public Disc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost); // Lấy id mặc định là 0
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Disc: Title=" + this.getTitle() + ", Category=" + this.getCategory() + ", Director=" + this.director + ", Length=" + this.length + " mins, Cost=" + this.getCost();
    }
}

