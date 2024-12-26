package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Transaction;
import ntu.vinh.finalprojectjava.services_BLL.TransactionService;

import java.io.IOException;

public class TransactionController {
  @FXML
  private TableView<Transaction> transactionTable;
  @FXML
  private TableColumn<Transaction, Integer> idColumn;
  @FXML
  private TableColumn<Transaction, String> categoryColumn;
  @FXML
  private TableColumn<Transaction, Double> amountColumn;
  @FXML
  private TableColumn<Transaction, String> dateColumn;
  @FXML
  private TableColumn<Transaction, String> descriptionColumn;

  private final TransactionService transactionService = new TransactionService();

  @FXML
  public void initialize() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

    transactionTable.getItems().addAll(transactionService.getTransactions());
  }

  @FXML
  private void handleAddTransaction() throws IOException {
    Main.switchScene("add-transaction.fxml");
  }
}