package com.example.tinhtongfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
  @FXML
  private TextField txtA, txtB, txtKQ;
  public void tinhTong() {
    int a = Integer.parseInt(txtA.getText());
    int b = Integer.parseInt(txtB.getText());

    String KQ = String.valueOf(a + b);

    txtKQ.setText(KQ);

  }
}
