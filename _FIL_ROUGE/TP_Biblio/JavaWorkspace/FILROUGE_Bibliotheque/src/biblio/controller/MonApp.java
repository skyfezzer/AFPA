package biblio.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import biblio.dao.AdherentDAO;
import biblio.dao.AuteurDAO;
import biblio.dao.BibliothequeDAO;
import biblio.dao.ConnectionFactory;
import biblio.dao.DetteDAO;
import biblio.dao.EmplacementDAO;
import biblio.dao.ExemplaireDAO;
import biblio.dao.LivreDAO;
import biblio.dao.PretDAO;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Exemplaire;
import biblio.domain.Livre;
import biblio.domain.Utilisateur;

public class MonApp {
	private Connection cnx = null;

	private UtilisateurDAO utilisateurDAO;
	private AuteurDAO auteurDAO;
	private BibliothequeDAO biblioDAO;
	private DetteDAO detteDAO;
	private EmplacementDAO emplacementDAO;
	private ExemplaireDAO exemplaireDAO;
	private LivreDAO livreDAO;
	private PretDAO pretDAO;
	private AdherentDAO adherentDAO;

	public static void main(String[] args) {
		MonApp app = new MonApp();
		app.start();
		
	}

	private void start() {
		ChargerPropertiesController cpc = new ChargerPropertiesController("jdbc.properties");
		try {
			cpc.chargerProperties();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// On commence par récupérer l'instance de la connexion SANS AUTO-COMMITS vers
		// la DB Oracle.
		ConnectionFactory cf = new ConnectionFactory();
		try {
			cnx = cf.getConnectionSansAutoCommit(cpc.getDriver(), cpc.getUrl(), cpc.getUser(), cpc.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// cannot load the driver, exit app.
			JOptionPane.showMessageDialog(null, "Cannot load the driver", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			// cannot connect to the database, exit app.
			JOptionPane.showMessageDialog(null, "Cannot connect to the database", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);

		}

		// instanciate every DAO.
		utilisateurDAO = new UtilisateurDAO(cnx);
		auteurDAO = new AuteurDAO(cnx);
		biblioDAO = new BibliothequeDAO(cnx);
		detteDAO = new DetteDAO(cnx);
		emplacementDAO = new EmplacementDAO(cnx);
		exemplaireDAO = new ExemplaireDAO(cnx);
		livreDAO = new LivreDAO(cnx);
		pretDAO = new PretDAO(cnx);
		adherentDAO = new AdherentDAO(cnx);


		deuxExemplairesParId();
		unAdherentParId();
		unEmployeParId();


		try {
			System.out.println("On rollback, fin du test.");
			cnx.rollback();
			System.out.println("On ferme la connexion.");
			cnx.close();
			System.out.println("Fin de l'app.");
			System.exit(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// DEMANDE D'UN EMPLOYE PAR SON ID AUX DAO
	private void unEmployeParId() {
		System.out.println();
		System.out.println("> Demande d'un employé par son id aux DAO :");
		Utilisateur user = null;
		try {
			user = utilisateurDAO.findByKey(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Employé pour idUtilisateur 1 : \n\t" + user);
		System.out.println("\n");

	}

	// DEMANDE D'UN ADHERENT PAR SON ID AUX DAO
	private void unAdherentParId() {
		System.out.println();
		System.out.println("> Demande d'un adhérent par son id aux DAO :");
		Utilisateur user = null;
		try {
			user = utilisateurDAO.findByKey(25);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Adhérent pour idUtilisateur 25 : \n\t" + user);
		
	}

	// DEMANDE DE DEUX EXEMPLAIRES PAR LEUR ID AUX DAO
	private void deuxExemplairesParId() {
		System.out.println();
		System.out.println("> Demande de deux exemplaires par leur ID aux DAOs");
		Exemplaire exemplaire1 = null, exemplaire2 = null;
		try {
			Livre livreOrigine = livreDAO.findByKey(0);
			exemplaire1 = exemplaireDAO.findByKey(0,16);
			exemplaire1.setLivre(livreOrigine);
			exemplaire2 = exemplaireDAO.findByKey(0,19);
			exemplaire2.setLivre(livreOrigine);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Exemplaire 1 : \n\t"+exemplaire1);
		System.out.println("Exemplaire 2 : \n\t"+exemplaire2);
	}

}
