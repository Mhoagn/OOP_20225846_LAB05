package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PolymorphismExample {
    public static void main(String[] args) {
        // 1. Tạo một ArrayList chứa các đối tượng Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // 2. Thêm các đối tượng Book, DVD, và CD vào ArrayList
        mediaList.add(new Book(1, "The Great Gatsby", "Fiction", 15.99f));
        mediaList.add(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 120, 20.0f));
        mediaList.add(new CompactDisc("Taylor Swift", "Pop", "Taylor Swift", 25.0f, new ArrayList<>()));

        // 3. Lặp qua danh sách và in ra thông tin của từng media sử dụng phương thức toString()
        for (Media media : mediaList) {
            System.out.println(media.toString()); // Phương thức toString sẽ được gọi tự động tùy theo loại đối tượng
        }
    }
}
