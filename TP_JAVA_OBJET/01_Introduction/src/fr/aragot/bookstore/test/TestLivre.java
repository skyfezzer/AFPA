package fr.aragot.bookstore.test;

import java.time.LocalDate;

import fr.aragot.bookstore.domain.Livre;

public class TestLivre {

	public static void main(String[] args) {
		
		//Livre livre = new Livre();
//		System.out.println( "\nlivre.afficheToi()");
//		System.out.println( "------------------");
//		livre.afficheToi();
//		System.out.println();
//		System.out.println("Le contenu de mon objet :" + livre.toString());
		
		///////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////
		// SCENARIO DE TEST pour un livre
		//Emprunt du livre l1
		//retrait de 3 pages du livre l1
		//retour dans la librairie (bookshop) du livre l1
		//////////////////////////////		
		Livre l1 = new Livre("Ast�rix", "Uderzo", "Dargo", 64, null, true);
		System.out.println("le livre l1 :" + l1);
		System.out.println();
		
		Livre l2 = new Livre("Tintin", "Erg�", "Dargo", 133, null, true);
		System.out.println("le livre l2 :" + l2);
		
		/////////////////////////
		//Emprunt du livre l1
		System.out.println("\nEmprunt du livre l1");
		System.out.println("---------------------");	
		//l1.disponible = false;
		l1.setDisponible(false);
		
		//l1.dateEmprunt = LocalDate.now();
		l1.setDateEmprunt(LocalDate.now());

		System.out.println("le livre l1 :" + l1);
		System.out.println();
		
		/////////////////////////
		//retrait de 3 pages du livre l1
		System.out.println("dégradation du livre");
		System.out.println("--------------------");
		//l1.nbPages -= 3;
		l1.setNbPages(l1.getNbPages()-3);
		System.out.println("le livre l1 :" + l1);
		System.out.println();
		
		//QUESTION
		//System.out.println("l1 est-il dispo? :" + (l1.disponible?"oui":"non"));
		System.out.println("l1 est-il dispo? :" + l1.isDisponible());
		System.out.println();

		///////////////////////////
		//retour dans le bookshop  du livre l1
		System.out.println("\nretour du livre l1");
		System.out.println("---------------------");
		//l1.disponible = true;
		l1.setDisponible(true);

		System.out.println("le livre l1 :" + l1);
		System.out.println();
		//QUESTION
		//System.out.println("l1 est-il dispo? :" + (l1.disponible?"oui":"non"));
		System.out.println("l1 est-il dispo? :" + l1.isDisponible());
		System.out.println();
		
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////////////
		//Test des constructeurs
		///////////////////////////
		//constructeur avec tous les paramètres
		Livre l4 = new Livre("Torgal", "Vandamme", "Dargo", 200, null, true);
		System.out.printf("le livre l4 :%s\n\n" , l4);
		System.out.println();
		
		//constructeur avec 4 paramètres
		Livre l5 = new Livre("Asterix chez les Pictes; ", "Uderzo", "Dargo", 70);
		System.out.printf("constructeur 4 param; le livre l5 :%s\n\n" , l5);
		System.out.printf("le livre l5 :%s\n\n" , l5);
		System.out.println();
		
		//constructeur sans paramètre
		Livre l6 = new Livre();
		System.out.printf("constructeur ss param; le livre l6 :%s\n\n" , l6);
		System.out.println(" on force le titre avec  : .... les PICTES");
		l5.setTitre("Asterix chez les PICTES");
		System.out.println("le getter  titre de l5 :" + l5.getTitre());
		l5.setTitre(l5.getTitre().toUpperCase());
		System.out.println("\nle getter  titre de l5 :" + l5.getTitre());
		
		//l5.titre = null;
		l5.setTitre(null);
		System.out.printf("le livre l5 :%s\n\n" , l5);
		System.out.println();
		//l5.setTitre(l5.getTitre().toLowerCase());
		
		//l5.setNbPages(-6);
		
		///////////////////////////
		//Test des méthodes polymorphes:  toString, equals, hashCode
		///////////////////////////
		
		Livre l7 = new Livre("Torgal", "Vandamme", "Dargo", 200, null, true);
		System.out.printf("constructeur avec tout les param; le livre l7 :%s\n\n" , l7);
		System.out.println();

		System.out.println();
		
		if( l4.equals(l7)) {
			System.out.println("Les livres sont égaux");
		}
		else
			System.out.println("Les livres sont différents");

		System.out.println();
		System.out.println("le hashCode de l4 :0x" + Integer.toHexString(l4.hashCode()) );
		System.out.println("le hashCode de l7 :0x" + Integer.toHexString(l7.hashCode()));

		
	}

}
