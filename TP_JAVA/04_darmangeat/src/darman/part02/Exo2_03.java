package darman.part02;

import java.util.Scanner;

public class Exo2_03 {
	public static void main(String[] args) {
		String prenom;
		Scanner sc = new Scanner(System.in);
		System.out.print("Quel est votre pr�nom ? : ");
		prenom = sc.nextLine();
		sc.close();
		System.out.printf("Bonjour, %s !",prenom);
		
	}
}
