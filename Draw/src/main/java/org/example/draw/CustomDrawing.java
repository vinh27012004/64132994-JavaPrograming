package org.example.draw;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CustomDrawing extends Application {

  @Override
  public void start(Stage primaryStage) {
    Canvas canvas = new Canvas(400, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Vẽ tam giác lớn (hướng xuống)
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    gc.strokePolygon(new double[]{100, 300, 200}, new double[]{200, 200, 50}, 3);

    // Vẽ hai tam giác nhỏ (tai) bên trên tam giác lớn
    gc.strokePolygon(new double[]{150, 170, 160}, new double[]{100, 50, 110}, 3);
    gc.strokePolygon(new double[]{230, 250, 240}, new double[]{100, 50, 110}, 3);

    // Vẽ tam giác nhỏ bên trong (mũi)
    gc.setStroke(Color.RED);
    gc.strokePolygon(new double[]{180, 220, 200}, new double[]{130, 130, 150}, 3);

    // Vẽ thân hình (nửa vòng tròn phía dưới)
    gc.setStroke(Color.BLACK);
    gc.strokeArc(150, 200, 100, 100, 180, 180, javafx.scene.shape.ArcType.OPEN);

    // Vẽ hai chân tròn và các đường vòng nhỏ bên trong
    gc.strokeOval(150, 280, 30, 30);
    gc.strokeOval(220, 280, 30, 30);
    gc.setStroke(Color.RED);
    gc.strokeArc(155, 295, 20, 20, 0, -180, javafx.scene.shape.ArcType.OPEN);
    gc.strokeArc(225, 295, 20, 20, 0, -180, javafx.scene.shape.ArcType.OPEN);

    Pane root = new Pane(canvas);
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setTitle("Correct Drawing");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
