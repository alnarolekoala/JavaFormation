package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Form1Controller {

    public Label melangeur;
    public Label redLabel;
    public Label blueLabel;
    public Label greenLabel;
    public Slider redSlidder;
    public Slider greenSlider;
    public Slider blueSlider;

    public void melange(MouseEvent mouseEvent) {
        melangeur.setStyle("-fx-background-color: rgb("+redSlidder.getValue()+","+greenSlider.getValue()+","+blueSlider.getValue()+");");
    }
}
