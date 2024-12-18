package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
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

        JLabel lblArtist = new JLabel("Artist:");
        JTextField txtArtist = new JTextField();

        JButton btnAdd = new JButton("Add CD to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị từ các trường nhập liệu
                String title = txtTitle.getText().trim();
                String category = txtCategory.getText().trim();
                String costText = txtCost.getText().trim();
                String artist = txtArtist.getText().trim();

                // Kiểm tra nếu các trường nhập liệu không rỗng
                if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || artist.isEmpty()) {
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

                // Thêm CD vào cửa hàng
                CompactDisc cd = new CompactDisc(title, category, artist, cost);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Đóng màn hình hiện tại
            }
        });

        panel.add(lblTitle);
        panel.add(txtTitle);
        panel.add(lblCategory);
        panel.add(txtCategory);
        panel.add(lblCost);
        panel.add(txtCost);
        panel.add(lblArtist);
        panel.add(txtArtist);
        panel.add(new JLabel());  // Empty space
        panel.add(btnAdd);

        return panel;
    }

}
