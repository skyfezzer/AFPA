package biblio.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import biblio.controller.ChargerPropertiesController;
import biblio.dao.AdherentDAO;
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

public class TestEnRetard {
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
		TestEnRetard testProgram = new TestEnRetard();
		testProgram.init();
        if(testProgram.cnx != null){
            testProgram.start();
        }

        testProgram.exit();
		
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

	private void start() {
		try {
			System.out.println("On va créer un emprunt avec un Adhérent qui a un emprunt en retard.");
			Adherent adh = (Adherent) utilisateurDAO.findByKey(77);
			System.out.println("L'adhérent : \n\t" + adh);
			Pret pret = pretDAO.findByKey(4);
			System.out.println("Le pret en retard déjà dans la DB : \n\t" + pret);
			Livre nouvLivre = livreDAO.findByKey(8);
			Exemplaire nouvEx = exemplaireDAO.findByKey(8, 12);
			nouvEx.setLivre(nouvLivre);
			System.out.println("Un exemplaire aléatoire : \n\t" + nouvEx);
			System.out.println("On vérifie si l'exemplaire est disponible : " + exemplaireDAO.isDisponible(nouvEx));
			System.out.println("Maintenant, on va essayer de créer un nouveau prêt.");
			creaEmprunt(nouvEx, adh);
			System.out.println("On vérifie si l'exemplaire est toujours disponible : " + exemplaireDAO.isDisponible(nouvEx));
			System.out.println("\n==========");
			System.out.println("Même test avec un employé :");
			Employe emp = (Employe) utilisateurDAO.findByKey(7);
			System.out.println("L'employé : \n\t" + emp);
			pret = pretDAO.findByKey(5);
			System.out.println("Le pret en retard déjà dans la DB : \n\t" + pret);
			
			System.out.println("Maintenant, on va essayer de créer un nouveau prêt en reprenant l'exemplaire précédent.");
			creaEmprunt(nouvEx, emp);
			System.out.println("On vérifie si l'exemplaire est toujours disponible : " + exemplaireDAO.isDisponible(nouvEx));
			
		} catch (SQLException e) {
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
}
