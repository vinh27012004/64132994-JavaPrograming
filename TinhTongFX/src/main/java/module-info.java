module com.example.tinhtongfx {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.tinhtongfx to javafx.fxml;
  exports com.example.tinhtongfx;
}