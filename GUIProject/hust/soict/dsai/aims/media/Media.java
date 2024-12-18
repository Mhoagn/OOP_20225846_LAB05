package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {}

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        // Kiểm tra nếu đối tượng so sánh là chính nó
        if (this == obj) {
            return true;
        }

        // Kiểm tra nếu đối tượng so sánh là null hoặc không phải là một thể hiện của lớp Media
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Chuyển đối tượng so sánh thành kiểu Media
        Media media = (Media) obj;

        // So sánh các thuộc tính title và category (vì chúng là các thuộc tính quan trọng trong đối tượng Media)
        return this.title != null && this.title.equalsIgnoreCase(media.title) && this.category != null && this.category.equalsIgnoreCase(media.category);
    }


    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: $" + cost);
    }

    @Override
    public String toString() {
        return "Media: Title=" + this.title + ", Category=" + this.category + ", Cost=" + this.cost;
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaTitleCostComparator();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaCostTitleComparator();
}
