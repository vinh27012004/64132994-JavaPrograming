package org.example.demo2;

import java.sql.*;

public class Home {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    // Đăng ký driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    String strConn = "jdbc:mysql://localhost:3306/demobanhang";
    // Mở kết nối
    Connection conn = DriverManager.getConnection(strConn, "root", "");

    System.out.println("Kết nối thành công");

    // Select dữ liệu
    String sqlSelect = "SELECT * FROM sanpham";

    Statement lenh = conn.createStatement();

    ResultSet ketqua = lenh.executeQuery(sqlSelect);
    // Hien ket qua

    System.out.println("Danh sách sản phẩm");

    while (ketqua.next()) {
      ketqua.getInt("id"); // Lấy tên cột;
      String TenSP = ketqua.getString("tenSP");
      int Gia = ketqua.getInt("giaSP");
      String MoTa = ketqua.getString("MoTa");
      System.out.println("Tên sản phẩm: " + TenSP + " - Giá: " + Gia +  " - Mô tả: " + MoTa);
    }
  }
}
