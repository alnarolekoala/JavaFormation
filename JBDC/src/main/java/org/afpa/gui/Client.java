package org.afpa.gui;


import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Client {
    private  String nom;
    private  String id;
    private  String url;

    /**
     *Constructeur par défaut
     */
    public Client() {}

    /**
     * Constructeur avec paramètres
     * @param p : nom du client
     * @param n :id du client
     * @param v :url du client
     */
    public Client(String p, String n, String v) {
        this.id = p;
        this.nom = n;
        this.url = v;
    }
    //Getters and Setters
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}
