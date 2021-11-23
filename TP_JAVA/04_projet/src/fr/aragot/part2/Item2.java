package fr.aragot.part2;

import java.util.Scanner;

public class Item2 {

	private static final char[] OPERATEURS = {'*','/','+','-'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] operandes = new int[2];
		char operateur = 0;
		boolean flag = false;

		System.out.println("Calculatrice simplifiée :");

		while (!flag) {
			try {
				// On récupère les deux chiffres à traiter
				System.out.print("Entrez deux chiffres, séparés d'un espace : ");
				operandes[0] = sc.nextInt();
				operandes[1] = sc.nextInt();
				sc.nextLine();
				// Si les nombres sont bien des chiffres, passage à l'opérande
				if (operandes[0] >= -9 && operandes[0] <= 9 && operandes[1] >= 0 && operandes[1] <= 9) {
					// Tant que l'opérateur n'est pas bon, on redemande un opérateur valide
					while (!contient(operateur,OPERATEURS)) {
						System.out.println("Choisissez une opérande : * | / | + | - |");
						operateur = sc.nextLine().charAt(0);
					}
					//Arrivé ici, on a les bons chiffres et la bonne opérante. On peut sortir
					//de la boucle de saisie, on a des calculs à faire.
					sc.close();
					flag = true;
					
				// Pas de chiffres corrects en entrée -> exception -> recommence
				} else {
					System.out.println("Mauvais set d'entrée.");
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Veuillez réessayer, une erreur est survenue.");
			}
		}

		System.out.printf("%d %s %d = %f",operandes[0],operateur,operandes[1],operation(operandes,operateur));

	}
	
	private static float operation(int[] vals,char operateur) {
		switch(operateur) {
		case '*':
			return (float)vals[0]*vals[1];
		case '/':
			return (float)vals[0]/vals[1];
		case '+':
			return vals[0]+vals[1];
		case '-':
			return vals[0]-vals[1];
		default:
			return 0;
		}
	}
	
	static boolean contient(char c, char[] array) {
	    for (char x : array) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}

}
