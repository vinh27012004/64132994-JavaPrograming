module ntu.vinh.finalprojectjava {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires java.desktop;


  opens ntu.vinh.finalprojectjava to javafx.fxml;
  exports ntu.vinh.finalprojectjava;
}