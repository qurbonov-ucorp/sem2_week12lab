package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Type here to log keys...");

        TextArea logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefRowCount(5);

        inputField.setOnKeyPressed(e -> {
            String log = String.format("PRESSED  | Code: %-10s | Shift: %-5b | Ctrl: %-5b\n", 
                                        e.getCode(), e.isShiftDown(), e.isControlDown());
            logArea.appendText(log);
        });

        inputField.setOnKeyReleased(e -> {
            String log = String.format("RELEASED | Code: %-10s\n", e.getCode());
            logArea.appendText(log);
        });

        inputField.setOnKeyTyped(e -> {
            String log = String.format("TYPED    | Char: %s\n", e.getCharacter());
            logArea.appendText(log);
        });

        Button clearBtn = new Button("Clear Log");
        clearBtn.setOnAction(e -> logArea.clear());

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(inputField, logArea, clearBtn);

        Scene scene = new Scene(root, 420, 320);
        primaryStage.setTitle("Key Event Logger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
