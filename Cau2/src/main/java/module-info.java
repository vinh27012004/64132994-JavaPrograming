module org.example.cau2 {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.sql;
  requires jdk.jdi;


  opens org.example.cau2 to javafx.fxml;
    exports org.example.cau2;
}