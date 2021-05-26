package org.afpa.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.afpa.gui.ConnexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class entcomDAO extends ConnexionBDD {

    Connection con = null;
    /**
     * Renvoie des commandes en fonction du fournisseur
     * @param test correspond au contenu de la colonne nomfou en String
     * @return
     */
    public ObservableList<Object> select(String test) {
        ObservableList<Object> list = FXCollections.observableArrayList();
        try {
            con = getConnexion(con);
            if(test != "Tous"){
                PreparedStatement stm = con.prepareStatement(" SELECT * FROM entcom JOIN fournis ON fournis.numfou = entcom.numfou  WHERE fournis.nomfou = ?");
                stm.setString(1, test);
                // execution de la requete
                ResultSet resultat = stm.executeQuery();

                // tant qu'il ya des resultats

                while(resultat.next()){
                    list.add(resultat.getObject("datcom")+" "+ resultat.getObject("obscom"));
                }
                stm.close();
                con.close();
                System.out.println("réussi");
            }
            else {
                PreparedStatement stm = con.prepareStatement(" SELECT * FROM entcom JOIN fournis ON fournis.numfou = entcom.numfou");
                // execution de la requete
                ResultSet resultat = stm.executeQuery();
                // tant qu'il ya des resultats
                while(resultat.next()){
                    list.add(resultat.getObject("datcom")+" "+ resultat.getObject("obscom"));
                }
                stm.close();
                con.close();
                System.out.println("réussi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
