package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout for the screen
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createMenuBar(), BorderLayout.NORTH);
        cp.add(createInputPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    protected abstract JPanel createInputPanel();
}
