package darman.part06;

import java.util.Scanner;

public class Exo6_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] notes = new int[9];
		for(int i = 0; i < notes.length;) {
			System.out.printf("Entrez la note num.%d : ",i+1);
			try{
				notes[i] = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Erreur, réessayez.");
				continue;
			}
			i++;
		}
		float moyenne = 0;
		for(int i = 0; i < notes.length;i++) {
			moyenne += notes[i];
		}
		moyenne = moyenne / notes.length;
		System.out.println("Moyenne des notes : " + moyenne);
		sc.close();
	}
}
