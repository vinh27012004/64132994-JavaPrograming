module org.example.draw {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.example.draw to javafx.fxml;
  exports org.example.draw;
}