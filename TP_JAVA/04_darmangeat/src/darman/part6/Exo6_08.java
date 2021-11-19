package darman.part6;

import java.util.Scanner;

public class Exo6_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nbPos = 0, nbNeg = 0;
		int tabSize = 0;
		while(tabSize == 0) {
			System.out.print("Entrez le nbr de valeurs à entrer : ");
			try {
				tabSize = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
		}
		int[] myTab = new int[tabSize];
		
		for(int i = 0;i<myTab.length;) {
			System.out.println("Tapez la valeur num"+(i+1)+": ");
			try {
				int myVal = Integer.parseInt(sc.nextLine());
				if(myVal < 0) {
					nbNeg++;
				}else {
					nbPos++;
				}
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
			i++;
		}
		sc.close();
		System.out.printf("Le tableau contient %d entiers positif et %d entiers négatif",nbPos,nbNeg);
		
		

	}

}
