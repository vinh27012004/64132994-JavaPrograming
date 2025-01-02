package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.models.Statistic;
import ntu.vinh.finalprojectjava.models.Transaction;
import ntu.vinh.finalprojectjava.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionService {
  private final Connection connection;

  public TransactionService() throws SQLException {
    this.connection = DatabaseConnection.getConnection();
  }
  private Integer getRecycledId() throws SQLException {
    String query = "SELECT ID FROM RecycledIds ORDER BY ID ASC LIMIT 1";
    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
      if (rs.next()) {
        int id = rs.getInt("ID");
        // Xóa ID khỏi bảng RecycledIds sau khi sử dụng
        try (PreparedStatement deleteStmt = connection.prepareStatement("DELETE FROM RecycledIds WHERE ID = ?")) {
          deleteStmt.setInt(1, id);
          deleteStmt.executeUpdate();
        }
        return id;
      }
    }
    return null; // Không có ID trống
  }

  public void addTransaction(Transaction transaction) throws SQLException {
    Integer recycledId = getRecycledId();
    String query;

    if (recycledId != null) {
      // Sử dụng ID trống
      query = "INSERT INTO Transaction (ID, CategoryID, Amount, Date, Description) VALUES (?, ?, ?, ?, ?)";
      try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, recycledId);
        stmt.setInt(2, transaction.getCategoryId());
        stmt.setDouble(3, transaction.getAmount());
        stmt.setDate(4, java.sql.Date.valueOf(transaction.getDate()));
        stmt.setString(5, transaction.getDescription());
        stmt.executeUpdate();
      }
    } else {
      // Không có ID trống, thêm bình thường
      query = "INSERT INTO Transaction (CategoryID, Amount, Date, Description) VALUES (?, ?, ?, ?)";
      try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setInt(1, transaction.getCategoryId());
        stmt.setDouble(2, transaction.getAmount());
        stmt.setDate(3, java.sql.Date.valueOf(transaction.getDate()));
        stmt.setString(4, transaction.getDescription());
        stmt.executeUpdate();
      }
    }
  }

  public List<Transaction> getTransactions() throws SQLException {
    List<Transaction> transactions = new ArrayList<>();
    String query = "SELECT t.*, c.Name as categoryName FROM Transaction t JOIN Category c ON t.CategoryID = c.ID";
    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
      while (rs.next()) {
        Transaction transaction = new Transaction(
            rs.getInt("ID"),
            rs.getInt("CategoryID"),
            rs.getDouble("Amount"),
            rs.getDate("Date").toLocalDate(),
            rs.getString("Description"),
            rs.getString("categoryName")
        );
        transactions.add(transaction);
      }
    }
    return transactions;
  }

  public void deleteTransaction(Transaction transaction) {
    String deleteQuery = "DELETE FROM Transaction WHERE ID = ?";
    String recycleQuery = "INSERT INTO RecycledIds (ID) VALUES (?)";
    try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
         PreparedStatement recycleStmt = connection.prepareStatement(recycleQuery)) {
      // Xóa giao dịch
      deleteStmt.setInt(1, transaction.getId());
      deleteStmt.executeUpdate();

      // Thêm ID vào danh sách tái sử dụng
      recycleStmt.setInt(1, transaction.getId());
      recycleStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}