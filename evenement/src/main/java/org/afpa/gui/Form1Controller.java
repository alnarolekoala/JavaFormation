package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;


public class Form1Controller {


    public TitledPane choixPane;
    public CheckBox checkboxCouleurFond;
    public CheckBox checkboxCouleurText;
    public CheckBox checkboxCasse;
    public TextField textField;
    public Label labelField;
    public TitledPane cassePane;
    public RadioButton lowerCaseRadio;
    public RadioButton upperCaseRadio;
    public RadioButton redTextRadio;
    public TitledPane textPane;
    public RadioButton whiteTextRadio;
    public RadioButton blackTextRadio;
    public TitledPane colorPane;
    public RadioButton redRadio;
    public RadioButton greenRadio;
    public RadioButton blueRadio;
    public ToggleGroup fond;
    public ToggleGroup texte;
    public ToggleGroup casse;

    public void makeChoice(ActionEvent actionEvent) {
        if(checkboxCouleurText.isSelected()){
            textPane.setDisable(false);
        }
        else {
            textPane.setDisable(true);
            blackTextRadio.setSelected(false);
            whiteTextRadio.setSelected(false);
            redTextRadio.setSelected(false);
            textColorChoice(actionEvent);
        }

        if(checkboxCouleurFond.isSelected()){
            colorPane.setDisable(false);
        }
        else {
            redRadio.setSelected(false);
            greenRadio.setSelected(false);
            blueRadio.setSelected(false);
            colorChoice(actionEvent);
            colorPane.setDisable(true);

        }

        if(checkboxCasse.isSelected()){
            cassePane.setDisable(false);
        }
        else {
            cassePane.setDisable(true);
        }
    }

    public void writeOn(KeyEvent keyEvent) {
        this.labelField.setText(this.textField.getText());
        if(textField.getText().isEmpty()) {
            this.choixPane.setDisable(true);
            this.checkboxCouleurFond.setSelected(false);
            this.checkboxCouleurText.setSelected(false);
            this.checkboxCasse.setSelected(false);
            colorPane.setDisable(true);
            cassePane.setDisable((true));
            textPane.setDisable(true);
            redTextRadio.setSelected(false);
            whiteTextRadio.setSelected(false);
            redTextRadio.setSelected(false);
            redRadio.setSelected(false);
            blueRadio.setSelected(false);
            greenRadio.setSelected(false);
            lowerCaseRadio.setSelected(false);
            upperCaseRadio.setSelected(false);
        }
        else {
            lowerCaseRadio.setSelected(false);
            upperCaseRadio.setSelected(false);
            this.choixPane.setDisable(false);

        }
    }

    public void casseChoice(ActionEvent actionEvent) {
        casse.getSelectedToggle();
        if(upperCaseRadio.isSelected()){
            labelField.setText(labelField.getText().toUpperCase());
        }
        if(lowerCaseRadio.isSelected()){
            labelField.setText(labelField.getText().toLowerCase());
        }
    }

    public void textColorChoice(ActionEvent actionEvent) {
        texte.getSelectedToggle();
        if(redTextRadio.isSelected() || whiteTextRadio.isSelected() || blackTextRadio.isSelected()) {
            if (redTextRadio.isSelected()) {
                String style = labelField.getStyle();
                labelField.setStyle(style + "-fx-text-fill: red;" );

            }
            if (whiteTextRadio.isSelected()) {
                String style = labelField.getStyle();
                labelField.setStyle(style + "-fx-text-fill: white;");
            }
            if (blackTextRadio.isSelected()) {
                String style = labelField.getStyle();
                labelField.setStyle(style + "-fx-text-fill: black;");
            }
        }
        else {
            String style = labelField.getStyle();
            labelField.setStyle(style + "-fx-text-fill: black;");
        }
    }


    public void colorChoice(ActionEvent actionEvent) {
        fond.getSelectedToggle();
       if(redRadio.isSelected() || blueRadio.isSelected() || greenRadio.isSelected()) {
           if (redRadio.isSelected()) {
               String style = labelField.getStyle();
               labelField.setStyle(style +"-fx-background-color: red;");
           }
           if (blueRadio.isSelected()) {
               String style = labelField.getStyle();
               labelField.setStyle(style +"-fx-background-color: blue;");
           }
           if (greenRadio.isSelected()) {
               String style = labelField.getStyle();
               labelField.setStyle(style +"-fx-background-color: green;");
           }
       }
       else {
           String style = labelField.getStyle();
           labelField.setStyle(style +"-fx-background-color: light-grey;");
       }
    }
}

