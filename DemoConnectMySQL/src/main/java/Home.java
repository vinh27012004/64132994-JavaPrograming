import java.sql.*;

public class Home {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //1.Đăng ký divew
    Class.forName("com.mysql.cj.jdbc.Driver");
    //2. Mở kết nối
    //2.1. Chuoi két nối
    String strConn = "jdbc:mysql://localhost:3306/demobanhang";
    //2.2. Mớ kết nối
    Connection conn= DriverManager.getConnection(strConn, "root", "");
    // Select
    String sqlSeclect = "select * from SanPham";
    Statement lenh=  conn.createStatement();
    ResultSet ketQua = lenh.executeQuery(sqlSeclect);
    //Hiện kết quả
    while ( ketQua.next() ) {
      int id= ketQua.getInt(1); //lấy dữ liệu cột 0
      String tenSP = ketQua.getString(2);
      String giaSP = ketQua.getString(3);
      String moTa= ketQua.getString(4);
      System.out.print(id + " | " + tenSP + " | " + giaSP + " | " + moTa + "\n");
    }
  }
}