package fr.aragot.main;

import java.util.Scanner;

public class Item3 {

	public static final int IGNORED_VALUE = -1;
	
	private static double moyenne;
	private static int emptyVars;
	private static double[] notes;
	private static Scanner sc;

	public static void main(String[] args) {
		init();
		do {
			demanderNotes();
			calculerMoyenne();
			trierNotes();
			afficheResultats();
		} while (userVeutContinuer());
	}

	private static boolean userVeutContinuer() {
		char rep;
		do {
			System.out.print("Voulez-vous continuer (O/N) ?");
			try {
				rep = sc.nextLine().toLowerCase().charAt(0);
				if (rep == 'n') {
					return false;
				}
			} catch (Exception e) {
				rep = 0;
				continue;
			}
		} while (!(rep == 'o' || rep == 'n'));
		return true;
	}

	private static void trierNotes() {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < notes.length - 1; i++) {
				if (notes[i] > notes[i + 1]) {
					double temp = notes[i];
					notes[i] = notes[i + 1];
					notes[i + 1] = temp;
					flag = true;
				}
			}
		}
	}

	private static void afficheResultats() {
		System.out.println("=====RESULTATS=====");
		if (emptyVars < 10) {
			System.out.printf("\nMoyenne obtenue : %f", moyenne);
			System.out.printf("\nPremière case : %f", notes[emptyVars]);
			System.out.printf("\nDernière case : %f", notes[notes.length - 1]);
			System.out.printf("\nMédiane : %f", mediane());
		} else {
			System.out.println("Tableau de notes vide !");
		}
	}

	private static double mediane() {
		if (emptyVars % 2 != 0) {
			return (notes[(notes.length + emptyVars) / 2] + notes[(notes.length - 1 + emptyVars) / 2]) / 2;
		}
		return notes[(notes.length - 1 + emptyVars) / 2];
	}

	private static void calculerMoyenne() {
		emptyVars = 0;
		double cumul = 0;
		for (int i = 0; i < notes.length; i++) {
			if (notes[i] == IGNORED_VALUE) {
				emptyVars++;
			} else {
				cumul += notes[i];
			}
		}
		moyenne = cumul / (notes.length - emptyVars);

	}

	private static void init() {
		notes = new double[10];
		sc = new Scanner(System.in);

	}

	private static void demanderNotes() {
		int i = 0;
		while (i < notes.length) {
			System.out.printf("Entrez la note num. %d (%d = non significatif) : ", i, IGNORED_VALUE);
			try {
				notes[i] = Double.parseDouble(sc.nextLine());
				i++;
			} catch (Exception e) {
				System.out.println("Veuillez recommencer");
				continue;
			}
		}

	}

}
