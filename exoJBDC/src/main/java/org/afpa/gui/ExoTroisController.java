package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.afpa.Main;
import org.afpa.model.fournis;
import org.afpa.model.fournisDAO;

import java.io.IOException;

public class ExoTroisController {

    public Button boutonAjout;
    public Button retourIndexButton;
    public TextField villeField;
    public TextField rueField;
    public TextField cpField;
    public TextField contactField;
    public TextField nameField;
    private int valide=0;
    /**
     * Ajout de fournisseur dans la BDD (Event)
     * @param actionEvent
     */
    public void addFournis(ActionEvent actionEvent) {
        controleChamps();
        if (valide == 0) {
            fournis test = new fournis(nameField.getText(),rueField.getText(),cpField.getText(),villeField.getText(),contactField.getText());
            fournisDAO testAcces = new fournisDAO();
            testAcces.insert(test);
        }
        else {
            this.valide = 0;
        }

    }

    /**
     * Retour a la page index (Event)
     * @param actionEvent
     * @throws IOException
     */
    public void retourIndex(ActionEvent actionEvent) throws IOException {
        Main.changePage("index");
    }

    /**
     * Method qui permet de contrôler les champs d'ajout de fournisseur.
     */
    public void controleChamps(){

        if(nameField.getText().isEmpty() || rueField.getText().isEmpty() || cpField.getText().isEmpty() || villeField.getText().isEmpty() || contactField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention ! ");
            alert.setHeaderText(null);
            alert.setContentText("Certain champs sont vide !");
            alert.showAndWait();
            this.valide = 1;
            if(nameField.getText().isEmpty()){
                nameField.setStyle("-fx-border-color: red");
            }
            else {
                nameField.setStyle("-fx-border-color: green");
            }
            if(rueField.getText().isEmpty()){
                rueField.setStyle("-fx-border-color: red");
            }
            else {
                rueField.setStyle("-fx-border-color: green");
            }
            if(cpField.getText().isEmpty()){
                cpField.setStyle("-fx-border-color: red");
            }
            else {
                cpField.setStyle("-fx-border-color: green");
            }
            if(villeField.getText().isEmpty()){
                villeField.setStyle("-fx-border-color: red");
            }
            else {
                villeField.setStyle("-fx-border-color: green");
            }
            if(contactField.getText().isEmpty()){
                contactField.setStyle("-fx-border-color: red");
            }
            else {
                contactField.setStyle("-fx-border-color: green");
            }


        }
        else {

            if(cpField.getText().length() != 5 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention ! ");
                alert.setHeaderText(null);
                alert.setContentText("Le code Postal se compose de 5 chiffres !");
                alert.showAndWait();
                this.valide = 2;
            }
            else {
              try {
                  Integer.parseInt(cpField.getText());
              }
              catch (NumberFormatException e) {
                  this.valide = 3;
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Attention ! ");
                  alert.setHeaderText(null);
                  alert.setContentText("Le code Postal se compose de chiffres uniquement !");
                  alert.showAndWait();
              }
            }
        }
    }
}
