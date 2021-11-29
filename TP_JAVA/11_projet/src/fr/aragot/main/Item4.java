package fr.aragot.main;

import java.util.Scanner;

public class Item4 {
	
	public static final int ITEM_PER_LINE = 20;
	public static final int MAX_LINES_BEFORE_PAUSE = 20;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cible = recupererCible(sc);
		int max = recupererMax(sc);
		affMultiples(cible, max, sc);
		sc.close();
	}
	
	/**
	 * Retourne un entier entré par un utilisateur
	 * @param sc 	Le scanner depuis lequel le programme récupèrera les valeurs utilisateur.
	 * @return 		L'entier entré
	 */
	public static int recupererCible(Scanner sc) {
		while(true) {
			try {
				System.out.printf("Entrez le nombre pour lequel nous allons chercher les multiples (max:%d)> ",Integer.MAX_VALUE);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Erreur, réessayons.");
			}
		}
		
	}
	
	/**
	 * Retourne un entier entré par un utilisateur
	 * @param sc 	Le scanner depuis lequel le programme récupèrera les valeurs utilisateur.
	 * @return 		L'entier entré
	 */
	public static int recupererMax(Scanner sc) {
		while(true) {
			try {
				System.out.print("Cherchons de 0 à n. Entrez n > ");
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Erreur, réessayons.");
			}
		}
	}
	
	/**
	 * Affiche les multiples de <code>nbr</code>, de 0 à <code>nMax</code>
	 * @param nbr		L'entier dont on affiche les multiples
	 * @param nMax		L'entier maximum avant que la fonction s'arrête.
	 * @param sc 		Le scanner Clavier, permettant de faire des pauses entre les affichages.
	 * 
	 */
	public static void affMultiples(int nbr, int nMax, Scanner sc) {
		
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
	
}
