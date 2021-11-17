package darman.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Exo3_03 {
	public static void main(String[] args) {
		String noms[] = new String[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<noms.length;i++) {
			System.out.printf("Entrez le prénom num.%d : ",i+1);
			noms[i] = sc.nextLine();
		}

		String testNoms[] = noms.clone();
		Arrays.sort(testNoms);
		
		System.out.printf("Les prénoms %s triés dans l'ordre alphabétique.",Arrays.equals(noms, testNoms)?"sont":"ne sont pas");
		
	}
}
