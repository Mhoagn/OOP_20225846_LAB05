package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore;  

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("Cannot add a null media to the store.");
        }
    }

    public boolean removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the store.");
            return true;
        } else {
            System.out.println(media.getTitle() + " not found in the store.");
            return false;
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            System.out.println("Items available in the store:");
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
        }
        System.out.println("**************************************************");
    }
}
