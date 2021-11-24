package darman.part05;

import java.util.Scanner;

public class Exo5_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value,result = 0;
		System.out.println("Entrez un nombre.");
		value = sc.nextInt();
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		sc.close();
		int i = 1;
		while (i <= value) {
			result += i++;
		}
		System.out.printf("1 + ... + %d = %d",value,result);
	}

}
