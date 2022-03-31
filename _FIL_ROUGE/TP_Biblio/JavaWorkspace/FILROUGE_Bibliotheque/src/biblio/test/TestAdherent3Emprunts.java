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

public class TestAdherent3Emprunts {
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
		TestAdherent3Emprunts testProgram = new TestAdherent3Emprunts();
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
			System.out.println("On va créer plusieurs emprunt avec un Adhérent qui est en règle.");
			Adherent adh = (Adherent) utilisateurDAO.findByKey(14);
			System.out.println("L'adhérent : \n\t" + adh);
			List<Pret> prets = pretDAO.findAllByUtilisateur(adh);
			System.out.println("Tous les prêts de cet utilisateur :");
			if(prets == null || prets.isEmpty()) {
				System.out.println("\tAucun prêt.");
			}else {
				for(Pret pret : prets) {
					System.out.println("\t" + pret);
				}
			}
			System.out.println("On récupère une liste aléatoire d'exemplaires non empruntés pour tester.");
			List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
			Livre livre0 = new Livre(0, null, null, null, null);
			Livre livre1 = new Livre(1, null, null, null, null);
			exemplaires.addAll(exemplaireDAO.findAll(livre0));
			exemplaires.addAll(exemplaireDAO.findAll(livre1));
			for(Exemplaire e : exemplaires) {
				System.out.println("\t" + e);
				System.out.println("\t\tDisponible : " + exemplaireDAO.isDisponible(e));
			}
			System.out.println();
			System.out.println("Création de 4 prêts :");
			for(Exemplaire e : exemplaires) {
				creaEmprunt(e, adh);
			}
			
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
