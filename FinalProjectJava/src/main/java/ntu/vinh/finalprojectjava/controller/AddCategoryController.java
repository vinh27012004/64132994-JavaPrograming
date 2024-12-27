package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Category;
import ntu.vinh.finalprojectjava.services_BLL.CategoryService;

import java.io.IOException;
import java.sql.SQLException;

public class AddCategoryController {
  @FXML
  private TextField nameField;
  @FXML
  private TextField descriptionField;

  private final CategoryService categoryService = new CategoryService();

  public AddCategoryController() throws SQLException {
  }

  @FXML
  private void handleSaveCategory() throws IOException, SQLException {
    String name = nameField.getText();
    String description = descriptionField.getText();

    Category newCategory = new Category(0, name, description);
    categoryService.addCategory(newCategory);
    Main.switchScene("/ntu/vinh/finalprojectjava/trans-view.fxml");
  }

  @FXML
  private void handleBack() throws IOException {
    Main.switchScene("/ntu/vinh/finalprojectjava/trans-view.fxml");
  }
}