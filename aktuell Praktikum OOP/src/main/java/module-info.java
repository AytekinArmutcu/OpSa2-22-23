module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.ownUtil;
    opens com.example.demo.ownUtil to javafx.fxml;
    exports com.example.demo.Factory;
    opens com.example.demo.Factory to javafx.fxml;
    exports com.example.demo.main;
    opens com.example.demo.main to javafx.fxml;
    exports com.example.demo.business;
    opens com.example.demo.business to javafx.fxml;
    exports com.example.demo.gui.guiFreizeitbaeder;
    opens com.example.demo.gui.guiFreizeitbaeder to javafx.fxml;
}