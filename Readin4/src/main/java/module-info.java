module com.example.readin4 {
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;


  opens com.example.readin4 to javafx.fxml;
  exports com.example.readin4;
}