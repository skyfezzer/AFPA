package darman.part5;

import java.util.Scanner;

public class Exo5_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int curVal = 0;
		int i = 0;
		int cumulPrix = 0;
		int payeClient = 0;
		int monnaieDue = 0;
		do {
			System.out.printf("Entrez le prix du %de article : ",i+1);
			try{
				curVal = Integer.parseInt(sc.nextLine());
				cumulPrix += curVal;
				i++;
				continue;
			}catch(Exception e) {
				System.out.println("Merci de réessayer, entier attendu");
			}
		}while(curVal != 0);
		
		do {
			System.out.print("Somme donnée par le client : ");
			payeClient = Integer.parseInt(sc.nextLine());
		}while(payeClient < cumulPrix);
		monnaieDue = payeClient - cumulPrix;
		while(monnaieDue > 0) {
			if(monnaieDue >= 10) {
				System.out.println("10 Euros");
				monnaieDue -= 10;
				continue;
			}
			if(monnaieDue >= 5) {
				System.out.println("5 Euros");
				monnaieDue -= 5;
				continue;
			}
			if(monnaieDue >= 1) {
				System.out.println("1 Euro");
				monnaieDue -= 1;
				continue;
			}
		}
		
		sc.close();

	}

}
