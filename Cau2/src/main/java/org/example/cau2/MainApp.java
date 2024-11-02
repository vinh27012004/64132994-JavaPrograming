package org.example.cau2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.cau2.LoginController;

public class MainApp extends Application {

  private Stage primaryStage;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Quản Lý Học Sinh");

    showLoginScreen();
  }

  private void showLoginScreen() {
    try {
      // Tải màn hình đăng nhập từ file FXML
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
      AnchorPane loginPane = loader.load();

      // Đặt scene và hiển thị
      Scene scene = new Scene(loginPane);
      primaryStage.setScene(scene);
      primaryStage.show();

      // Lấy controller và thiết lập hàm callback để chuyển đến màn hình chính khi đăng nhập thành công
      LoginController controller = loader.getController();
      controller.setMainApp(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void showMainScreen() {
    try {
      // Tải màn hình chính từ file FXML
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
      AnchorPane mainPane = loader.load();

      // Đặt scene và hiển thị
      Scene scene = new Scene(mainPane);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
