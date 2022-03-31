package test;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import metier.*;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author xav
 *Important, dans le fichier de config Hibernate, vous êtes en « update »
 *<property name="hbm2ddl.auto">update</property>
 */
public class Test20_requetage
{
	public static void main(String[] args)
	{

		//Création d'un registre
       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
               .configure() // configures settings from hibernate.cfg.xml
               .build();
       
		//Creation d'une fabrique de session
       SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
       
       //Creation d'une session = le contexte Hibernate
       Session session = sessionFactory.openSession();
		
		
	    //Même pour une recherche, on est obligé de créer une transaction
		session.beginTransaction();
		
		////////////////////////////////////////////////////
		//         REQUETAGE  avec le langage HQL ou JPQL
		////////////////////////////////////////////////////

		System.out.println("\n\n");
		
		//Affichez les tous les Sports
		List<Sport> sports = (List<Sport>)(session.createQuery("from metier.Sport").list());//REQUETE HQL

		System.out.println("\nLISTE DES SPORTS :");
		System.out.println("------------------");
		for (Sport s : sports) {
			System.out.println(s);
		}
		
		System.out.println("\n\n");
		
		//Affichez tous les entraineurs
		List<Entraineur> entraineurs = (List<Entraineur>)session
				.createQuery("from metier.Entraineur").list();//REQUETE HQL
		
		System.out.println("\nLISTE DES ENTRAINEURS :");
		System.out.println("-----------------------");
		for (Entraineur e : entraineurs){
			System.out.println(e);
		}

		//
		//TRAVAIL A REALISER//////////////////////////////////////////
		//Affichez ici tous les  Adherents avec l'API Criteria

		
		//
		//TRAVAIL A REALISER//////////////////////////////////////////
		//Affichez ici tous les  Adherents
		System.out.println("\n\n");
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
	
		//////////////////////////////////////////////////////////
		//         RECHERCHE d'objet particulier : matérialisation
		//////////////////////////////////////////////////////////

		//Affichez le premier Entraineur entré précédemment: "Dupont","Jean"
		// il a un identifiant à 1 (voir dans la BD)
		//Entraineur e1 = (Entraineur )session.get(Entraineur.class, new Integer(1));
		Entraineur e1 = (Entraineur )session.get(Entraineur.class, 1);// auto-boxing !!
		System.out.println(" l'entraineur avec id à 1  " + e1);

		
		//Affichez un sport présent dans la BD
		Sport s_a = (Sport )session.get(Sport.class, 6);
		System.out.println(" le Sport avec id à 6  " + s_a);
		// On redemande la même chose // !!!!!!!
		Sport s_b = (Sport )session.get(Sport.class, 6);
		System.out.println(" le Sport avec id à 6  " + s_b);
		System.out.println(" Est-ce un autre objet (un clone)  ou le même objet? ");
		System.out.println();
		///////////////////////////////////////////////////////////
		// Comparer les objets s_a et s_b
		// A-t-on affaire à des clônes ? Si non alors expliquez ...
		///////////////////////////////////////////////////////////

		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		// TODO
		
		session.getTransaction().commit();//les requêtes SQL partent vers le moteur

		session.close();
		System.out.println("session 1 close");

		
		//////////////////////////////////////////////////////////////////
		// QUESTION SUPPLEMENTAIRE
		//////////////////////////////////////////////////////////////////
		// ouverture/fermeture de session (comme sur un serveur JEE)
		System.out.println("\n\n");
		System.out.println("=======================================================");
		System.out.println("On ouvre une deuxième session :");
		System.out.println("-----------------------------/n");
	    session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println(" un entraineur   " + e1);
		
	    //Dans quelle état Hibernate est l'objet e1?
		
		session.saveOrUpdate(e1);
	    //Dans quelle état Hibernate est l'objet e1?

		//Est-ce que cette instruction sera prise en compte dans la BD  // Expliquez
		e1.setPrenom("tata");
		System.out.println(" un entraineur   " + e1);
		
		//CA NE MARCHE PAS

		//session.saveOrUpdate(e1);

		session.close();// session Hibernate
		System.out.println("session 2 close");

		//session.getTransaction().commit();//les requêtes SQL partent vers le moteur
		//////////////////////////////////////////////////////////////////
		sessionFactory.close(); //commit implicite
		

		System.out.println("Terminé");
	}
}
