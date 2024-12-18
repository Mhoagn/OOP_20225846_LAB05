package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public void removeMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsOrdered.remove(media);
                System.out.println(title + " has been removed from the cart.");
                return;
            }
        }
        System.out.println("No media with the title \"" + title + "\" found in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }

    public void playMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media instanceof Playable && media.getTitle().equalsIgnoreCase(title)) {
                try {
					((Playable) media).play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return;
            }
        }
        System.out.println("Media not found or cannot be played.");
    }

    public ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemsOrdered);
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (Media media : itemsOrdered) {
                media.displayInfo();  // Hiển thị thông tin chi tiết của mỗi media
            }
            System.out.println("Total cost: " + totalCost() + " USD");
        }
    }

}
