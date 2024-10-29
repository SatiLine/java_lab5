module org.example.java_lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.java_lab5 to javafx.fxml;
    exports org.example.java_lab5;
}