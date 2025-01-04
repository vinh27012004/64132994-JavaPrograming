package ntu.vinh.finalprojectjava.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ntu.vinh.finalprojectjava.Main;
import ntu.vinh.finalprojectjava.models.Statistic;
import ntu.vinh.finalprojectjava.services_BLL.StatisticsBLL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
  @FXML
  private CategoryAxis xAxis;

  private final StatisticsBLL statisticsService = new StatisticsBLL();
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
      categoryComboBox.getItems().add("Tất cả các mục");
      categoryComboBox.getItems().addAll(categories);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void loadMonths() {
    monthComboBox.getItems().add("Tất cả các tháng");
    monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
  }

  @FXML
  private void refreshStatistics() {
    String selectedCategory = categoryComboBox.getValue();
    String selectedMonth = monthComboBox.getValue();

    if ("Tất cả các mục".equals(selectedCategory)) {
      selectedCategory = null;
    }

    try {
      List<Statistic> statistics;
      if ("Tất cả các tháng".equals(selectedMonth)) {
        statistics = statisticsService.getStatistics(selectedCategory, null);
        // Sum the total amounts for each category
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Statistic statistic : statistics) {
          categoryTotals.merge(statistic.getCategoryName(), statistic.getTotalAmount(), Double::sum);
        }
        // Convert the map to a list of Statistic objects
        List<Statistic> barChartStatistics = categoryTotals.entrySet().stream()
            .map(entry -> new Statistic(entry.getKey(), "Tất cả các tháng", entry.getValue()))
            .collect(Collectors.toList());
        updateBarChart(barChartStatistics);
      } else {
        statistics = statisticsService.getStatistics(selectedCategory, selectedMonth);
        updateBarChart(statistics);
      }
      statisticsTable.getItems().setAll(statistics);
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
    xAxis.setTickLabelRotation(45); // Rotate labels to prevent overlapping
  }

  @FXML
  private void handleBack() throws IOException {
    Main.switchScene("trans-view.fxml");
  }
}