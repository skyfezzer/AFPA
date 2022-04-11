package biblio.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import biblio.controller.ChargerPropertiesController;
import biblio.dao.AdherentDAO;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDAO;
import biblio.dao.LivreDAO;
import biblio.dao.PretDAO;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Adherent;
import biblio.domain.Exemplaire;
import biblio.domain.Livre;
import biblio.domain.Pret;
import biblio.domain.Utilisateur;

public class Test3Emprunts {
	UtilisateurDAO utilisateurDAO = null;
	LivreDAO livreDAO = null;
	ExemplaireDAO exemplaireDAO = null;
	PretDAO pretDAO = null;
	AdherentDAO adherentDAO = null;

	Connection cnx = null;

	Utilisateur emp = null;
	Utilisateur adh = null;
	Pret pret = null;
	Exemplaire exemp1 = null;
	Exemplaire exemp2 = null;

	public static void main(String[] args) {
		Test3Emprunts testProgram = new Test3Emprunts();
		testProgram.init();
		if (testProgram.cnx != null) {
			testProgram.start();
		}

		testProgram.exit();

	}

	private void exit() {
		if (cnx != null) {
			try {
				cnx.rollback();
				cnx.close();
				System.out.println();
				System.out.println("Tout s'est déroulé OK, on a rollback. Fin du test.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void start() {
		while (JOptionPane.showConfirmDialog(null, "Créer un nouvel emprunt ?", "Nouvel emprunt",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			showCreationPretDialog();
		}
	}

	private void showCreationPretDialog() {
		JOptionPane.showMessageDialog(null, "Création d'un prêt.");
		Integer noUtil = null;
		Utilisateur user = showUtilisateurParIDDialog();
		try {
			if (!user.isEmploye() && !adherentDAO.isEnRegle((Adherent) user)) {
				System.out.println(
						"L'utilisateur est un adhérent qui n'est pas autorisé à emprunter de nouveaux livres. Passage à la suite.");
				JOptionPane.showMessageDialog(null,
						"L'utilisateur est un adhérent qui n'est pas autorisé à emprunter de nouveaux livres. Passage à la suite.");
				return;
			}
		} catch (SQLException e) {
			System.err.println("Une erreur SQL est survenue, on arrête et passe à la suite.");
			e.printStackTrace();
			return;
		}
		Exemplaire ex = showExemplaireParIDDialog();

		creaEmprunt(ex, user);
	}

	private Utilisateur showUtilisateurParIDDialog() {
		//
		//
		// Un Utilisateur par son ID (TEST : 1)
		//
		Utilisateur result = null;
		Integer noUtil = null;
		do {
			String input = JOptionPane.showInputDialog(null, "Entrez le n°utilisateur.", "Séléction d'un utilisateur",
					JOptionPane.QUESTION_MESSAGE);
			if (input == null)
				break;

			try {
				noUtil = Integer.parseInt(input);
				result = unUtilisateurParId(noUtil);
			} catch (NumberFormatException e) {
				System.err.println("Impossible de parser le no Employé.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (noUtil == null);
		return result;
	}

	private Exemplaire showExemplaireParIDDialog() {
		//
		//
		// Un exemplaire par son ID
		JOptionPane.showMessageDialog(null, "Sélection d'un exemplaire.");
		String[] split_result = {};
		Exemplaire result = null;

		do {
			String input = JOptionPane.showInputDialog(null,
					"Entrez le n° ISBN suivi de du code d'exemplaire séparés d'un espace.", "Sélection Exemplaire",
					JOptionPane.QUESTION_MESSAGE);
			if (input == null)
				break;
			split_result = input.split(" ");
			try {
				int isbn = Integer.parseInt(split_result[0]);
				int noEx = Integer.parseInt(split_result[1]);
				// System.out.println("input : isbn<" + isbn + "> codeEx.<"+noEx+">");
				result = unExemplaireParSonId(isbn, noEx);
			} catch (NumberFormatException e) {
				System.err.println("Impossible de parser l'isbn et le no exemplaire.");
			}
		} while (split_result.length != 2);

		return result;
	}

	private Utilisateur unUtilisateurParId(int id) throws SQLException {
		System.out.println();
		System.out.println("> Demande d'un utilisateur par son id (" + id + ") aux DAO :");
		Utilisateur adh = utilisateurDAO.findByKey(id);

		System.out.println("Utilisateur pour idUtilisateur (" + id + ") : \n\t" + adh);
		return adh;

	}

	// DEMANDE DE DEUX EXEMPLAIRES PAR LEUR ID AUX DAO
	private Exemplaire unExemplaireParSonId(int isbn, int noEx) {
		Exemplaire exemp1 = null;
		System.out.println();
		System.out.println("> Demande d'un exemplaire (" + isbn + ":" + noEx + ") par son ID aux DAOs");
		try {
			Livre livreOrigine = livreDAO.findByKey(isbn);
			exemp1 = exemplaireDAO.findByKey(isbn, noEx);
			exemp1.setLivre(livreOrigine);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Exemplaire: \n\t" + exemp1);
		return exemp1;
	}

	private void creaEmprunt(Exemplaire ex, Utilisateur user) {
		System.out.println();
		System.out.println("> Création d'un emprunt pour un " + (user.isEmploye()?"Employé":"Adhérent"));
		
		try {
			if(exemplaireDAO.isDisponible(ex)) {
				if(!user.isEmploye()) {
					System.out.println("Vérification des règles métier...");
					if(!adherentDAO.isEnRegle((Adherent)user)) {
						System.out.println("Problème avec l'adhérent :");
						System.out.println(">\t" + user);
						System.out.println("L'adhérent n'est pas en règle. Impossible de créer un emprunt.");
						return;
					}
				}
				Pret newPret = new Pret(null, new Date(System.currentTimeMillis()), null, ex, null, user);
				Integer idPret = pretDAO.insert(newPret);
				System.out.println("L'emprunt a été créé avec l'id : " + idPret);
			}else {
				System.out.println("L'exemplaire : " + ex);
				System.out.println("\tn'est pas disponible.");
			}	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void init() {
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

		utilisateurDAO = new UtilisateurDAO(cnx);
		pretDAO = new PretDAO(cnx);
		exemplaireDAO = new ExemplaireDAO(cnx);
		livreDAO = new LivreDAO(cnx);
		adherentDAO = new AdherentDAO(cnx);
	}

}
