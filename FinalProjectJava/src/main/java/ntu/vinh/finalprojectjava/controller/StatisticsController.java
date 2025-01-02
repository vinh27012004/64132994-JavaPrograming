package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;

import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Statistic;
import ntu.vinh.finalprojectjava.services_BLL.StatisticsService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StatisticsController {
  @FXML
  private ComboBox<String> categoryComboBox;
  @FXML
  private ComboBox<String> monthComboBox;
  @FXML
  private TableView<Statistic> statisticsTable;
  @FXML
  private TableColumn<Statistic, String> categoryColumn;
  @FXML
  private TableColumn<Statistic, String> monthColumn;
  @FXML
  private TableColumn<Statistic, Double> totalAmountColumn;
  @FXML
  private BarChart<String, Number> categoryBarChart;

  private final StatisticsService statisticsService = new StatisticsService();
  private String lastSelectedCategory = null;
  private String lastSelectedMonth = null;

  public StatisticsController() throws SQLException {
  }

  @FXML
  public void initialize() {
    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
    monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
    totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

    // Load categories and months into ComboBoxes
    loadCategories();
    loadMonths();

  }

  private void loadCategories() {
    try {
      List<String> categories = statisticsService.getCategories();
      categoryComboBox.getItems().addAll(categories);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void loadMonths() {
    monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
  }

  private void handleCategorySelection() {
    String selectedCategory = categoryComboBox.getValue();
    if (selectedCategory != null && selectedCategory.equals(lastSelectedCategory)) {
      categoryComboBox.setValue(null);
      lastSelectedCategory = null;
    } else {
      lastSelectedCategory = selectedCategory;
    }
    refreshStatistics();
  }

  private void handleMonthSelection() {
    String selectedMonth = monthComboBox.getValue();
    if (selectedMonth != null && selectedMonth.equals(lastSelectedMonth)) {
      monthComboBox.setValue(null);
      lastSelectedMonth = null;
    } else {
      lastSelectedMonth = selectedMonth;
    }
    refreshStatistics();
  }

  @FXML
  private void refreshStatistics() {
    String selectedCategory = categoryComboBox.getValue();
    String selectedMonth = monthComboBox.getValue();

    try {
      List<Statistic> statistics = statisticsService.getStatistics(selectedCategory, selectedMonth);
      statisticsTable.getItems().setAll(statistics);
      updateBarChart(statistics);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void updateBarChart(List<Statistic> statistics) {
    categoryBarChart.getData().clear();
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    for (Statistic statistic : statistics) {
      series.getData().add(new XYChart.Data<>(statistic.getCategoryName(), statistic.getTotalAmount()));
    }
    categoryBarChart.getData().add(series);
  }

  @FXML
  private void handleBack() throws IOException {
    Main.switchScene("trans-view.fxml");
  }
}