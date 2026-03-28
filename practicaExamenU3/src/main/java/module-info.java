module com.example.practicaexamenu3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamenu3.controllers to javafx.fxml;
    exports com.example.practicaexamenu3;
}