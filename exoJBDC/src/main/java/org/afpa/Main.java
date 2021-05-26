package org.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public static Stage stage;
    public static Scene scene;
    public static void changePage(String nomFichier) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/" + nomFichier + ".fxml"));
        scene.setRoot(root);
        stage.hide();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/index.fxml"));
        scene = new Scene(root);
        stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/yuno.png")));
        stage.setTitle("Exercices");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
