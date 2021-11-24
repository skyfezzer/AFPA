package darman.part08;

import java.util.Scanner;

public class Exo8_07 {
	final static char JOUEUR = 'X';
	final static char CASE_VIDE = 'O';
	
	public static void main(String[] args) {
		
		char[][] damier = new char[10][10];
		int jX, jY;
		int input;
		boolean hasMoved = false, game = true;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0;i<damier.length;i++) {
			for(int j = 0; j < damier[i].length;j++) {
				damier[i][j] = CASE_VIDE;
			}
		}
		damier[9][0] = JOUEUR;
		jX = 9;
		jY = 0;
		
		while(true) {
			hasMoved = false;
			while(!hasMoved) {
				try {
					afficheDamier(damier);
					System.out.println("___________________\nMouvements:\n0 1\n X \n2 3");
					System.out.printf("Entrez la direction: ");
					input = Integer.parseInt(sc.nextLine());
					switch(input) {
						case 0:
							damier[jX-1][jY-1] = JOUEUR;
							damier[jX][jY] = CASE_VIDE;
							jX = jX -1;
							jY = jY -1;
							hasMoved = true;
							break;
						case 1:
							damier[jX-1][jY+1] = JOUEUR;
							damier[jX][jY] = CASE_VIDE;
							jX = jX -1;
							jY = jY +1;
							hasMoved = true;
							break;
						case 2:
							damier[jX+1][jY-1] = JOUEUR;
							damier[jX][jY] = CASE_VIDE;
							jX = jX +1;
							jY = jY -1;
							hasMoved = true;
							break;
						case 3:
							damier[jX+1][jY+1] = JOUEUR;
							damier[jX][jY] = CASE_VIDE;
							jX = jX +1;
							jY = jY +1;
							hasMoved = true;
							break;
						default:
							break;
					}
				}catch(Exception e) {
					System.out.println("--- ERREUR, VEUILLEZ REESSAYER ---");
				}
			}
		}
		
	}
	
	private static void afficheDamier(char[][] damier) {
		for(int i = 0;i<damier.length;i++) {
			for(int j = 0; j < damier[i].length;j++) {
				System.out.print(damier[i][j]+" ");
			}
			System.out.print("\n");
		}
		
	}
}
