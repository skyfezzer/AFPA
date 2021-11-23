package fr.aragot.part2;

import java.util.Scanner;

public class Item2 {

	private static final char[] OPERATEURS = {'*','/','+','-'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] operandes = new int[2];
		char operateur = 0;
		boolean flag = false;

		System.out.println("Calculatrice simplifi�e :");

		while (!flag) {
			try {
				// On r�cup�re les deux chiffres � traiter
				System.out.print("Entrez deux chiffres, s�par�s d'un espace : ");
				operandes[0] = sc.nextInt();
				operandes[1] = sc.nextInt();
				sc.nextLine();
				// Si les nombres sont bien des chiffres, passage � l'op�rande
				if (operandes[0] >= -9 && operandes[0] <= 9 && operandes[1] >= 0 && operandes[1] <= 9) {
					// Tant que l'op�rateur n'est pas bon, on redemande un op�rateur valide
					while (!contient(operateur,OPERATEURS)) {
						System.out.println("Choisissez une op�rande : * | / | + | - |");
						operateur = sc.nextLine().charAt(0);
					}
					//Arriv� ici, on a les bons chiffres et la bonne op�rante. On peut sortir
					//de la boucle de saisie, on a des calculs � faire.
					sc.close();
					flag = true;
					
				// Pas de chiffres corrects en entr�e -> exception -> recommence
				} else {
					System.out.println("Mauvais set d'entr�e.");
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Veuillez r�essayer, une erreur est survenue.");
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
