package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;  // Danh sách các Media trong cửa hàng
    private int nextMediaId;  // Biến lưu trữ ID tiếp theo
    private final int Max_Numbers_Ordered = 20;  // Giới hạn số lượng media trong cửa hàng

    public Store() {
        this.itemsInStore = new ArrayList<>();
        this.nextMediaId = 1;  // Bắt đầu ID từ 1
    }

    // Phương thức để lấy ID tiếp theo
    public int getNextMediaId() {
        return nextMediaId++;
    }

    // Phương thức để thêm Media vào cửa hàng
    public void addMedia(Media media) throws IllegalArgumentException, IllegalStateException {
        if (media == null) {
            throw new IllegalArgumentException("Cannot add a null media to the store.");
        }

        // Kiểm tra xem cửa hàng có vượt quá giới hạn số lượng không
        if (itemsInStore.size() >= Max_Numbers_Ordered) {
            throw new IllegalStateException("Cannot add more media. The store has reached the maximum limit of " + Max_Numbers_Ordered + " items.");
        }

        // Nếu là đối tượng Book, cấp ID cho nó
        if (media instanceof Book) {
            media.setId(getNextMediaId()); // Cấp ID cho Book
        }
        itemsInStore.add(media);
        System.out.println(media.getTitle() + " has been added to the store.");
    }

    // Phương thức để xóa Media khỏi cửa hàng
    public boolean removeMedia(Media media) throws IllegalArgumentException {
        if (media == null) {
            throw new IllegalArgumentException("Cannot remove a null media from the store.");
        }

        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
            return true;
        } else {
            throw new IllegalArgumentException(media.getTitle() + " not found in the store.");
        }
    }

    // Phương thức để hiển thị tất cả các Media trong cửa hàng
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

    // Getter cho danh sách các Media trong cửa hàng
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
