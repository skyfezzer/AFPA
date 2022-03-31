package test;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.*;
import metier.*;

/**
 * @author xav Important, dans le fichier de config Hibernate, vous êtes en en
 *         "update" (ou "create" (qui passe encore))
 *         <property name="hbm2ddl.auto">create</property>
 */
public class Test10_popul {
	public static void main(String[] args) {

		Session session = null;

		try {

			// Création d'un registre
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
																										// settings from
																										// hibernate.cfg.xml
					.build();

			// Creation d'une fabrique de session
			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			// Creation d'une session = le contexte Hibernate
			session = sessionFactory.openSession();

			session.beginTransaction();
			// DIFFERENTS OBJETS SONT A ENREGISTRE DANS LA BD
			// AJOUTER LES OBJECT CREES AU CONTEXTE DE PERSISTANCE

			Entraineur e1 = new Entraineur("Dupont", "Jean", new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2005"));
			Entraineur e2 = new Entraineur("Dubois", "Marie", new SimpleDateFormat("dd/mm/yyyy").parse("16/12/1995"));
			Entraineur e3 = new Entraineur("Durant", "Patrick", new SimpleDateFormat("dd/mm/yyyy").parse("04/05/2000"));

			// Dans quelle état Hibernate est l'objet e1? : transient

			System.out.println("\nOn rend persistant les entraineurs");
			System.out.println("On affiche leur identifiant");
			System.out.println("----------------------------------");

			session.persist(e1);
			System.out.println("entraineur Valeur d'identifiant :" + e1.getIdE());
			session.persist(e2);
			System.out.println("entraineur Valeur d'identifiant :" + e2.getIdE());
			session.persist(e3);
			System.out.println("entraineur Valeur d'identifiant :" + e3.getIdE());

			// Dans quelle état Hibernate est l'objet e1? : persistent
			// L'objet persistant est suivi par la session Hibernate
			// Son chgt d'�tat est r�percut� en BD
			e1.setPrenom("toto");
			e1.setPrenom("titi");

			Sport s1 = new Sport("Equitation", "Dupont");
			Sport s2 = new Sport("Natation", "Dubois");
			Sport s3 = new Sport("Boxe", "Durant");

			System.out.println("\nOn rend persistant des sports");
			System.out.println("-----------------------------");
			session.persist(s1);
			System.out.println("sport Valeur d'identifiant :" + s1.getIdS());
			session.persist(s2);
			System.out.println("sport Valeur d'identifiant :" + s2.getIdS());
			session.persist(s3);
			System.out.println("sport Valeur d'identifiant :" + s3.getIdS());

			System.out.println("\n\n");

			//////////////////////
			// TODO
			//////////////////////
			// TRAVAIL A REALISER : faite le mapping de l'entité Adherent puis
			//
			// Sauvegardez l'adh�rent "Bichon" "Simone", n�e le 04/03/1981 ... FAISANT de
			////////////////////// l'�quitation !
			Adherent ad1 = new Adherent("BICHON", "Simone",java.sql.Date.valueOf("1981-03-04"),"Equitation");
			
			// Sauvegardez l'adh�rent "Abicol" "Nicole", n�e le 15/12/1951 ... FAISANT de
			////////////////////// l'�quitation (bis) !
			Adherent ad2 = new Adherent("ABICOL", "Nicole",java.sql.Date.valueOf("1951-12-15"),"Equitation");
			
			// Sauvegardez l'adh�rent "Dupuis" "Gary", n�e le 17/10/2000 ... FAISANT de la
			////////////////////// natation !
			Adherent ad3 = new Adherent("DUPUIS", "Gary",java.sql.Date.valueOf("2000-10-17"),"Natation");

			
			System.out.println("\nOn rend persistant des sports");
			System.out.println("-----------------------------");
			session.persist(ad1);
			System.out.println("adherent Valeur d'identifiant :" + ad1.getIdA());
			session.persist(ad2);
			System.out.println("adherent Valeur d'identifiant :" + ad2.getIdA());
			session.persist(ad3);
			System.out.println("adherent Valeur d'identifiant :" + ad3.getIdA());

			System.out.println("\n\n");
			
			// ferme la transaction
			session.getTransaction().commit();// les requ�tes SQL partent vers le moteur
			// voir les logs-console sur votre IDE

			session.close();// session Hibernate
			System.out.println("session close");

			sessionFactory.close();// libération des ressources
		} catch (ParseException ex) {
			System.err.println("Pb sur le parsing des dates" + ex);
		} catch (HibernateException ex) {
			System.err.println("La cr�ation de la SessionFactory a �chou�" + ex);
		}
//	finally{
//		session.close();
//	
//	}
	}

}
