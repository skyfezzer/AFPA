package darman.part02;

import java.util.Scanner;

public class Exo2_02 {

	public static void main(String[] args) {
		int nbr, nbrPow2;
		
		System.out.print("Entrez un nombre:");
		Scanner sc = new Scanner(System.in);
		nbr = sc.nextInt();
		sc.close();
		
		nbrPow2 = nbr * nbr;
		// Marche aussi, avec plus grande pr�cision pour les floats, doubles, etc... (pas dans le cas d'integers)
		// nbrPow2 = (int) Math.pow(nbr, 2);
		
		System.out.printf("Le carr� de %d est %d.",nbr,nbrPow2);
		
	}

}
