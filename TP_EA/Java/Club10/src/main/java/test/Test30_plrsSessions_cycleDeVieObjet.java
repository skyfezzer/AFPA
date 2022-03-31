package test;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import metier.*;

import java.util.*;
/**
 * @author Afpa
 * ouverture/fermeture de session (comme sur un serveur JEE), état de l'objet
 *
 *Important, dans le fichier de config Hibernate, vous êtes en « update »
 *<property name="hbm2ddl.auto">update</property>
 */

public class Test30_plrsSessions_cycleDeVieObjet
{
	public static void main(String[] args)
	{
	       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	               .configure() // configures settings from hibernate.cfg.xml
	               .build();
	       
	       SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	       
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		// NOUVELLE SESSION 1
	       Session session = factory.openSession();
		
		
		session.beginTransaction();
		
		//////////////////////////////////////////////////////////
		//         RECHERCHE d'objet particulier : mat�rialisation

		//Affichez le premier Entraineur qui a �t� entr� pr�c�demment : "Dupont","Jean"
		// il a un identifiant � 1 (voir dans la BD)
		//Entraineur e1 = (Entraineur )session.get(Entraineur.class, new Integer(1));
		Entraineur e1 = (Entraineur )session.get(Entraineur.class, 1);// auto-boxing !!
		System.out.println(" le premier entraineur :" + e1);
		
	    //Dans quelle �tat Hibernate est l'objet e1?
		
		
		session.close();// session Hibernate // commit implicite
		System.out.println("session 1 close");
		
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		// NOUVELLE SESSION 2
		// ouverture/fermeture de session (comme sur un serveur JEE)
		//////////////////////////////////////////////////////////////////
		System.out.println("\n\n");
		System.out.println("=======================================================");
		System.out.println("On ouvre une deuxi�me session :");
		System.out.println("-----------------------------/n");
	    session = factory.openSession();
		session.beginTransaction();

		System.out.println(" un entraineur   " + e1);
		
	    //Dans quelle �tat Hibernate est l'objet e1?
		
		//////////////////////////////////////////////////////////////////
		// LA  QUESTION 1
		//
		//Est-ce que cette instruction sera prise en compte dans la BD
		//e1.setPrenom("tata");
		//
		//essayez puis expliquez
		//////////////////////////////////////////////////////////////////
		e1.setPrenom("tata");
		System.out.println(" un entraineur   " + e1);
		
		session.getTransaction().commit();//les requ�tes SQL partent vers le moteur
		session.close();// session Hibernate
		// ==========================================
		System.out.println("Non mis à jour car objet pas réattaché à la session.");
		// ==========================================
		System.out.println("session 2 close");
		//////////////////////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////////////////////
		// LA  QUESTION 2
		//
		// Si non, Alors comment faire pour modifier l'entraineur
		//   apr�s avoir ferm�/ouvert une session
		// montrez la solution plus-bas
		//////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		// NOUVELLE SESSION 3
		// ouverture/fermeture de session (comme sur un serveur JEE)
		// On force le nom tutu pour l'entraineur Dupont
		//////////////////////////////////////////////////////////////////
		session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(e1);
		e1.setPrenom("tutu");
		System.out.println(" un entraineur    " + e1);
		session.getTransaction().commit();//les requ�tes SQL partent vers le moteur
		session.close();// session Hibernate
		System.out.println("Session 3 close");
		//////////////////////////////////////////////////////////////////
		factory.close();
	}
}
