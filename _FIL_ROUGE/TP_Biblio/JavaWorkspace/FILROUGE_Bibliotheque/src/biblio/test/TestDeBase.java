package biblio.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import biblio.controller.ChargerPropertiesController;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDAO;
import biblio.dao.LivreDAO;
import biblio.dao.PretDAO;
import biblio.dao.UtilisateurDAO;
import biblio.domain.Adherent;
import biblio.domain.Employe;
import biblio.domain.Exemplaire;
import biblio.domain.Livre;
import biblio.domain.Pret;
import biblio.domain.Utilisateur;

public class TestDeBase {
    UtilisateurDAO utilisateurDAO = null;
    LivreDAO livreDAO = null;
    ExemplaireDAO exemplaireDAO = null;
    PretDAO pretDAO = null;
    Connection cnx = null;

	Utilisateur emp = null;
	Utilisateur adh = null;
	Pret pret = null;
	Exemplaire exemp1 = null;
	Exemplaire exemp2 = null;
    
    public static void main(String[] args) {
        TestDeBase testProgram = new TestDeBase();
        testProgram.init();
        if(testProgram.cnx != null){
            testProgram.start();
        }

        testProgram.exit();

    }

	private void start(){
        System.out.println("Demarrage des tests");
        deuxExemplairesParId(0,16,19);
        unAdherentParId(25);
        unEmployeParId(1);
        creaEmprunt(exemp1, (Employe)emp);
        creaEmprunt(exemp2, (Adherent)adh);
    }

    private void exit() {
        if(cnx != null){
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
    }

    

    	// DEMANDE D'UN EMPLOYE PAR SON ID AUX DAO
	private void unEmployeParId(int id) {
		System.out.println();
		System.out.println("> Demande d'un employé par son id ("+id+") aux DAO :");
		try {
			emp = utilisateurDAO.findByKey(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Employé pour idUtilisateur ("+id+") : \n\t" + emp);
		System.out.println("\n");

	}

	// DEMANDE D'UN ADHERENT PAR SON ID AUX DAO
	private void unAdherentParId(int id) {
		System.out.println();
		System.out.println("> Demande d'un adhérent par son id ("+id+") aux DAO :");
		try {
			adh = utilisateurDAO.findByKey(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Adhérent pour idUtilisateur ("+id+") : \n\t" + adh);
		
	}

	// DEMANDE DE DEUX EXEMPLAIRES PAR LEUR ID AUX DAO
	private void deuxExemplairesParId(int isbn, int ex1, int ex2) {
		System.out.println();
		System.out.println("> Demande de deux exemplaires (" + isbn + ":" + ex1 + "," + ex2 + ") par leur ID aux DAOs");
		try {
			Livre livreOrigine = livreDAO.findByKey(isbn);
			exemp1 = exemplaireDAO.findByKey(isbn,ex1);
			exemp1.setLivre(livreOrigine);
			exemp2 = exemplaireDAO.findByKey(isbn,ex2);
			exemp2.setLivre(livreOrigine);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Exemplaire 1 : \n\t"+exemp1);
		System.out.println("Exemplaire 2 : \n\t"+exemp2);
	}

	
	private void creaEmprunt(Exemplaire ex, Utilisateur user) {
		System.out.println();
		System.out.println("> Création d'un emprunt pour un " + (user.isEmploye()?"Employé":"Adhérent"));
		
		try {
			if(exemplaireDAO.isDisponible(ex)) {
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
}
