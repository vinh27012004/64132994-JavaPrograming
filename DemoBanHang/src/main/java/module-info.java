module ntu.vinh.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;


  opens ntu.vinh.demobanhang to javafx.fxml;
  exports ntu.vinh.demobanhang;
}