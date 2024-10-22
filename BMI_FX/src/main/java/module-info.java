module com.example.bmi_fx {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.bmi_fx to javafx.fxml;
  exports com.example.bmi_fx;
}