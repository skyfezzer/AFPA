package darman.part04;

import java.util.Scanner;

public class Exo4_02 {

	public static void main(String[] args) {
		int heures,minutes;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez l'heure : ");
		heures = sc.nextInt();
		sc.nextLine();
		System.out.print("Entrez les minutes : ");
		minutes = sc.nextInt();
		sc.close();
		System.out.printf("Dans une minute, il sera %.0fh%.0f ", (heures+(Math.floor((minutes+1)/60)))%24f, (minutes+1)%60f);
		

	}

}
