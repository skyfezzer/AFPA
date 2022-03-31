package biblio.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import biblio.controller.ChargerPropertiesController;
import biblio.dao.AuteurDAO;
import biblio.dao.ConnectionFactory;
import biblio.dao.LivreDAO;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Auteur;
import biblio.domain.Livre;
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

        //                        //    
        //      UTILISATEURS      //
        //                        //
        System.out.println();
        System.out.println("UTILISATEURS");
        System.out.println();
        ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(cnx);
        try {
            utilisateurs = (ArrayList<Utilisateur>)utilisateurDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        utilisateurs.forEach((t) -> System.out.println(t));

        //                        //
        //       AUTEURS          //
        //                        //
        System.out.println();
        System.out.println("AUTEURS");
        System.out.println();
        ArrayList<Auteur> auteurs = new ArrayList<Auteur>();
        AuteurDAO auteurDAO = new AuteurDAO(cnx);
        try {
            auteurs = (ArrayList<Auteur>)auteurDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        auteurs.forEach((t) -> System.out.println(t));

        //                        //
        //        LIVRES          //
        //                        //
        ArrayList<Livre> livres = new ArrayList<Livre>();
        LivreDAO livreDAO = new LivreDAO(cnx);
        try {
            livres = (ArrayList<Livre>)livreDAO.findAll();
        } catch (SQLException e) {
            // TODO 
            e.printStackTrace();
            return;
        }
        livres.forEach((t) -> {
            try {
                Auteur auteurDuLivre = auteurDAO.findByLivre(t);
                t.setAuteur(auteurDuLivre);

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(t);
        });

        
    }
}
