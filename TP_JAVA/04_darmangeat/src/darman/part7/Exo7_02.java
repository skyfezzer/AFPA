package darman.part7;

import java.util.Arrays;
import java.util.Scanner;

public class Exo7_02 {

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
		int[] tab2 = myTab.clone();
		System.out.println("BEFORE SORT SELECTION: " + Arrays.toString(myTab));
		triParSelecDecroissant(myTab);
		
		System.out.println("AFTER SORT SELECTION: " + Arrays.toString(myTab));
		System.out.println("BEFORE SORT BULLE : " + Arrays.toString(tab2));
		triParBulleDecroissant(tab2);
		System.out.println("AFTER SORT BULLE: " + Arrays.toString(tab2));

	}
	
	private static void triParSelecDecroissant(int[] tableau) {
		for(int i = 0;i<tableau.length;i++) {
			int maxVal = tableau[i];
			int maxValJ = i;
			for(int j = i;j<tableau.length;j++) {
				if(tableau[j]>maxVal) {
					maxVal = tableau[j];
					maxValJ = j;
				}
			}
			if(i != maxValJ) {
				int myTempVar = tableau[i];
				tableau[i] = tableau[maxValJ];
				tableau[maxValJ] = myTempVar;
			}
		}
	}
	
	private static void triParBulleDecroissant(int[] tableau) {
		boolean permute = true;
		while(permute) {
			permute = false;
			for(int i = 0;i<tableau.length-1;i++) {
				if(tableau[i] < tableau[i+1]) {
					int temp = tableau[i];
					tableau[i] = tableau[i+1];
					tableau[i+1] = temp;
					permute = true;
				}
			}
		}
	}

}
