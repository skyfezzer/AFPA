package fr.aragot.main;

import java.util.Scanner;

public class MultiplesV2 {

	static final int PAGE_MODE_LIMIT = 20;

	static int nbDiv, nMax;

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			try {
				System.out.printf("Entrez le nombre pour lequel nous allons chercher les multiples (max:%d)> ",Integer.MAX_VALUE);
				nbDiv = Integer.parseInt(sc.nextLine());
				flag = false;
			}catch(Exception e) {
				System.out.println("Erreur, r�essayons.");
			}
		}
		flag = true;
		while(flag) {
			try {
				System.out.print("Cherchons de 0 � n. Entrez n > ");
				nMax = Integer.parseInt(sc.nextLine());
				flag = false;
			}catch(Exception e) {
				System.out.println("Erreur, r�essayons.");
			}
		}

		System.out.printf("\nAffichage des MULTIPLES de %d entre 0 et %d\n", nbDiv, nMax);
		search: for (int x = 0; x <= nMax; x++) {
			if (x % nbDiv == 0) {
				System.out.print("(" + x + ")\t");
			} else {
				System.out.print(" " + x + " \t");
			}
			if (x % PAGE_MODE_LIMIT == 0)
				System.out.println();
			if (x % 100 == 0 && x != 0) {
				char rep = '0';
				do {
					System.out.print("Voulez-vous continuer (O/N) ?");
					try {
						rep = sc.nextLine().toLowerCase().charAt(0);
						if(rep=='n') {
							break search;
						}
					} catch (Exception e) {
						rep = ' ';
						continue;
					}
				} while (!(rep == 'o' || rep == 'n'));
			}
		}
		sc.close();

	}

}
