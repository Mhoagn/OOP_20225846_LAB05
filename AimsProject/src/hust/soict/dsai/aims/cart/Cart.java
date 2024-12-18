package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
        }
    }

    // Xóa Media khỏi giỏ hàng theo đối tượng Media
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    // Xóa Media khỏi giỏ hàng theo title
    public void removeMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsOrdered.remove(media);
                System.out.println(title + " has been removed from the cart.");
                return;  // Đã tìm thấy và xóa, không cần tiếp tục tìm kiếm
            }
        }
        System.out.println("No media with the title \"" + title + "\" found in the cart.");
    }

    // Tính tổng chi phí của tất cả media trong giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Hiển thị các items trong giỏ hàng
    public void displayCart() {
        System.out.println("Items in the cart:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (Media media : itemsOrdered) {
                media.displayInfo();
            }
        }
        System.out.println("Total cost: $" + totalCost());
    }

    // Xóa tất cả media trong giỏ hàng
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }

    // Phát Media nếu là đối tượng Playable (CD, DVD)
    public void playMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media instanceof Playable && media.getTitle().equalsIgnoreCase(title)) {
                ((Playable) media).play();  // Gọi phương thức play() nếu là Playable
                return;
            }
        }
        System.out.println("Media not found or cannot be played.");
    }
}
