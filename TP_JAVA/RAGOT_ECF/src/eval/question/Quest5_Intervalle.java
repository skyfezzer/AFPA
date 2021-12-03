package eval.question;

import java.util.Scanner;
/**
 * Dans cette classe, l'utilisateur entre deux intervalles. Puis la classe
 * essaye de trouver un intervalle commun aux deux intervalles entrés.
 * @author Alexis RAGOT
 * @version 1.0
 */
public class Quest5_Intervalle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
"*******************************************************************\n" +
"Question 5\n" +
"Demander les deux intervalles [a ; b] et [c ; d]\n"+
"Si b < c ou bien a > d, l'intersection est vide\n"+
"Sinon, calculer deux variables : m (maximum de a et de c) et M (minimum de b et de d)\n"+
" et afficher l'intervalle [m; M]\n"+
"*******************************************************************\n\n\n"
		);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Intervalle [a,b], entrez a : ");
		int a = sc.nextInt();
		System.out.print("Intervalle [a,b], entrez b : ");
		int b = sc.nextInt();
		System.out.print("Intervalle [c,d], entrez c : ");
		int c = sc.nextInt();
		System.out.print("Intervalle [c,d], entrez d : ");
		int d = sc.nextInt();
		int m,M;
		if(b<c || a>d) {
			System.out.println("Intervalle vide !");
		}else {
			m=Math.max(a, c);
			M=Math.min(b, d);
			System.out.printf("Intervalle = [%d,%d]",m,M);
		}
		
		
		

	}

}
