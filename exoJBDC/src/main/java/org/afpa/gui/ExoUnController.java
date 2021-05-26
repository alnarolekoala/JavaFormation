package org.afpa.gui;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.afpa.Main;
import org.afpa.model.fournis;
import org.afpa.model.fournisDAO;
import java.io.IOException;


public class ExoUnController {
    public TextField textFieldCodeFournisseur;
    public Button rechercheButton;
    public TextField nameField;
    public TextField adressField;
    public TextField cityNameField;
    public TextField CpField;
    public TextField contactField;
    public Button returnButton;
    public Pane pageExoUn;
    public Tooltip toolTip;
    public Button aide;

    @FXML
    public void initialize(){
            aide.disabledProperty();
            toolTip.setText("Id possible : ");
        try {
            fournisDAO ini = new fournisDAO();
            ObservableList<Object> donnee =  ini.findAllId();
            for (int i = 0; i < donnee.size(); i++) {
                if(i +1 == donnee.size()){
                    toolTip.setText(toolTip.getText()+ donnee.get(i)+"." );
                }else
                {
                    toolTip.setText(toolTip.getText()+ donnee.get(i)+", " );
                }
            }


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Probleme survenu");
            alert.setHeaderText(null);
            alert.setContentText("Erreur");
            alert.showAndWait();

        }
    }
    /**
     * Rempli les champs en fonction du fournisseur selectionné (Event)
     * @param actionEvent
     */
    public void ChercheInfo(ActionEvent actionEvent) {
        fournisDAO test = new fournisDAO();
        try {
            fournis resultat = test.find(Integer.valueOf(textFieldCodeFournisseur.getText()));
            if(resultat.getNomfou().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Probleme survenu");
                alert.setHeaderText(null);
                alert.setContentText("Numero de fournisseur inconnu, aucune action valide");
                alert.showAndWait();
            }else {
                nameField.setText(resultat.getNomfou());
                adressField.setText(resultat.getRuefou());
                cityNameField.setText(resultat.getVilfou());
                CpField.setText(resultat.getPosfou());
                contactField.setText((resultat.getConfou()));
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Probleme survenu");
            alert.setHeaderText(null);
            alert.setContentText("Numero de fournisseur inconnu, aucune action valide");
            alert.showAndWait();

        }
    }

    /**
     * retour index (Event)
     * @param actionEvent
     * @throws IOException
     */
    public void retourIndex(ActionEvent actionEvent) throws IOException {
       Main.changePage("index");
    }
}


