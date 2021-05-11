package org.afpa.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Form1Controller {

    @FXML
    private TableView<Client> lst_clients;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_ville;

    ObservableList<Client> model = FXCollections.observableArrayList();
    public TextField txt_prenom;
    public TextField txt_nom;
    public TextField txt_ville;
    public Button btn_save;
    public Button btn_cancel;
    public Button btn_delete;



    public void initialize() {
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        //On rend le tableau non-éditable
        lst_clients.setEditable(false);

        // Jonction du tableau avec les données
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // On indique au TableView quelle modèle observer pour trouver les données
        lst_clients.setItems(model);

    }

    public void save(ActionEvent actionEvent) {
        model.add(new Client(txt_prenom.getText(), txt_nom.getText(), txt_ville.getText()));
        txt_ville.clear();
        txt_nom.clear();
        txt_prenom.clear();
    }

    public void cancel(ActionEvent actionEvent) {
        txt_ville.clear();
        txt_nom.clear();
        txt_prenom.clear();
    }

    public void delete(ActionEvent actionEvent) {

        model.remove(lst_clients.getSelectionModel().getSelectedIndex());
    }
}
