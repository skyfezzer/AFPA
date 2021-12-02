package eval.question;

import java.util.Scanner;

/**
 * Classe qui demande l'age d'une mère et d'un fils,
 * et qui renvoie l'age de ces deux personnes quand la mère aura le double du fils.
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest1_age {

	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 1\n" +
"On veut savoir quand une mère aura le double de l'âge de son fils.\n"+
"Lecture au clavier des 2 âges et présentation du résultat.\n"+
"*******************************************************************\n\n\n"
		);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez l'age de la mère ainsi que l'age du fils, séparés d'un espace : ");
		int mere = sc.nextInt();
		int fils = sc.nextInt();
		sc.close();
		while(mere++/2 != fils++) {}
		System.out.printf("Quand la mère aura %d ans, le fils aura %d ans.",mere,fils);

	}

}
