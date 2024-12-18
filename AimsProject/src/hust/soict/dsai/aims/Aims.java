package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;  

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo cửa hàng với một số media mẫu
        ArrayList<Media> store = new ArrayList<>();
        store.add(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 120, 19.99f));
        store.add(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 15.99f));
        store.add(new Book(1, "The Great Gatsby", "Fiction", 12.99f));
        store.add(new CompactDisc("Taylor Swift", "Pop", "Taylor Swift", 25.0f));

        while (true) {
            // Hiển thị menu chính
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1: // View store
                    while (true) {
                        // Hiển thị danh sách các media trong cửa hàng
                        System.out.println("Store:");
                        for (Media media : store) {
                            media.displayInfo();
                        }

                        // Hiển thị menu cửa hàng
                        storeMenu();
                        int storeChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (storeChoice) {
                            case 1: // See media details
                                System.out.print("Enter the title of the media: ");
                                String title = scanner.nextLine();
                                Media mediaFound = null;
                                for (Media media : store) {
                                    if (media.getTitle().equalsIgnoreCase(title)) {
                                        mediaFound = media;
                                        break;
                                    }
                                }
                                if (mediaFound != null) {
                                    mediaFound.displayInfo();
                                    mediaDetailsMenu();
                                    int detailsChoice = scanner.nextInt();
                                    scanner.nextLine();  // Consume the newline
                                    switch (detailsChoice) {
                                        case 1: // Add to cart
                                            cart.addMedia(mediaFound);
                                            System.out.println("Media added to cart.");
                                            break;
                                        case 2: // Play
                                            if (mediaFound instanceof Playable) {
                                                ((Playable) mediaFound).play();
                                            } else {
                                                System.out.println("This media cannot be played.");
                                            }
                                            break;
                                        case 0: // Back
                                            break;
                                    }
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;

                            case 2: // Add media to cart
                                System.out.print("Enter the title of the media to add: ");
                                String addTitle = scanner.nextLine();
                                boolean added = false;
                                for (Media media : store) {
                                    if (media.getTitle().equalsIgnoreCase(addTitle)) {
                                        cart.addMedia(media);
                                        System.out.println("Media added to cart.");
                                        added = true;
                                        break;
                                    }
                                }
                                if (!added) {
                                    System.out.println("Media not found in store.");
                                }
                                break;

                            case 3: // Play media
                                System.out.print("Enter the title of the media to play: ");
                                String playTitle = scanner.nextLine();
                                boolean foundToPlay = false;
                                for (Media media : store) {
                                    if (media.getTitle().equalsIgnoreCase(playTitle)) {
                                        if (media instanceof Playable) {
                                            ((Playable) media).play();
                                            foundToPlay = true;
                                        } else {
                                            System.out.println("This media cannot be played.");
                                            foundToPlay = true;
                                        }
                                        break;
                                    }
                                }
                                if (!foundToPlay) {
                                    System.out.println("Media not found.");
                                }
                                break;

                            case 4: // See current cart
                                cart.displayCart(); // Sửa displayItems() thành displayCart()
                                break;

                            case 0: // Back
                                break;
                        }
                        if (storeChoice == 0) break;
                    }
                    break;

                case 2: // Update store
                    // Tạo tính năng thêm/xóa media vào cửa hàng ở đây
                    break;

                case 3: // See current cart
                    while (true) {
                        // Hiển thị giỏ hàng
                        cart.displayCart(); // Sửa displayItems() thành displayCart()

                        // Hiển thị menu giỏ hàng
                        cartMenu();
                        int cartChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (cartChoice) {
                            case 1: // Filter medias in cart
                                // Filter by ID or Title
                                break;
                            case 2: // Sort medias in cart
                                // Sort by Title or Cost
                                break;
                            case 3: // Remove media from cart
                                System.out.print("Enter the title of the media to remove: ");
                                String removeTitle = scanner.nextLine();
                                cart.removeMediaByTitle(removeTitle); // Sửa removeMedia thành removeMediaByTitle
                                break;
                            case 4: // Play media
                                System.out.print("Enter the title of the media to play: ");
                                String playMediaTitle = scanner.nextLine();
                                cart.playMedia(playMediaTitle);
                                break;
                            case 5: // Place order
                                System.out.println("Your order has been placed!");
                                cart.clearCart();
                                break;
                            case 0: // Back
                                break;
                        }
                        if (cartChoice == 0) break;
                    }
                    break;

                case 0: // Exit
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
