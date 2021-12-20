package fr.aragot.bookstore.test;

import java.util.Arrays;

import fr.aragot.bookstore.domain.Auteur;
import fr.aragot.bookstore.domain.IBavard;
import fr.aragot.bookstore.domain.Personne;
import fr.aragot.bookstore.domain.Utilisateur;

public class TestUtilisateur {

	public static void main(String[] args) {
		Utilisateur u1 = new Utilisateur("Osouf", "Olivier","23456");
		Utilisateur u2 = new Utilisateur("Dos Martires", "Victor","67329");

		Utilisateur jean = new Utilisateur();
		jean.setNom("Castex");
		jean.setPrenom("Jean");
		jean.setIdUtilisateur("wxcvb");
		
		System.out.println("u1 :" + u1.toString());
		System.out.println("u2 :" + u2);
		System.out.println("jeannot :" + jean);
		
		System.out.print("L\'utilisateur " + u1.getNom()+ "  "+ u1.getIdUtilisateur() + " dit :"); u1.parle();
		System.out.print("L\'utilisateur " + u2.getNom()+ "  "+ u2.getIdUtilisateur() + " dit :"); u2.parle();
		System.out.print("L\'utilisateur " + jean.getNom()+ "  "+ jean.getIdUtilisateur() + " dit :"); jean.parle();
		System.out.println();
		
		//////////////////////////////////////////////////////
		// TRANSTYPAGE
		//////////////////////////////////////////////////////
		System.out.println("\n transtypage ascendant-descendant-impossible");
		System.out.println("----------------------------------------------");

		//transtypage ascendant//up-casting
		Personne p1 = u1;
		System.out.println("la classe de l'objet p1 :" + p1.getClass().getName());
		// la MV sait toujours d'où l'objet a été instancié
		
		System.out.print("La personne p1 " + p1.getNom() + " dit :"); p1.parle();
		///////////////////////////////////////////
		//  CONCLUSION
		//Les méthodes en Java sont virtuelles
		///////////////////////////////////////////
		
		
		//transtypage descendant//downcasting  //point chaud du code
		Utilisateur u4 = (Utilisateur) p1;
		System.out.print("L\'utilisateur " + u4.getNom()+ "  "+ u4.getIdUtilisateur() + " dit :"); u4.parle();

		
		//transtypage descendant IMPOSSIBLE//downcasting //java.lang.ClassCastException:
		IBavard b = new Auteur(); //transtypage ascendant//up-casting
		//Utilisateur u5 =  (Utilisateur) b;
		//System.out.print("L\'utilisateur " + u5.getNom()+ "  "+ u5.getIdUtilisateur() + " dit :"); u5.parle();
		
		System.out.println();
		
		
		/////////////////////
		//Polymorphisme
		/////////////////////
		System.out.println("Polymorphisme dans une collection de Personnes");
		System.out.println("----------------------------------------------");
//		Personne[] personnes = {	new Utilisateur("Druon", "Guillaume","1001"),
//				new Auteur()};

		Personne[] personnes = { u1 , new Auteur()};
		for(Personne var : personnes) {
			//System.out.print("La personne " + var.getNom()+ "  "+ var.getIdUtilisateur()+ "  dit :"); var.parle();
			System.out.print("La personne " + var.getNom()+ "  dit :"); var.parle();
		}
		System.out.println();
		
		System.out.println("Polymorphisme dans une collection de IBavard");
		System.out.println("--------------------------------------------");
		
		IBavard [] bavards= { u1 , new Auteur()};
				
		for(IBavard var : bavards) {
			//System.out.print("Le bavard " + var.getNom()+ "  "+ var.getIdUtilisateur()+ "  dit :"); var.parle();
			//System.out.print("Le bavard " + var.getNom()+ "  dit :"); var.parle();
			var.parle();
		}
		System.out.println();
		
		
		/////////////////////////
		//  opérateur instanceof
		/////////////////////////
		System.out.println("la classe de l'objet p1 :" + p1.getClass().getName());
		System.out.println();
		
		System.out.println("la classe de l'objet u1 :" + u1.getClass().getName());
		System.out.println("resultat u1 instanceof Utilisateur :" + ( u1 instanceof Utilisateur));
		//System.out.println("resultat u1 instanceof Auteur :" + ( u1 instanceof Auteur));
		System.out.println("resultat u1 instanceof Personne :" + ( u1 instanceof Personne));
		System.out.println("resultat u1 instanceof Object :" + ( u1 instanceof Object));
		System.out.println("resultat u1 instanceof IBavard :" + ( u1 instanceof IBavard));
		System.out.println();

		//IBavard b = new Auteur(); 
		System.out.println("la classe de l'objet b :" + b.getClass().getName());
		System.out.println("resultat b instanceof Utilisateur :" + ( b instanceof Utilisateur));
		System.out.println("resultat b instanceof Auteur :" + ( b instanceof Auteur));
		System.out.println("resultat b instanceof Personne :" + ( b instanceof Personne));
		System.out.println("resultat b instanceof Object :" + ( b instanceof Object));
		System.out.println("resultat b instanceof IBavard :" + ( b instanceof IBavard));

		//Programmation fonctionnelle Java8
		// VOIR 098_DEMO2_BIBLIO_phase08_ensembleHeritage_polymorphisme_abstract\biblio\test\TestPolymorphisme
		///////////////////////////////////////////////////////////
		//Java programmation fonctionnelle JAVA8 API streams
		System.out.println();
		System.out.println("Contenu du tableau avec la Programmation fonctionnelle :");
		System.out.println("--------------------------------------------------------");

		//instructions détaillées
//		List<Personne> personnes3 = Arrays.asList(personnes); //API streams sur les List
//		personnes3.stream().forEach(x->System.out.println(x));
//		System.out.println();
		//////////////////////////////////////////
		
		//instructions plus rapides
		Arrays.asList(personnes).forEach(System.out::println);
		
		System.out.println();
		
		Arrays.asList(personnes).forEach(x->x.parle());
		
		//parle peut-elle être abstract ??

	}

}
