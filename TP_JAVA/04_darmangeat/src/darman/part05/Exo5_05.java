package darman.part05;

import java.util.Scanner;

public class Exo5_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value;
		System.out.println("Entrez un nombre.");
		value = sc.nextInt();
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		sc.close();
		System.out.printf("Table de %d :",value);
		int i = 1;
		while (i <= 10) {
			System.out.printf("\n%d x %d = %d",value,i,value*i++);
		}
	}

}
