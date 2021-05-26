package org.afpa.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import org.afpa.gui.ConnexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

public class fournisDAO extends ConnexionBDD {
   public ResultSet resultat;
    fournis full = new fournis();
    Connection con = null;
    int id = 0;

    // constructeur par default
    public fournisDAO(){ }

    /**
     * Methode pour ajouter un fournisseur dans la BDD, prend en parametre une instance de la class 'fournis'
     * @param cli
     */
    public void insert(fournis cli) {

        try {
            con = getConnexion(con);
            // preparation de la requete
            PreparedStatement statement = con.prepareStatement("SELECT MAX(fournis.numfou) FROM fournis");
            resultat = statement.executeQuery();
            if (resultat.next()){
                // on assigne le max ID a une variable
                id= Integer.parseInt(resultat.getString(1));
            }
            statement.close();
            con.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("recuperation de l'id echoue"+e.getMessage());
            alert.showAndWait();
        }
        try{
            con = getConnexion(con);
            PreparedStatement stm = con.prepareStatement("INSERT INTO fournis(numfou,nomfou,ruefou,posfou,vilfou,confou) VALUES (?,?,?,?,?,?)");

            stm.setInt(1, id+1);
            stm.setString(2, cli.getNomfou().toUpperCase(Locale.ROOT));
            stm.setString(3, cli.getRuefou());
            stm.setString(4, cli.getPosfou());
            stm.setString(5, cli.getVilfou());
            stm.setString(6, cli.getConfou());
            // execution de la requete
            stm.executeUpdate();

            stm.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Fournisseur ajoute avec succes");
            alert.showAndWait();

        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention ! ");
            alert.setHeaderText(null);
            alert.setContentText("ajout du fournisseur échoué"+ e.getMessage());
            alert.showAndWait();

        }
    }

    public void update(fournis cli) {
        // méthode d'édition
    }

    public void delete(fournis cli) {
        // méthode de suppression
    }

    /**
     * Methode Select SQL avec parametre de selection (ID)
     * @param id
     * @return object de type 'fournis'
     */
    public fournis find(int id)     {
        try {
            con = getConnexion(con);
            PreparedStatement stm = con.prepareStatement("SELECT * from fournis WHERE numfou=?");
            stm.setInt(1, id);
            // execution de la requete
            resultat = stm.executeQuery();
            // tant qu'il ya des resultats
            while(resultat.next()){
                this.full = new fournis(
                        resultat.getInt("numfou"),
                        resultat.getString("nomfou"),
                        resultat.getString("ruefou"),
                        resultat.getString("posfou"),
                        resultat.getString("vilfou"),
                        resultat.getString("confou")
                );
            }
            stm.close();
            con.close();
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return full;
    }

    /**
     * Methode qui renvoie tout les ID des fournisseurs
     * @return ObservableList
     */
    public ObservableList<Object> findAllId()     {
        ObservableList<Object> list = FXCollections.observableArrayList();
        try {
            con = getConnexion(con);
            PreparedStatement stm = con.prepareStatement("SELECT numfou from fournis");

            // execution de la requete
            resultat = stm.executeQuery();
            // tant qu'il ya des resultats
            while(resultat.next()){
                list.add(resultat.getObject("numfou"));
            }
            stm.close();
            con.close();
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;
    }

    /**
     *
     * @return le nom de chaque fournisseur en ObservableList
     */
    public ObservableList<Object> list()     {
        ObservableList<Object> list = FXCollections.observableArrayList();
        // méthode de création de liste

        try {
            con = getConnexion(con);
            PreparedStatement stm = con.prepareStatement("SELECT * from fournis");

            // execution de la requete
            resultat = stm.executeQuery();

            // tant qu'il ya des resultats
            list.add("Tous");
            while(resultat.next()){
              list.add(resultat.getObject("nomfou"));
            }
            stm.close();
            con.close();
            System.out.println("réussi");
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;

    }


}