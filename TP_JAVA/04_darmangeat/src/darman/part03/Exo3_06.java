package darman.part03;

import java.util.Scanner;

public class Exo3_06 {

	public static void main(String[] args) {
		int val;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez votre age :");
		val = sc.nextInt();
		sc.close();
		
		switch(val) {
			case 11: case 10:
				System.out.println("Minime");
				break;
			case 9: case 8:
				System.out.println("Pupille");
				break;
			case 7: case 6:
				System.out.println("Poussin");
				break;
			case 5:	case 4:	case 3:	case 2:	case 1:
				System.out.println("Trop jeune.");
				break;
			default:
				System.out.println("Cadet");
		}
	}

}
