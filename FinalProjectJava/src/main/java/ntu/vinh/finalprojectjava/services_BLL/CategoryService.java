package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.models.Category;
import ntu.vinh.finalprojectjava.models.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
  private final Connection connection;

  public CategoryService() throws SQLException {
    this.connection = DatabaseConnection.getConnection();
  }

  public void addCategory(Category category) throws SQLException {
    String query = "INSERT INTO Category (Name, Description) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, category.getName());
      stmt.setString(2, category.getDescription());
      stmt.executeUpdate();
    }
  }

  public List<Category> getAllCategories() throws SQLException {
    List<Category> categories = new ArrayList<>();
    String query = "SELECT * FROM Category";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
      while (rs.next()) {
        categories.add(new Category(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description")));
      }
    }
    return categories;
  }
}