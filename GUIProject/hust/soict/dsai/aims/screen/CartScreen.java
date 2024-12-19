package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;  // Đảm bảo biến cart được sử dụng

    // Thêm serialVersionUID để tránh cảnh báo
    private static final long serialVersionUID = 1L;

    public CartScreen(Cart cart) {
        this.cart = cart;

        // Tạo JFXPanel để tích hợp JavaFX vào Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart Screen");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Chạy trên JavaFX Application Thread
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/Cart.fxml"));
                CartScreenController controller = new CartScreenController();
                controller.setCart(cart);  // Truyền Cart vào controller
                loader.setController(controller);
                Parent root = loader.load();  // Tải giao diện FXML
                fxPanel.setScene(new Scene(root));  // Đặt scene cho JFXPanel
                
                // Nếu bạn muốn hiển thị tổng số tiền trong giỏ hàng trên giao diện,
                // bạn có thể thêm phương thức này trong controller để cập nhật giao diện.
                controller.updateTotalCost();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Phương thức main để khởi chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cart cart = new Cart();  // Khởi tạo Cart
            cart.addMedia(new DigitalVideoDisc("Inception1", "Sci-Fi", "Christopher Nolan", 120, 20.0f));
            new CartScreen(cart);  // Khởi tạo và hiển thị CartScreen
        });
    }
}
