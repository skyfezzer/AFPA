package darman.part4;

import java.util.Scanner;

public class Exo4_03 {

	public static void main(String[] args) {
		int heures,minutes,secondes;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez l'heure : ");
		heures = sc.nextInt();
		sc.nextLine();
		System.out.print("Entrez les minutes : ");
		minutes = sc.nextInt();
		sc.nextLine();
		System.out.print("Entrez les secondes : ");
		secondes = sc.nextInt();
		sc.nextLine();
		sc.close();
		System.out.printf("Dans une minute, il sera %.0fh%.0f:%.0f ", 
				(heures+(Math.floor(((minutes+Math.floor((secondes+1)/60)))/60)))%24f, 
				(minutes+Math.floor((secondes+1)/60))%60f, 
				(secondes+1)%60f);
		

	}

}
