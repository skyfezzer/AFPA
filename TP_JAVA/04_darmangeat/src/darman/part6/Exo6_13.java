package darman.part6;

import java.util.Arrays;
import java.util.Scanner;

public class Exo6_13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
				myTab[i] = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
			i++;
		}
		
		
		int max = myTab[0],iMax= 0;
		for(int i = 1; i<myTab.length;i++) {
			if(myTab[i] > max) {
				max = myTab[i];
				iMax = i+1;
			}
		}
		System.out.printf("Nombre maximum : %d. Occupe la %de place.",max,iMax);
		sc.close();

	}

}
