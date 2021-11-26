package ru.job4j.test.km.three;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class QuadraticEquation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
            stage.setTitle("JavaFX");
            stage.setScene(new Scene(root, 800, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button decide;

    @FXML
    private TextField x1;

    @FXML
    private TextField x2;

    @FXML
    private TextField x3;
}
