package ntu.vinh.finalprojectjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
  private static Stage primaryStage;

  @Override
  public void start(Stage stage) throws IOException {
    primaryStage = stage;
    switchScene("/ntu/vinh/finalprojectjava/trans-view.fxml");
    stage.setTitle("Quản lý Chi tiêu");
    stage.show();
  }

  public static void switchScene(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
    Scene scene = new Scene(fxmlLoader.load());
    String cssPath = Main.class.getResource("/ntu/vinh/finalprojectjava/styles.css").toExternalForm();
    scene.getStylesheets().add(cssPath);
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
  }

  public static void main(String[] args) {
    launch();
  }
}