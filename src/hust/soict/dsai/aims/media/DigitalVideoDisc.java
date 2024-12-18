package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        if(cost < 0) {
        	throw new IllegalArgumentException("Cost cannot be negative");
        }
    }
    
    public boolean matchesTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public boolean matchesCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return getCategory().equalsIgnoreCase(category);
    }


    public boolean matchesPrice(float minPrice, float maxPrice) {
        if (minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Price range cannot be negative");
        }
        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Min price cannot be greater than max price");
        }

        if (minPrice > 0 && getCost() < minPrice) {
            return false;
        }
        if (maxPrice > 0 && getCost() > maxPrice) {
            return false;
        }
        return true;
    }

    
    @Override
    public void play() throws PlayerException {
        // Kiểm tra tiêu đề DVD
        if (getTitle() == null || getTitle().trim().isEmpty()) {
            // Ném ra PlayerException nếu tiêu đề không hợp lệ
            System.err.println("Error: DVD title is not set properly.");
            throw new PlayerException("DVD title is not set properly");
        }

        // Kiểm tra độ dài DVD
        if (getLength() <= 0) {
            // Ném ra PlayerException nếu độ dài không hợp lệ
            System.err.println("Error: DVD length is not valid.");
            throw new PlayerException("DVD length is not valid");
        }

        // Tiến hành phát DVD nếu không có lỗi
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }



    @Override
    public String toString() {
        return "DVD: Title=" + this.getTitle() + ", Category=" + this.getCategory() + ", Cost=" + this.getCost() +
               ", Director=" + this.getDirector() + ", Length=" + this.getLength();
    }
}
