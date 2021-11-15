package darman.part2;

import java.util.Scanner;

public class Exo2_03 {
	public static void main(String[] args) {
		String prenom;
		Scanner sc = new Scanner(System.in);
		System.out.print("Quel est votre prénom ? : ");
		prenom = sc.nextLine();
		sc.close();
		System.out.printf("Bonjour, %s !",prenom);
		
	}
}
