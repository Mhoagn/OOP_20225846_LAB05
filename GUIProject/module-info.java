module GUIProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.base;

    // Mở các package cho javafx.fxml
    opens hust.soict.dsai.aims.screen to javafx.fxml;
    exports hust.soict.dsai.aims.screen;

    opens hust.soict.dsai.aims.store to javafx.fxml;
    exports hust.soict.dsai.aims.store;

    opens hust.soict.dsai.javafx to javafx.fxml;
    exports hust.soict.dsai.javafx;

    // Mở package hust.soict.dsai.aims.media cho javafx.base
    opens hust.soict.dsai.aims.media to javafx.base;
}
