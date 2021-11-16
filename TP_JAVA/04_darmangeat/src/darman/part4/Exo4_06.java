package darman.part4;

import java.util.Scanner;

public class Exo4_06 {

	public static void main(String[] args) {
		int result = 0;
		boolean gagne1 = false, gagne2 = false, gagne3 = false;
		Scanner sc = new Scanner(System.in);
		float[] scores = new float[4];
		for(int i = 0;i<scores.length;i++) {
			System.out.printf("Score du candidat %d au premier tour: ",i);
			scores[i] = sc.nextFloat();
			sc.nextLine();
		}

		gagne1 = scores[0] > scores[1];
		gagne2 = scores[0] > scores[2];
		gagne3 = scores[0] > scores[3];
		
		if(scores[0] > 50) {
			result = 1;
		}else if(gagne1 && gagne2 && gagne3) {
			result = 2;
		}else if(!gagne1 && !gagne2 && !gagne3) {
			result = 4;
		}else {
			result = 3;
		}
		/*
			RESULT :
			1= gagnant,	2= en t�te du 2nd tour,	3= 2nd tour, 4 = �limin�
		*/
		String output = "";
		switch(result) {
			case 1:
				output = "gagne au premier tour !";
				break;
			case 2:
				output = "est en t�te du second tour !";
				break;
			case 3:
				output = "passe au deuxi�me tour.";
				break;
			case 4:
				output = "est �limin�.";
				break;
			default:
				output = "ERREUR DE CALCUL";
				
		}
		System.out.printf("Le candidat numero 1 %s",output);

	}

}
