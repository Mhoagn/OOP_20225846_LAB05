package hust.soict.dsai.test.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
// test chuc nang muc 12
public class CartExample {
    public static void main(String[] args) {
        // Tạo một ArrayList chứa các Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // Thêm một số media vào danh sách
        mediaList.add(new Book(1, "The Great Gatsby", "Fiction", 10.99f));
        mediaList.add(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 120, 20.0f));
        mediaList.add(new CompactDisc("Taylor Swift", "Pop", "Taylor Swift", 15.0f));

        // Sắp xếp theo tiêu đề rồi đến giá (title -> cost)
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        
        // In ra các media sau khi sắp xếp
        System.out.println("Media sorted by Title then Cost:");
        for (Media media : mediaList) {
            media.displayInfo();
        }

        // Sắp xếp theo giá rồi đến tiêu đề (cost -> title)
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        
        // In ra các media sau khi sắp xếp
        System.out.println("\nMedia sorted by Cost then Title:");
        for (Media media : mediaList) {
            media.displayInfo();
        }
    }
}
