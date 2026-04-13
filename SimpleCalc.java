package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalc extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20));

        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        grid.add(new Label("Number 1:"), 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(new Label("Number 2:"), 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(new Label("Result:"), 0, 2);
        grid.add(resultField, 1, 2);

        Button calcBtn = new Button("Calculate");
        Button clearBtn = new Button("Clear");

        grid.add(calcBtn, 0, 3);
        grid.add(clearBtn, 1, 3);

        calcBtn.setOnAction(e -> {
            try {
                double n1 = Double.parseDouble(num1Field.getText());
                double n2 = Double.parseDouble(num2Field.getText());
                double sum = n1 + n2;
                resultField.setText(String.format("Sum: %.2f", sum));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input!");
            }
        });

        clearBtn.setOnAction(e -> {
            num1Field.clear();
            num2Field.clear();
            resultField.clear();
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
