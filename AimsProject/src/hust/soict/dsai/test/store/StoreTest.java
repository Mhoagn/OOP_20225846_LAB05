		package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new Store
        Store store = new Store();

        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        
        store.displayStore();

        
        store.removeDVD(dvd2);

        
        store.displayStore();

        
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Sci-Fi", 19.99f);
        store.removeDVD(dvd4);

        
        store.displayStore();
    }
}
