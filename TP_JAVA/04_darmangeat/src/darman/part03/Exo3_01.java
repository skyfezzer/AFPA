package darman.part03;

import java.util.Scanner;

public class Exo3_01 {
	public static void main(String[] args) {
		int val;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier :");
		val = sc.nextInt();
		sc.close();
		
		System.out.println("L'entier entr� est "+ (val<0?"n�gatif":"positif")+".");
	}
} 
