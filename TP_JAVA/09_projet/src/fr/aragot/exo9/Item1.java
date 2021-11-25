package fr.aragot.exo9;

import java.util.Scanner;

public class Item1 {

	private static final String EXIT_STRING = "FIN";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strarr[] = new String[2];
		do {
			for(int i = 0; i < 2;i++) {
				System.out.print("Entrez une chaine >");
				strarr[i] = sc.nextLine();
			}
			if(strarr[1].equals(strarr[0]))
				System.out.println("IDENTIQUES");
			System.out.println("- - - - -");
		}while(!(strarr[0].equals(EXIT_STRING) || strarr[1].equals(EXIT_STRING)));
		sc.close();
	}
	
	
	

}
