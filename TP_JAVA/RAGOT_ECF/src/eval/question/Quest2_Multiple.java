package eval.question;

/**
 * Le main de cette classe cherche le multiple d'une <code>CIBLE</code>,
 * multiple compris entre <code>BORNE_NEG</code> et <code>BORNE_SUP</code>
 * 
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest2_Multiple {

	final static int BORNE_NEG = 1;
	final static int BORNE_SUP = 20;
	final static int CIBLE = 5;
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 2\n" +
"Ecrivez un programme  qui affiche les nombres entiers multiples\n" +
" de 5 entre 1 et 20.\n" +
"Documenter la classe de ce programme avec un commentaire javadoc et générez\n"+
"la javadoc.\n"+
"*******************************************************************\n\n\n"
		);
		
		
		for(int i = BORNE_NEG;i<=BORNE_SUP;i++) {
			if(i%CIBLE==0) {
				
				System.out.printf("%d est un multiple de %d !\n",i,CIBLE);
			}
		}
		
		

	}

}
