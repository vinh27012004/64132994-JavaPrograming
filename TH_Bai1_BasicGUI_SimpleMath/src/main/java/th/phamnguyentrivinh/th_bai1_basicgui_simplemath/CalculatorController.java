package th.phamnguyentrivinh.th_bai1_basicgui_simplemath;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CalculatorController {

  @FXML
  private TextField txtNumberA;

  @FXML
  private TextField txtNumberB;

  @FXML
  private RadioButton rbAdd;

  @FXML
  private RadioButton rbSubtract;

  @FXML
  private RadioButton rbMultiply;

  @FXML
  private RadioButton rbDivide;

  @FXML
  private Label lblResult;

  public void handleCalculate() {
    try {
      double numberA = Double.parseDouble(txtNumberA.getText());
      double numberB = Double.parseDouble(txtNumberB.getText());
      double result = 0;

      // Determine selected operation
      if (rbAdd.isSelected()) {
        result = numberA + numberB;
      } else if (rbSubtract.isSelected()) {
        result = numberA - numberB;
      } else if (rbMultiply.isSelected()) {
        result = numberA * numberB;
      } else if (rbDivide.isSelected()) {
        if (numberB == 0) {
          lblResult.setText("Lỗi phép chia không thể chia cho 0");
          return;
        }
        result = numberA / numberB;
      } else {
        lblResult.setText("Làm ơn chọn phép toán");
        return;
      }
      // Display result
      lblResult.setText("Kết quả: " + result);
    } catch (NumberFormatException e) {
      lblResult.setText("Lỗi đầu vào");
    }
  }
}
