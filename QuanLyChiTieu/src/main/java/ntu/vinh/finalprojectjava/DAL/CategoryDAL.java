package ntu.vinh.finalprojectjava.DAL;

import ntu.vinh.finalprojectjava.models.Category;
import ntu.vinh.finalprojectjava.untils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAL {
  private final Connection connection;

  public CategoryDAL() throws SQLException {
    this.connection = DatabaseConnection.getConnection();
  }

  public List<Category> getAllCategories() throws SQLException {
    List<Category> categories = new ArrayList<>();
    String query = "SELECT * FROM Category";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query))
    {
      while (rs.next()) {
        Category category = new Category(
            rs.getInt("ID"),
            rs.getString("Name"),
            rs.getString("Description")
        );
        categories.add(category);
      }
    }
    return categories;
  }

  public void addCategory(Category category) throws SQLException {
    String query = "INSERT INTO Category (Name, Description) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
      stmt.setString(1, category.getName());
      stmt.setString(2, category.getDescription());
      stmt.executeUpdate();
    }
  }
}