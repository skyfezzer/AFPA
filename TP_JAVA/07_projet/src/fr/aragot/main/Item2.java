package fr.aragot.main;

import java.util.Scanner;

public class Item2 {
	static char[] lowerCase, upperCase;
	public static void main(String[] args) {
		initCharArrays();
		Scanner sc = new Scanner(System.in);
		System.out.print("Ecrivez une phrase, je la passerais en majuscule >");
		String phrase = sc.nextLine();
		for(char c : phrase.toCharArray()) {
			System.out.print(lowerToUpper(c));
		}

	}
	
	private static void initCharArrays() {
		lowerCase = new char[26];
		upperCase = new char[26];
		for(int i = 0; i < 26;i++) {
			lowerCase[i] = (char)(97+i);
			upperCase[i] = (char)(65+i);
		}
	}

	private static char lowerToUpper(char c) {
		for(int i = 0; i < 26;i++) {
			if(lowerCase[i] == c) {
				return upperCase[i];
			}
		}
		return c;
	}

}
