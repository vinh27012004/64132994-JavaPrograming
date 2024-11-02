package org.example.bmi2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.util.LinkedList;

public class CalculatorAppController {
  @FXML
  private TextField heightField, weightField, byteField;
  @FXML
  private TextArea historyArea;

  private final LinkedList<String> historyList = new LinkedList<>();

  @FXML
  private void initialize() {
    loadHistory();
  }

  @FXML
  private void calculateBMI() {
    try {
      double height = Double.parseDouble(heightField.getText()) / 100;
      double weight = Double.parseDouble(weightField.getText());
      double bmi = weight / (height * height);
      String result = "BMI: " + String.format("%.2f", bmi);
      updateHistory(result);
    } catch (NumberFormatException e) {
      showError("Vui lòng nhập số hợp lệ cho chiều cao và cân nặng.");
    }
  }

  @FXML
  // Phương thức tính Byte ra bit
  private void convertByteToBit() {
    try {
      int bytes = Integer.parseInt(byteField.getText());
      int bits = bytes * 8;
      String result = "Bytes: " + bytes + " -> Bits: " + bits;
      updateHistory(result);
    } catch (NumberFormatException e) {
      showError("Vui lòng nhập số hợp lệ cho byte.");
    }
  }

  private void updateHistory(String result) {
    if (historyList.size() == 10) {
      historyList.removeFirst();
    }
    historyList.add(result);
    historyArea.setText(String.join("\n", historyList));
    saveHistory();
  }

  private void saveHistory() {
    try (FileWriter writer = new FileWriter("log.txt")) {
      for (String entry : historyList) {
        writer.write(entry + "\n");
      }
    } catch (IOException e) {
      showError("Lỗi khi ghi lịch sử vào file.");
    }
  }

  private void loadHistory() {
    try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (historyList.size() == 10) break;
        historyList.add(line);
      }
      historyArea.setText(String.join("\n", historyList));
    } catch (IOException e) {
      showError("Lỗi khi đọc lịch sử từ file.");
    }
  }

  private void showError(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
