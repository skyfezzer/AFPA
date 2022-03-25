package biblio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;
import biblio.dao.AuteurDAO;
import biblio.dao.BibliothequeDAO;
import biblio.dao.ConnectionFactory;
import biblio.dao.DetteDAO;
import biblio.dao.EmplacementDAO;
import biblio.dao.ExemplaireDAO;
import biblio.dao.LivreDAO;
import biblio.dao.PretDAO;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Adherent;
import biblio.domain.Exemplaire;
import biblio.domain.Livre;
import biblio.domain.Utilisateur;

public class MonApp {
	private String driver, url, user, password;
	private Connection cnx = null;

	private UtilisateurDAO utilisateurDAO;
	private AuteurDAO auteurDAO;
	private BibliothequeDAO biblioDAO;
	private DetteDAO detteDAO;
	private EmplacementDAO emplacementDAO;
	private ExemplaireDAO exemplaireDAO;
	private LivreDAO livreDAO;
	private PretDAO pretDAO;

	public static void main(String[] args) {
		MonApp app = new MonApp();
		ChargerPropertiesController cpc = new ChargerPropertiesController("jdbc.properties");
		app.start();
	}

	private void start() {
		// On commence par récupérer l'instance de la connexion SANS AUTO-COMMITS vers
		// la DB Oracle.
		ConnectionFactory cf = new ConnectionFactory();
		try {
			cnx = cf.getConnectionSansAutoCommit(driver, url, user, password);
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


		Adherent adh = new Adherent(1000, "JeSuisUn", "Test", "fakeTel", "fakePin");
		testNewAdherent(adh);

		deuxExemplairesParId();
		unAdherentParId();
		unEmployeParId();

	}

	private void unEmployeParId() {
		System.out.println();
		System.out.println("> Demande d'un employé par son id aux DAO :");
		Utilisateur employe = null;
		try {
			employe = utilisateurDAO.findUtilisateurByKey(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Employé pour idUtilisateur 1 : \n\t" + employe);
		System.out.println("\n");

	}

	private void unAdherentParId() {
		System.out.println();
		System.out.println("> Demande d'un adhérent par son id aux DAO :");
		Utilisateur adherent = null;
		try {
			adherent = utilisateurDAO.findUtilisateurByKey(25);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Adhérent pour idUtilisateur 25 : \n\t" + adherent);
		
	}

	// DEMANDE DE DEUX EXEMPLAIRES PAR LEUR ID AUX DAO
	private void deuxExemplairesParId() {
		System.out.println();
		System.out.println("> Demande de deux exemplaires par leur ID aux DAOs");
		Exemplaire exemplaire1 = null, exemplaire2 = null;
		try {
			Livre livreOrigine = livreDAO.findLivreByKey(0);
			exemplaire1 = exemplaireDAO.findExemplaireByKey(0,16);
			exemplaire1.setLivre(livreOrigine);
			exemplaire2 = exemplaireDAO.findExemplaireByKey(0,19);
			exemplaire2.setLivre(livreOrigine);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Exemplaire 1 : \n\t"+exemplaire1);
		System.out.println("Exemplaire 2 : \n\t"+exemplaire2);
	}

	private void loadProperties() {
		try (InputStream input = MonApp.class.getClassLoader().getResourceAsStream("jdbc.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property values
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			if ((password = prop.getProperty("pwd")) == null) {
				password = JOptionPane.showInputDialog("Mot de passe JDBC pour le user " + user + " :");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Erreur de chargement du fichier properties. Fin de l'application.");
			System.exit(1);
		}
	}
	
	private void testNewAdherent(Adherent testAdherent) {

		if (testAdherent == null)
			testAdherent = new Adherent(1000, "JeSuisUn", "Test", "fakeTel", "fakePin");

		System.out.println("On crée un adhérent, prêt à être inséré et manipulé :\n\t" + testAdherent);
		System.out.println("= ======== =\n");

		try {
			
			System.out.println("INSERT UTILISATEUR : " + utilisateurDAO.insertUtilisateur(testAdherent));
			System.out.println("SELECT UTILISATEUR : " + utilisateurDAO.findUtilisateurByKey(1000));
			System.out.println("DELETE UTILISATEUR : " + utilisateurDAO.deleteUtilisateur(testAdherent));
			System.out.println("SELECT UTILISATEUR : " + (testAdherent = (Adherent) utilisateurDAO.findUtilisateurByKey(1000)));
			System.out.println(testAdherent==null?"TEST OK":"TEST NOK");
			System.out.println("= ======== =\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
