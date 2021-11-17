package darman.part5;

import java.util.Scanner;

public class Exo5_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value,result = 1;
		System.out.println("Entrez un nombre.");
		value = sc.nextInt();
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		int i = 1;
		while (i <= value) {
			result *= i++;
		}
		System.out.printf("1 x ... x %d = %d",value,result);
	}

}
