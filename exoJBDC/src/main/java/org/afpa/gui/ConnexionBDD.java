package org.afpa.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnexionBDD {
    /**
     * Methode qui permet de se connecter a la BDD
     * @param con
     * @return con
     * @throws SQLException
     */
    public  Connection getConnexion(Connection con) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/papyrus?serverTimezone=UTC";
            con = DriverManager.getConnection(url, "root", "67f6d8355");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
