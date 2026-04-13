package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import ...

public class DraggableCircle extends Application {
    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(500, 400);

        Circle circle = new Circle(250, 200, 40, Color.CORAL);

        circle.setOnMousePressed(e -> {
            circle.setFill(Color.TOMATO);
            offsetX = e.getSceneX() - circle.getCenterX();
            offsetY = e.getSceneY() - circle.getCenterY();
        });

        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getSceneX() - offsetX);
            circle.setCenterY(e.getSceneY() - offsetY);
        });

        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.CORAL);
        });

        root.getChildren().add(circle);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Draggable Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
