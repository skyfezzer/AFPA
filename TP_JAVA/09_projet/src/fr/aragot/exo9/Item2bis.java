package fr.aragot.exo9;

import java.util.Scanner;

public class Item2bis {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un mot, une phrase, un caractère... >");
		String CHAINE = sc.nextLine();
		sc.close();
		System.out.println();
		char[] array = CHAINE.toCharArray();
		for(Character c : array) {
			System.out.printf("\\u%04x ",(int)c);
		}

	}

}
