package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Store store;
    private Cart cart;

    public MediaStore(Media media, Store store, Cart cart) {
        this.media = media;
        this.store = store;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        JButton playButton = new JButton("Play");

        // Add action listener for "Add to cart"
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cart != null) {
                    cart.addMedia(media); // Add media to cart
                    JOptionPane.showMessageDialog(null,
                            media.getTitle() + " has been added to the cart.",
                            "Add to Cart",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Cart is not available.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener for "Play"
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog to simulate playing the media
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing " + media.getTitle());
                playDialog.setSize(300, 150);
                playDialog.setLocationRelativeTo(null);
                playDialog.setModal(true); // Makes the dialog modal (blocks the rest of the UI)
                JLabel playingLabel = new JLabel("Now playing: " + media.getTitle());
                playDialog.add(playingLabel);
                playDialog.setVisible(true);
            }
        });

        container.add(addToCartButton);
        if (media instanceof Playable) {
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createHorizontalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
