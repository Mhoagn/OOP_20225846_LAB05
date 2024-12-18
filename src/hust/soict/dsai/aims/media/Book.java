package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // List to store authors
    private ArrayList<String> authors = new ArrayList<>();

    // Default constructor
    public Book() {
        super();  // Gọi constructor của Media
    }

    // Constructor without authors
    public Book(String title, String category, float cost) {
        super(0, title, category, cost);  
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    // Constructor with authors
    public Book(String title, String category, float cost, List<String> authors) {
        super(0, title, category, cost); 
        if (authors == null || authors.isEmpty()) {
            throw new IllegalArgumentException("Authors list cannot be null or empty");
        }
        this.authors = new ArrayList<>(authors); 
    }

    // Getter for authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Method to add an author
    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty.");
        }

        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added.");
        } else {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty.");
        }

        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author \"" + authorName + "\" has been removed.");
        } else {
            System.out.println("Author \"" + authorName + "\" is not in the list.");
        }
    }


    // Override displayInfo to show additional details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Authors: " + (authors.isEmpty() ? "None" : String.join(", ", authors)));
    }

    @Override
    public String toString() {
        return "Book: ID=" + this.getId() + ", Title=" + this.getTitle() + 
               ", Category=" + this.getCategory() + ", Cost=" + this.getCost() + 
               ", Authors=" + (authors.isEmpty() ? "None" : String.join(", ", authors));
    }
}
