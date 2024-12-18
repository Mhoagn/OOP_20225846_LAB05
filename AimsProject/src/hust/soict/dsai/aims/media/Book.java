package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    // List to store authors
    private ArrayList<String> authors = new ArrayList<>();

    // Constructors
    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Getter for authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Method to add an author
    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be null or empty.");
            return;
        }

        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added.");
        } else {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
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
        return "Book: ID=" + this.getId() + ", Title=" + this.getTitle() + ", Category=" + this.getCategory() + ", Cost=" + this.getCost();
    }

}
