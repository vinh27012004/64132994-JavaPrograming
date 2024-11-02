package org.example.cau2;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
  @FXML
  private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Label errorMessage;

  private MainApp mainApp;

  public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
  }

  private Connection connectDB() throws SQLException {
    // Kết nối đến cơ sở dữ liệu XAMPP
    String url = "jdbc:mysql://localhost:3306/QuanLyHocSinh";
    String user = "root";
    String password = ""; // Mật khẩu của MySQL
    return DriverManager.getConnection(url, user, password);
  }

  @FXML
  public void handleLogin() {
    String username = usernameField.getText();
    String password = passwordField.getText();

    try (Connection conn = connectDB()) {
      String query = "SELECT * FROM User WHERE username = ? AND password = ?";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        // Mở màn hình chính
        mainApp.showMainScreen();
      } else {
        errorMessage.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      errorMessage.setText("Lỗi kết nối cơ sở dữ liệu");
    }
  }
}