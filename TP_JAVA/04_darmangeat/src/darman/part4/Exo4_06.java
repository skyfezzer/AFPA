package darman.part4;

import java.util.Scanner;

public class Exo4_06 {

	public static void main(String[] args) {
		int result = 0;
		boolean gagne1 = false, gagne2 = false, gagne3 = false;
		Scanner sc = new Scanner(System.in);
		float[] scores = new float[4];
		for(int i = 0;i<scores.length;) {
			System.out.printf("Score du candidat %d au premier tour: ",i+1);
			try{
				scores[i] = Integer.parseInt(sc.nextLine());
				i++;
			}catch(Exception e) {
				System.out.println("Veuillez réessayer");
			}
			
		}
		sc.close();
		gagne1 = scores[0] > scores[1];
		gagne2 = scores[0] > scores[2];
		gagne3 = scores[0] > scores[3];
		if(scores[0]+scores[1]+scores[2]+scores[3] != 100) {
			System.out.println("Score total différent de 100, votes truqués !");
			return;
		}else {
			/*
			RESULT :
			1= gagnant,	2= en tête du 2nd tour,	3= 2nd tour, 4 = éliminé
			*/
			if(scores[1] > 50 || scores[2] > 50 || scores[3] > 50) {
				result = 4;
			}else {
				if(scores[0] > 50) {
					result = 1;
				}else if(gagne1 && gagne2 && gagne3) {
					result = 2;
				}else if(!gagne1 && !gagne2 && !gagne3) {
					result = 4;
				}else {
					result = 3;
				}
			}
		}
		String output = "";
		switch(result) {
			case 1:
				output = "gagne au premier tour !";
				break;
			case 2:
				output = "est en tête du second tour !";
				break;
			case 3:
				output = "passe au deuxième tour.";
				break;
			case 4:
				output = "est éliminé.";
				break;
			default:
				output = "ERREUR DE CALCUL";
				
		}
		System.out.printf("\n\tLe candidat numero 1 %s",output);

	}

}
