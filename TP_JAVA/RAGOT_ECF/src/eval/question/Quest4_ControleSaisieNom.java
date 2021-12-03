package eval.question;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Cette classe contrôle la saisie d'un nom de famille :
 * Redemande l'entrée si la taille du nom n'est pas comprise entre 2 carac. et 10 carac.,
 * ou si le nom comprends des caractères numériques.
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest4_ControleSaisieNom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 4\n" +
"On demande la saisie d’un nom de famille.\n"+
"La saisie sera redemandée tant que :\n"+
"	le nom contiendra un caractère numérique ,\n"+
"	La longueur sera inférieure à 2,\n"+
"	La longueur sera supérieure à 10 .\n"+
"*******************************************************************\n\n\n"
		);
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String nom;
		while(flag) {
			System.out.println("Entrez un nom de famille :");
			nom = sc.nextLine();
			flag = false;
			for(char c : nom.toCharArray()) {
				//48='0' 57='9'
				if(c >= 48 && c <= 57) {
					flag = true;
					break;
				}
			}
			if(nom.length()<2 || nom.length() > 10)
				flag = true;
			
		}
		
		// ---- AVEC REGEX ----
		System.out.println("Entrez un autre nom : ");
		nom = sc.nextLine();
		if(Pattern.matches(".*[0-9].*", nom)) {
			System.out.println("Pas bon !");
		}else {
			System.out.println("OK");
		}

	}

}
