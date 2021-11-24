package darman.part03;

import java.util.Scanner;

public class Exo3_04 {
	public static void main(String[] args) {
		int val;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier :");
		val = sc.nextInt();
		sc.close();
		
		System.out.println("L'entier entr� est "+ (val==0?"nul (=0)":val>0?"positif":"n�gatif")+".");
	}
}
