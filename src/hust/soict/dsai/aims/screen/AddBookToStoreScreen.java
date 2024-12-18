package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();

        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();

        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();

        JLabel lblAuthors = new JLabel("Authors (comma separated):");
        JTextField txtAuthors = new JTextField();

        JButton btnAdd = new JButton("Add Book to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị từ các trường nhập liệu
                String title = txtTitle.getText().trim();
                String category = txtCategory.getText().trim();
                String costText = txtCost.getText().trim();
                String authorsText = txtAuthors.getText().trim();

                // Kiểm tra nếu các trường nhập liệu không rỗng
                if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || authorsText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kiểm tra giá trị cost có phải là số không
                float cost = 0;
                try {
                    cost = Float.parseFloat(costText);
                    if (cost <= 0) {
                        JOptionPane.showMessageDialog(null, "Cost must be a positive number!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid cost. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Xử lý danh sách tác giả
                String[] authorsArray = authorsText.split(",");
                for (int i = 0; i < authorsArray.length; i++) {
                    authorsArray[i] = authorsArray[i].trim(); // Loại bỏ khoảng trắng dư thừa
                }

                // Thêm Book vào cửa hàng
                Book book = new Book(title, category, cost, Arrays.asList(authorsArray));
                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Đóng màn hình hiện tại
            }
        });

        panel.add(lblTitle);
        panel.add(txtTitle);
        panel.add(lblCategory);
        panel.add(txtCategory);
        panel.add(lblCost);
        panel.add(txtCost);
        panel.add(lblAuthors);
        panel.add(txtAuthors);
        panel.add(new JLabel()); // Khoảng trống
        panel.add(btnAdd);

        return panel;
    }
}
