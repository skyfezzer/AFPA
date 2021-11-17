package darman.part5;

import java.util.Scanner;

public class Exo5_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value;
		System.out.println("Entrez un nombre.");
		value = sc.nextInt();
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		int i = 0;
		while(i<=10) {
			System.out.printf("%d ",value+i++);
		}
	
		sc.close();
	}

}
