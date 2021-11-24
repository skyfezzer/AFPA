package darman.part06;

import java.util.Scanner;

public class Exo6_14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tabSize = 0, compteur = 0;
		float moyenne = 0;
		int[] myTab;
		while(tabSize == 0) {
			System.out.print("Entrez le nbr de notes à entrer : ");
			try {
				tabSize = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
		}
		myTab = new int[tabSize];
		
		for(int i = 0;i<myTab.length;) {
			System.out.println("Tapez la note num"+(i+1)+": ");
			try {
				myTab[i] = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
			i++;
		}
		
		
		for(int i = 0; i<myTab.length;i++) {
			moyenne += myTab[i];
		}
		moyenne = moyenne / myTab.length;
		for(int i = 0;i<myTab.length;i++) {
			if(myTab[i] >= moyenne) {
				compteur++;
			}
		}
		System.out.printf("Il y a %d notes au dessus de la moyenne (%.2f) de la totalité des notes.",compteur,moyenne);
		sc.close();

	}

}
