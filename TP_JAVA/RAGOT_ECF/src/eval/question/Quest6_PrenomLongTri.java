package eval.question;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Cette classe trie au maximum 5 noms de famille par leur longueur de façon décroissante.
 * Les noms de famille sont entrés au préalable au clavier par l'utilisateur.
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest6_PrenomLongTri {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 6\n" +
"Demander 5 prénoms et les stocker dans un tableau.\n" +
"Les réafficher « triés » de telle sorte que le prénom le plus long\n" +
"soit en premier etc.\n" +
"Par exemple avec Didier, Bernard, Christine, Ahn, Ali\n" +
"Le programme affichera\n" +
"Christine, Bernard, Didier, Ahn, Ali\n" +
"*******************************************************************\n\n\n"
		);
		
		Scanner sc = new Scanner(System.in);
		String[] tableau = new String[5];
		System.out.println("Entrez 5 prénoms, 1 par 1 :");
		for(int i = 0;i<tableau.length;i++) {
			System.out.printf("Prenom %d : ",i+1);
			tableau[i] = sc.nextLine();
		}
		
		boolean permute = true;
		while(permute) {
			permute = false;
			for(int i = 0;i<tableau.length-1;i++) {
				if(tableau[i].length() < tableau[i+1].length()) {
					String temp = tableau[i];
					tableau[i] = tableau[i+1];
					tableau[i+1] = temp;
					permute = true;
				}
			}
		}
		System.out.println("\nVoici les prénoms, triés par longueur décroissante :");
		System.out.println(Arrays.toString(tableau));
		

	}

}
