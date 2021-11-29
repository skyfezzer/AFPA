package fr.aragot.main;

import java.util.Scanner;

public class Item3 {

	static final int ITEM_PER_LINE = 20;
	static final int MAX_LINES_BEFORE_PAUSE = 10;
	static Scanner sc;
	static int nbr, nMax;

	public static void main(String[] args) {
		do{
			recupererParams();
			affMultiples();
		}while(demandeUserVeutContinuer());

	}
	
	public static void recupererParams() {
		boolean flag = true;
		sc = new Scanner(System.in);
		
		while(flag) {
			try {
				System.out.printf("Entrez le nombre pour lequel nous allons chercher les multiples (max:%d)> ",Integer.MAX_VALUE);
				nbr = Integer.parseInt(sc.nextLine());
				flag = false;
			}catch(Exception e) {
				System.out.println("Erreur, réessayons.");
			}
		}
		flag = true;
		while(flag) {
			try {
				System.out.print("Cherchons de 0 à n. Entrez n > ");
				nMax = Integer.parseInt(sc.nextLine());
				flag = false;
			}catch(Exception e) {
				System.out.println("Erreur, réessayons.");
			}
		}
	}
	/**
	 * Affiche les multiples déjà calculés/préparés.
	 * 
	 */
	public static void affMultiples() {
		
		System.out.printf("\nAffichage des MULTIPLES de %d entre 0 et %d\n", nbr, nMax);
		for (int x = 0; x <= nMax; x++) {
			if (x % ITEM_PER_LINE == 0)
				System.out.println();
			
			if(x%(ITEM_PER_LINE*MAX_LINES_BEFORE_PAUSE) == 0)
			{
				System.out.println("\nAPPUYEZ SUR ENTER POUR CONTINUER...");
				sc.nextLine();
			}
			if (x % nbr == 0) {
				System.out.print("(" + x + ")\t");
			} else {
				System.out.print(" " + x + " \t");
			}
		}
	}
	
	private static boolean demandeUserVeutContinuer() {
		char rep;
		do {
			System.out.print("Voulez-vous continuer (O/N) ?");
			try {
				rep = sc.nextLine().toLowerCase().charAt(0);
				if(rep=='n') {
					return false;
				}
			} catch (Exception e) {
				rep = ' ';
				continue;
			}
		} while (!(rep == 'o' || rep == 'n'));
		return true;
	}
	
	

}
