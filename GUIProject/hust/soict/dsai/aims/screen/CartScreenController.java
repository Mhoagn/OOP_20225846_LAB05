package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TextField txtFilter;
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label lblTotalCost; // Label để hiển thị tổng chi phí

    public CartScreenController() {
        // Constructor mặc định
    }

    // Phương thức này được gọi từ CartScreen để thiết lập Cart
    public void setCart(Cart cart) {
        this.cart = cart;
        updateTotalCost();  // Cập nhật tổng chi phí sau khi thiết lập cart
    }

    @FXML
    private void initialize() {
        // Thiết lập các cột trong TableView
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Thiết lập các item của TableView
        tblMedia.setItems(this.cart.getItemsOrdered());

        // Ẩn nút Play và Remove khi chưa chọn media
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện khi người dùng thay đổi mục đã chọn trong TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue); // Cập nhật các nút khi có mục media được chọn
                }
            }
        });

        // Lắng nghe sự kiện thay đổi văn bản trong TextField filter
        txtFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue); // Lọc media khi người dùng nhập vào filter
            }
        });
    }

    // Phương thức cập nhật giao diện nút "Play" và "Remove"
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);  // Hiển thị nút "Remove"

        if (media instanceof Playable) {
            btnPlay.setVisible(true);  // Hiển thị nút "Play" nếu media là Playable
        } else {
            btnPlay.setVisible(false);  // Ẩn nút "Play" nếu media không phải là Playable
        }
    }

    // Phương thức xử lý khi người dùng nhấn nút "Remove"
    @FXML
    void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);  // Xóa media khỏi giỏ hàng
            updateTotalCost();  // Cập nhật lại tổng chi phí sau khi xóa
            
            // Cập nhật lại TableView với danh sách media mới
            tblMedia.setItems(cart.getItemsOrdered());  // Đảm bảo TableView được cập nhật
        }
    }


    // Phương thức xử lý khi người dùng nhấn nút "Play"
    @FXML
    private void handlePlayAction() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            Playable playableMedia = (Playable) selectedMedia;
            try {
				playableMedia.play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Gọi phương thức play của media nếu nó là Playable
        }
    }

    // Phương thức cập nhật tổng chi phí giỏ hàng
    public void updateTotalCost() {
        if (lblTotalCost != null) {
            float totalCost = cart.totalCost();
            lblTotalCost.setText(totalCost + "$");
        } else {
            System.out.println("lblTotalCost is null");
        }
    }


    // Phương thức lọc media trong giỏ hàng theo tiêu chí nhập vào
    private void showFilteredMedia(String filterText) {
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), media -> {
            return media.getTitle().toLowerCase().contains(filterText.toLowerCase());  // Lọc theo tiêu đề
        });

        tblMedia.setItems(filteredList);  // Cập nhật TableView với danh sách media đã lọc
    }
    @FXML
    private void handlePlaceOrder(ActionEvent event) {
        // Hiển thị thông báo xác nhận
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText("Your order has been placed successfully!");
        alert.setContentText("Thank you for shopping with us!");
        alert.showAndWait();
    }
}
