package ntu.vinh.finalprojectjava.repositories_DAL;

import java.sql.Connection;

public class TransactionDAL {
  public void addTransaction(String type, double amount, String category, String date, String description) {
    String sql = "INSERT INTO Transactions (type, amount, category, date, description) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, type);
      pstmt.setDouble(2, amount);
      pstmt.setString(3, category);
      pstmt.setString(4, date);
      pstmt.setString(5, description);
      pstmt.executeUpdate();
      System.out.println("Thêm giao dịch thành công!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}