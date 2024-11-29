package ntu.vinh.demobanhang;

import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginController {
  private Connection connectDB() throws SQLException {
    // Kết nối đến cơ sở dữ liệu XAMPP
    String url = "jdbc:mysql://localhost:3306/demobanhang";
    String user = "root";
    String password = ""; // Mật khẩu của MySQL
    return DriverManager.getConnection(url, user, password);
  }
  @FXML
  public void handleLogin(){
    String username
  }

}
