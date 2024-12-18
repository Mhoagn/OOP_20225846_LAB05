package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();

        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();

        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();

        JLabel lblDirector = new JLabel("Director:");
        JTextField txtDirector = new JTextField();

        JLabel lblLength = new JLabel("Length:");
        JTextField txtLength = new JTextField();

        JButton btnAdd = new JButton("Add DVD to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị từ các trường nhập liệu
                String title = txtTitle.getText().trim();
                String category = txtCategory.getText().trim();
                String costText = txtCost.getText().trim();
                String director = txtDirector.getText().trim();
                String lengthText = txtLength.getText().trim();

                // Kiểm tra nếu các trường nhập liệu không rỗng
                if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || director.isEmpty() || lengthText.isEmpty()) {
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

                // Kiểm tra giá trị length có phải là số không
                int length = 0;
                try {
                    length = Integer.parseInt(lengthText);
                    if (length <= 0) {
                        JOptionPane.showMessageDialog(null, "Length must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid length. Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Thêm DVD vào cửa hàng
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(null, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Đóng màn hình hiện tại
            }
        });

        panel.add(lblTitle);
        panel.add(txtTitle);
        panel.add(lblCategory);
        panel.add(txtCategory);
        panel.add(lblCost);
        panel.add(txtCost);
        panel.add(lblDirector);
        panel.add(txtDirector);
        panel.add(lblLength);
        panel.add(txtLength);
        panel.add(new JLabel());  // Empty space
        panel.add(btnAdd);

        return panel;
 }
}