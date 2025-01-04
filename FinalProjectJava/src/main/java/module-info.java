module ntu.vinh.finalprojectjava {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens ntu.vinh.finalprojectjava to javafx.fxml;
  opens ntu.vinh.finalprojectjava.controller to javafx.fxml;
  opens ntu.vinh.finalprojectjava.models to javafx.base; // Add this line

  exports ntu.vinh.finalprojectjava;
  exports ntu.vinh.finalprojectjava.controller;
  opens ntu.vinh.finalprojectjava.untils to javafx.base;
}