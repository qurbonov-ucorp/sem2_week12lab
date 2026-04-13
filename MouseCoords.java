package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;

public class MouseCoords extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane centerPane = new StackPane();
        centerPane.setPrefSize(400, 300);
        centerPane.setStyle("-fx-background-color: lightblue;");

        Label coordLabel = new Label("Move the mouse over the pane");
        
        BorderPane root = new BorderPane();
        root.setCenter(centerPane);
        root.setBottom(coordLabel);
        BorderPane.setAlignment(coordLabel, javafx.geometry.Pos.CENTER);

        centerPane.setOnMouseMoved(e -> {
            coordLabel.setText(String.format("X: %.1f  Y: %.1f", e.getX(), e.getY()));
        });

        centerPane.setOnMouseClicked(e -> {
            Random rand = new Random();
            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);
            centerPane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b));
        });

        centerPane.setOnMouseExited(e -> {
            coordLabel.setText("Move the mouse over the pane");
        });

        Scene scene = new Scene(root);
        primaryStage.setTitle("Mouse Coordinates");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
