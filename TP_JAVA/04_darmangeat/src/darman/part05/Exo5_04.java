package darman.part05;

import java.util.Scanner;

public class Exo5_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value;
		System.out.println("Entrez un nombre.");
		value = sc.nextInt();
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		sc.close();
		int i = 0;
		for(i = 1;i<=10;i++) {
			System.out.println(value + i);
		}
	}

}
