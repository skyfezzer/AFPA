package eval.question;

import java.util.Scanner;
/**
 * Cette classe demande à entrer 5 entiers tout au plus au clavier
 * puis calcule la somme, en affichant le calcul, de ces entiers.
 * 
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest3_Addition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 3\n" +
"L'utilisateur saisit 5 nombres maximum.\n"+
"Chaque nombre saisi est suivi de la touche [Entrée].\n"+
"La saisie est terminée quand les 5 nombres sont saisis ou si on entre le nombre zéro.\n"+
"Réafficher la liste des nombres saisis sous la forme d'une addition avec la somme de ses nombres.\n"+ 
"( exemple: 8 + 9 + 2 + 1  = 20 )\n"+
"*******************************************************************\n\n\n"
		);
		
		// --- SAISIE ---
		Scanner sc = new Scanner(System.in);
		int i;
		int[] valTab = new int[5];
		for( i = 0;i<valTab.length;i++) {
			System.out.println("Entrez un nombre : ");
			valTab[i] = Integer.parseInt(sc.nextLine());
			if(valTab[i] == 0)
				break;
		}
		
		// --- CALCULS ---
		int sum = 0;
		//int sum = Arrays.stream(valTab).sum();
		StringBuilder sb = new StringBuilder();
		for(int value : valTab) {
			if(value == 0)
				break;
			sb.append(String.format("%d + ", value));
			sum += value;
		}
		
		// --- AFFICHAGE ---
		// On supprime le dernier + ainsi que l'espace qui le suit, afin d'afficher = à la place
		sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append("= " + sum);
		System.out.println(sb.toString());
		
		
		

	}

}
