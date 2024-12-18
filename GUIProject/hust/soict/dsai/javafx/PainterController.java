package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;  // Khu vực vẽ

    @FXML
    private RadioButton penRadioButton;   // RadioButton cho Pen
    @FXML
    private RadioButton eraserRadioButton;  // RadioButton cho Eraser

    private boolean isEraser = false;  // Biến để kiểm tra chế độ Eraser

    // Xử lý sự kiện Clear Button
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();  // Xóa toàn bộ hình vẽ trên Pane
    }

    // Xử lý sự kiện khi người dùng kéo chuột trên Pane (vẽ)
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isEraser) {
            // Nếu đang ở chế độ Eraser, vẽ màu trắng (xóa)
            Circle newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            // Nếu đang ở chế độ Pen, vẽ màu đen
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    // Xử lý sự kiện khi chọn Pen
    @FXML
    void penButtonPressed(ActionEvent event) {
        isEraser = false;  // Chuyển sang chế độ vẽ Pen
    }

    // Xử lý sự kiện khi chọn Eraser
    @FXML
    void eraserButtonPressed(ActionEvent event) {
        isEraser = true;  // Chuyển sang chế độ tẩy Eraser
    }

    // Constructor
    public PainterController() {
        // Nếu cần, có thể thực hiện các khởi tạo ở đây
    }
    
    @FXML
    private void handleRemoveAction(ActionEvent event) {
        // Xử lý khi nhấn Remove
    }
}
