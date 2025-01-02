package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Category;
import ntu.vinh.finalprojectjava.models.Transaction;
import ntu.vinh.finalprojectjava.services_BLL.CategoryService;
import ntu.vinh.finalprojectjava.services_BLL.TransactionService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;

public class AddTransactionController {
  @FXML
  private ComboBox<Category> categoryComboBox;
  @FXML
  private TextField amountField;
  @FXML
  private DatePicker datePicker;
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
    categoryComboBox.setConverter(new javafx.util.StringConverter<>() {
      @Override
      public String toString(Category category) {
        return category.getName();
      }

      @Override
      public Category fromString(String string) {
        return categoryComboBox.getItems().stream().filter(cat -> cat.getName().equals(string)).findFirst().orElse(null);
      }
    });
  }

  @FXML
  private void handleSaveTransaction() throws IOException, SQLException {
    Category category = categoryComboBox.getValue();
    String amountText = amountField.getText();
    LocalDate date = datePicker.getValue();
    String description = descriptionField.getText();

    if (category == null || amountText.isEmpty() || date == null || description.isEmpty()) {
      showAlert("Lỗi xác thực", "Vui lòng nhâp đầy đủ");
      return;
    }

    double amount;
    try {
      amount = Double.parseDouble(amountText);
    } catch (NumberFormatException e) {
      showAlert("Lỗi xác thực", "Vui lòng nhập một số hợp lệ cho số tiền.");
      return;
    }

    Transaction newTransaction = new Transaction(0, category.getId(), amount, date, description, category.getName());
    transactionService.addTransaction(newTransaction);
    Main.switchScene("/ntu/vinh/finalprojectjava/trans-view.fxml");
  }

  @FXML
  private void handleBack() throws IOException {
    Main.switchScene("/ntu/vinh/finalprojectjava/trans-view.fxml");
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}