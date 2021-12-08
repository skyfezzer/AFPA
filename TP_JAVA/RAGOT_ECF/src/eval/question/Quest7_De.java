package eval.question;


/**
 * Cette classe émule le jet d'un dé.
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest7_De {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 7\n" +
"Lancer un dé ( valeur aléatoire de 1 à 6 ) 15 fois.\n" + 
"Afficher les sorties et  afficher le nombre de sorties du\n" +
"chiffre 1, de 2, de 3, de 4, de 5 et de 6\n" +
"*******************************************************************\n\n\n"
		);
		// CONSTANTES
		final int NB_LANCERS = 15;
		final int SCORE_MIN = 1;
		final int SCORE_MAX = 6;
		
		// VARIABLES
		int[] lancers = new int[NB_LANCERS];
		int[] compteur = new int[6];
		// CALCULS
		for(int i = 0;i<NB_LANCERS;i++) {
			lancers[i] = lanceUnDe(SCORE_MIN, SCORE_MAX);
			System.out.printf("Lancer %d : %d\n",i,lancers[i]);
			compteur[lancers[i]-1] += 1;
		}
		
		for(int i = 1;i<=compteur.length;i++) {
			System.out.printf("Le nombre %d est sorti %d fois.\n",i,compteur[i-1]);
		}

	}
	
	/**
	 * Lance un dé qui renvoie un résultat entre {@code min} et {@code max}
	 * @param min Le minimum que le dé peut renvoyer
	 * @param max Le maximum que le dé peut renvoyer
	 * @return un {@code int} aléatoire entre {@code min} et {@code max}
	 * @author Alexis RAGOT
	 */
	public static int lanceUnDe(int min, int max) {
		return ((int)(Math.random()*max))+min;
		
	}

}
