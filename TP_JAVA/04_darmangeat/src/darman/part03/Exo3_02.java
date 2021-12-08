package darman.part03;

import java.util.Scanner;

public class Exo3_02 {
	public static void main(String[] args) {
		int val1,val2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier :");
		val1 = sc.nextInt();
		if(sc.hasNextLine())
			sc.nextLine();
		System.out.print("Entrez un autre entier :");
		val2 = sc.nextInt();
		sc.close();
		
		System.out.printf("Le r�sultat du produit entre %d et %d est %s",val1, val2, val1>0^val2>0?"n�gatif":"positif");
	} 
}
