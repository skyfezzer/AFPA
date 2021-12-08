package fr.afpa.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ListeDeCourses {

	//static LinkedList<String> courses;
	static List<String> courses;
	static Scanner sc;
	public static void main(String[] args) {
		courses = new ArrayList<>();
		sc = new Scanner(System.in);
		while(true) {
			afficheCaddie();
			if(demandeUserVeutContinuer()) {
				ajouteNouveauProduit();
			}else {
				break;
			}
		}

	}
	private static void ajouteNouveauProduit() {
		System.out.print("\nEntrez le nom du produit :");
		courses.add(sc.nextLine());
		
	}
	private static void afficheCaddie() {
		System.out.println("\n\n\n=== Contenu du caddie ===\n");
		
		courses.forEach(x -> System.out.println("\u25aa " + x));
		
		
	}
	
	private static boolean demandeUserVeutContinuer() {
		char rep;
		do {
			System.out.println("\tPour entrer un nouvel article: n");
			System.out.println("\tPour sortir de l'application : q");
			System.out.print("Votre choix :");
			try {
				rep = sc.nextLine().toLowerCase().charAt(0);
				if(rep=='q') {
					return false;
				}
			} catch (Exception e) {
				rep = ' ';
				continue;
			}
		} while (!(rep == 'n' || rep == 'q'));
		return true;
	}

}
