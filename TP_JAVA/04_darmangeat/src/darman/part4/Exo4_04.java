package darman.part4;

import java.util.Scanner;

public class Exo4_04 {

	public static void main(String[] args) {
		int nbCopies;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre de photocopies � effectuer:");
		nbCopies = sc.nextInt();
		sc.close();
		System.out.printf("Le prix des reprographies sera de %.2f �", calculerPrix(nbCopies));
		

	}
	
	private static float calculerPrix(int pCopies) {
		if(pCopies <= 10 && pCopies > 0) {
			return pCopies * .1f;
		}else if(pCopies <= 30) {
			return 10 * .1f + ((pCopies - 10) * .09f);
		}else {
			return 10 * .1f + (20 * .09f) + ((pCopies - 30) * .08f);
		}
	}

}
