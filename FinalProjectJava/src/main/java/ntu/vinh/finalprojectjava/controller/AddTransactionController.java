package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Category;
import ntu.vinh.finalprojectjava.models.Transaction;
import ntu.vinh.finalprojectjava.services_BLL.CategoryService;
import ntu.vinh.finalprojectjava.services_BLL.TransactionService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddTransactionController {
  @FXML
  private ComboBox<Category> categoryComboBox;
  @FXML
  private TextField amountField;
  @FXML
  private TextField dateField;
  @FXML
  private TextField descriptionField;

  private final TransactionService transactionService = new TransactionService();
  private final CategoryService categoryService = new CategoryService();

  public AddTransactionController() throws SQLException {
  }

  @FXML
  private void initialize() throws SQLException {
    List<Category> categories = categoryService.getAllCategories();
    categoryComboBox.getItems().addAll(categories);
  }

  @FXML
  private void handleSaveTransaction() throws IOException, SQLException {
    Category category = categoryComboBox.getValue();
    double amount = Double.parseDouble(amountField.getText());
    String date = dateField.getText();
    String description = descriptionField.getText();

    Transaction newTransaction = new Transaction(0, category.getId(), amount, date, description);
    transactionService.addTransaction(newTransaction);
    Main.switchScene("trans-view.fxml");
  }

  @FXML
  private void handleBack() throws IOException {
    Main.switchScene("trans-view.fxml");
  }
}