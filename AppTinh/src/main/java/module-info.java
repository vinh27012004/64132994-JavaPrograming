module org.example.apptinh {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;


  opens org.example.apptinh to javafx.fxml;
  exports org.example.apptinh;
}