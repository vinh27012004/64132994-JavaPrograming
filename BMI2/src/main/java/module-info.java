module org.example.bmi2 {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.example.bmi2 to javafx.fxml;
  exports org.example.bmi2;
}