package biblio.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.controller.ChargerPropertiesController;
import biblio.dao.ConnectionFactory;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Utilisateur;

public class TestMonterDatabase {
    public static void main(String[] args) {
        ChargerPropertiesController cpc = new ChargerPropertiesController("jdbc.properties");
        try {
            cpc.chargerProperties();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ConnectionFactory cf = new ConnectionFactory();
        Connection cnx = null;
        try {
            cnx = cf.getConnectionSansAutoCommit(cpc.getDriver(), cpc.getUrl(), cpc.getUser(), cpc.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(cnx);
        try {
            utilisateurs = (ArrayList<Utilisateur>)utilisateurDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        utilisateurs.forEach((t) -> System.out.println(t));
    }
}
