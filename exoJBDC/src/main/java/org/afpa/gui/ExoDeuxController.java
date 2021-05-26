package org.afpa.gui;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.afpa.Main;
import org.afpa.model.entcom;
import org.afpa.model.entcomDAO;
import org.afpa.model.fournisDAO;

import java.io.IOException;

public class ExoDeuxController {
    public ComboBox dropDown;
    public TextArea textareaListe;
    public Button boutonRetour;

    @FXML
    /**
     * method qui charge des informations des le début
     */
    public void initialize(){
        fournisDAO test = new fournisDAO();
            dropDown.setItems(test.list());
    }

    /**
     * methode qui permet d'afficher les commandes des fournisseurs en fonction de celui selectionné (Event)
     * @param actionEvent
     */
    public void chargementCommande(ActionEvent actionEvent) {
        textareaListe.setText("");
        if(!(dropDown.getSelectionModel().isEmpty())) {
            entcomDAO commande = new entcomDAO();
            ObservableList<Object> donnee = commande.select(dropDown.getSelectionModel().getSelectedItem().toString());

            for (int i = 0; i < donnee.size(); i++) {
                textareaListe.setText(textareaListe.getText()+ donnee.get(i)+"\n" );
            }
        }
    }

    /**
     * Methode de retour a l'index de l'app (Event)
     * @param actionEvent
     * @throws IOException
     */
    public void retourIndex(ActionEvent actionEvent) throws IOException {
        Main.changePage("index");
    }
}
