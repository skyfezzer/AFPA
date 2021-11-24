package darman.part03;

import java.util.Arrays;
import java.util.Scanner;

public class Exo3_03 {
	public static void main(String[] args) {
		String noms[] = new String[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<noms.length;i++) {
			System.out.printf("Entrez le pr�nom num.%d : ",i+1);
			noms[i] = sc.nextLine();
		}
		sc.close();
		String testNoms[] = noms.clone();
		Arrays.sort(testNoms);
		
		System.out.printf("Les pr�noms %s tri�s dans l'ordre alphab�tique.",Arrays.equals(noms, testNoms)?"sont":"ne sont pas");
		
	}
}
