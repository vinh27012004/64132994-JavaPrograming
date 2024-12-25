package ntu.vinh.finalprojectjava.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String URL = "jdbc:mysql://localhost:3306/ChiTieuDB";
  private static final String USER = "root"; // Username mặc định của MySQL
  private static final String PASSWORD = ""; // Mật khẩu mặc định của MySQL

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Không thể kết nối tới cơ sở dữ liệu!");
    }
  }
}

