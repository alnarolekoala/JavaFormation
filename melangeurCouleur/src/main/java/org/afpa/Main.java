package org.afpa;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
// 1
        Parent root = FXMLLoader.load(getClass().getResource("/org/afpa/gui/form1.fxml"));
// 2
        Scene scene = new Scene(root);
// 3
        primaryStage.setScene(scene);
// 4
        primaryStage.show();
    }
}
