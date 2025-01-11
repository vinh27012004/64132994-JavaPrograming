package ntu.vinh.finalprojectjava.services_BLL;

import ntu.vinh.finalprojectjava.DAL.CategoryDAL;
import ntu.vinh.finalprojectjava.models.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryBLL {
  private final CategoryDAL categoryDAO;

  public CategoryBLL() throws SQLException {
    this.categoryDAO = new CategoryDAL();
  }

  public void addCategory(Category category) throws SQLException {
    categoryDAO.addCategory(category);
  }

  public List<Category> getAllCategories() throws SQLException {
    return categoryDAO.getAllCategories();
  }
}