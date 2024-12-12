package th.phamnguyentrivinh.th_bai2_basicgui_bmi;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {
  @FXML
  private TextField txtHeight;
  @FXML
  private TextField txtWeight;
  @FXML
  private CheckBox chkAsian;
  @FXML
  private Label lblResult;
  @FXML
  private Label lblEvaluation;

  @FXML
  public void handleCalculateBMI(){
    double height = Double.parseDouble(txtHeight.getText()) / 100;
    double weight = Double.parseDouble(txtWeight.getText());

    // Tính BMI
    double bmi = weight / (height * height);
    lblResult.setText(String.format("BMI: %.2f", bmi));

    // Check if Asian
    boolean checkAsian = chkAsian.isSelected();
    String evulation;

    if(checkAsian){
      if(bmi < 17.5) {
        evulation = "Bạn đang gầy";
      } else if(bmi >= 17.5 && bmi <= 22.99) {
        evulation = "Bạn đang bình thường";
      } else if(bmi >= 23 && bmi <= 27.99) {
        evulation = "Bạn đang thừa cân";
      } else {
        evulation = "Bạn đang béo phì";
      }
    } else {
      if (bmi < 18.5) {
        evulation = "Bạn đang gầy";
      } else if (bmi >= 18.5 && bmi <= 24.99) {
        evulation = "Bạn đang bình thường";
      } else if (bmi >= 23 && bmi <= 27.99) {
        evulation = "Bạn đang thừa cân";
      } else {
        evulation = "Bạn đang béo phì";
      }
    }
      lblEvaluation.setText(evulation);
  }
}
