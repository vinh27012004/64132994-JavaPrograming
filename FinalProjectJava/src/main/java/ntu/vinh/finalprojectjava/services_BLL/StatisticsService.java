package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.models.DatabaseConnection;
import ntu.vinh.finalprojectjava.models.Statistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsService{
  private final Connection connection;

  public StatisticsService() throws SQLException {
    this.connection = DatabaseConnection.getConnection();
  }

  public List<String> getCategories() throws SQLException {
    List<String> categories = new ArrayList<>();
    String query = "SELECT DISTINCT Name FROM Category";
    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        categories.add(rs.getString("Name"));
      }
    }
    return categories;
  }

  public List<Statistic> getStatistics(String category, String month) throws SQLException {
    List<Statistic> statistics = new ArrayList<>();
    String query = "SELECT c.Name as categoryName, MONTH(t.Date) as month, SUM(t.Amount) as totalAmount " +
        "FROM Transaction t JOIN Category c ON t.CategoryID = c.ID " +
        "WHERE (? IS NULL OR c.Name = ?) AND (? IS NULL OR MONTHNAME(t.Date) = ?) " +
        "GROUP BY c.Name, MONTH(t.Date)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, category);
      stmt.setString(2, category);
      stmt.setString(3, month);
      stmt.setString(4, month);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          statistics.add(new Statistic(
              rs.getString("categoryName"),
              rs.getString("month"),
              rs.getDouble("totalAmount")
          ));
        }
      }
    }
    return statistics;
  }
}
