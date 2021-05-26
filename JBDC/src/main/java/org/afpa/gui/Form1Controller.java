package org.afpa.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Form1Controller {

    @FXML
    private TableView<Client> lst_clients;
    @FXML
    private TableColumn<Client, String> col_id;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_url;

    ObservableList<Client> model = FXCollections.observableArrayList();
    public TextField txt_id;
    public TextField txt_nom;
    public TextField txt_url;
    public Button btn_save;
    public Button btn_cancel;
    public Button btn_delete;



    public void initialize() {

        try
        {

            String url ="jdbc:mysql://localhost:3306/record?serverTimezone=UTC";
            Connection con= DriverManager.getConnection(url,"root","67f6d8355");

            PreparedStatement stm = con.prepareStatement("SELECT * FROM artist WHERE artist_id<?");


            stm.setInt(1,50);
            //executeQuery correspond à la demande d'exécution de la
            // requête. La variable result ( ResultSet ) est
            // l'ensemble des résultats renvoyés par la requête
            ResultSet result = stm.executeQuery ();

            //next renvoie true lorsqu'il existe un enregistrement supplémentaire
            while(result.next())
            {
                //conversion du résultat dans le bon type
                int X=result.getInt(1);
                String Y=result.getString(2);
                String Z = result.getString(3);
                model.add(new Client(String.valueOf(X), Y, Z));

            }
            //il est recommandé de fermer les objets Statement et Resultset
            stm.close();
            result.close();

            //On rend le tableau non-éditable
            lst_clients.setEditable(true);

            // Jonction du tableau avec les données
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_url.setCellValueFactory(new PropertyValueFactory<>("url"));

            // On indique au TableView quelle modèle observer pour trouver les données
            lst_clients.setItems(model);

        }
        catch(Exception a)
        {
            System.out.println(0);
        }
    }

    public void add(ActionEvent actionEvent) {

        try
        {

            String url ="jdbc:mysql://localhost:3306/record?serverTimezone=UTC";
            Connection con= DriverManager.getConnection(url,"root","67f6d8355");

            PreparedStatement stm = con.prepareStatement("INSERT INTO artist VALUES (?,?,?)");

            stm.setInt(1, Integer.valueOf(txt_id.getText()));
            stm.setString(2, txt_nom.getText());
            stm.setString(3, txt_url.getText());
            stm.executeUpdate ();

            //il est recommandé de fermer les objets Statement et Resultset
            stm.close();
            PreparedStatement requete = con.prepareStatement("SELECT * FROM artist WHERE artist_id=?");

            requete.setInt(1, Integer.valueOf(txt_id.getText()));
            ResultSet result = requete.executeQuery ();
            while(result.next())
            {
                //conversion du résultat dans le bon type
                int X=result.getInt(1);
                String Y=result.getString(2);
                String Z = result.getString(3);
                model.add(new Client(String.valueOf(X), Y, Z));

            }
            //il est recommandé de fermer les objets Statement et Resultset
            requete.close();
            result.close();




        }
        catch(Exception a)
        {
            System.out.println(0);
        }

        txt_id.clear();
        txt_nom.clear();
        txt_url.clear();
    }

    public void update(ActionEvent actionEvent) {
        int focus = Integer.valueOf(lst_clients.getSelectionModel().getSelectedItem().getId());
        if(!(txt_id.getText().isEmpty())) {
            lst_clients.getSelectionModel().getSelectedItem().setId(txt_id.getText());
        }
        if(!(txt_nom.getText().isEmpty())) {
            lst_clients.getSelectionModel().getSelectedItem().setNom(txt_nom.getText());
        }
        if(!(txt_url.getText().isEmpty())) {
            lst_clients.getSelectionModel().getSelectedItem().setUrl(txt_url.getText());
        }
        try
        {

            String url ="jdbc:mysql://localhost:3306/record?serverTimezone=UTC";
            Connection con= DriverManager.getConnection(url,"root","67f6d8355");

            PreparedStatement stm = con.prepareStatement("UPDATE artist SET artist_id= ?, artist_name= ? , artist_url= ? WHERE artist_id=?");


            stm.setInt(1,Integer.valueOf(lst_clients.getSelectionModel().getSelectedItem().getId()));
            stm.setString(2,lst_clients.getSelectionModel().getSelectedItem().getNom());
            stm.setString(3,lst_clients.getSelectionModel().getSelectedItem().getUrl());
            stm.setInt(4,focus);
            stm.executeUpdate();
            //il est recommandé de fermer les objets Statement et Resultset
            stm.close();

        }
        catch(Exception a)
        {
            System.out.println("erreur à la modification");
        }
        lst_clients.refresh();


    }

    public void delete(ActionEvent actionEvent) {


   
        try
        {

            String url ="jdbc:mysql://localhost:3306/record?serverTimezone=UTC";
            Connection con= DriverManager.getConnection(url,"root","67f6d8355");

            PreparedStatement stm = con.prepareStatement("DELETE FROM artist WHERE artist_id=?");

            int param = Integer.valueOf(lst_clients.getSelectionModel().getSelectedItem().getId());
            stm.setInt(1,param);
            stm.executeUpdate();
            //il est recommandé de fermer les objets Statement et Resultset
            stm.close();

        }
        catch(Exception a)
        {
            System.out.println("erreur à la supression");
        }
        model.remove(lst_clients.getSelectionModel().getSelectedIndex());
    }
}
