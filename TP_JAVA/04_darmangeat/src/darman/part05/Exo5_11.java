package darman.part05;

import java.util.Scanner;

public class Exo5_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nbPartants, nbJoues;
		System.out.println("Nb de chevaux partants :");
		nbPartants = Integer.parseInt(sc.nextLine());
		System.out.println("Nb de chevaux joués :");
		nbJoues = Integer.parseInt(sc.nextLine());
		sc.close();
		
		int x = fact(nbPartants) / fact(nbPartants - nbJoues);
		int y = fact(nbPartants) / (fact(nbJoues)*fact(nbPartants - nbJoues));
		
		System.out.printf("Dans l'ordre : une chance sur %d de gagner\nDans le desordre : une chance sur %d de gagner",x,y);
		
	}
	
	private static int fact(int param) {
		int result = 1;
		int i = 1;
		while (i <= param) {
			result *= i++;
		}
		
		return result;
	}

}
