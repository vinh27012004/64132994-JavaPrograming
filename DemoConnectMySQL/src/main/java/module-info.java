module org.example.demo2 {
  requires javafx.controls;
  requires javafx.fxml;
  requires mysql.connector.j;
  requires java.sql;


  opens org.example.demo2 to javafx.fxml;
  exports org.example.demo2;
}