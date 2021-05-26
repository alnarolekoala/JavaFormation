package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.afpa.Main;

import java.io.IOException;

public class IndexController {
    public Button exoUn;
    public Button exoDeux;
    public Button exoTrois;

    public void goExoUn(ActionEvent actionEvent) throws IOException {
        exoUn.setStyle("-fx-border-color: grey;");
        Main.changePage("exoUn");
    }

    public void goExoDeux(ActionEvent actionEvent) throws IOException {
        Main.changePage("exoDeux");
    }

    public void goExoTrois(ActionEvent actionEvent) throws IOException {
        Main.changePage("exoTrois");
    }
}
