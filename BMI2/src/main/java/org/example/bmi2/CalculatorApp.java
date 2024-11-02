package org.example.bmi2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class CalculatorApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(CalculatorAppController.class.getResource("CaculatorApp.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    primaryStage.setTitle("Máy Tính");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
