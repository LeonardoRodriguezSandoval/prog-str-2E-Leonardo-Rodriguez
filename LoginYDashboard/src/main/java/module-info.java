module com.example.loginydashboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.loginydashboard to javafx.fxml;
    exports com.example.loginydashboard;
}