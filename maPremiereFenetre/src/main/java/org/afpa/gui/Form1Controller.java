package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Form1Controller {
    public Button buttonVider;
    public Button buttonCalculer;
    public Button button9;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button4;
    public Button button3;
    public Button button2;
    public Button button1;
    public Button button0;
    public TextArea textarea1;
    public int resultat;

    public void addNumber(ActionEvent e ) {
        Button bouttonPousser = (Button) e.getSource();
        textarea1.setText(textarea1.getText()+"+"+bouttonPousser.getText() );
        resultat += Integer.parseInt(bouttonPousser.getText());
    }
    public void calcul(ActionEvent actionEvent) {
        textarea1.setText(String.valueOf("+"+resultat));
    }
    public void resetCalculatrice(ActionEvent actionEvent) {
        textarea1.setText("");
        resultat = 0;
    }
}
