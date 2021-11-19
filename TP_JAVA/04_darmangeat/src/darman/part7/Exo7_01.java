package darman.part7;

import java.util.Scanner;

public class Exo7_01 {

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
				myTab[i] = Integer.parseInt(sc.nextLine()) +1;
			}catch(Exception e) {
				System.out.println("Veuillez réessayer.");
				continue;
			}
			i++;
		}
		boolean isConsecutif = true;
		for(int i = 1;i<myTab.length;i++) {
			if(myTab[i] != myTab[i-1] + 1) {
				isConsecutif = false;
			}
		}
		System.out.printf("Les éléments %s tous consécutifs",(isConsecutif?"sont":"ne sont pas"));
		sc.close();

	}

}
