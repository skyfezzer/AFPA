package darman.part5;

import java.util.Scanner;

public class Exo5_02 {

	// A FINIR
	public static void main(String[] args) {
		askNumberBetween(10, 20);
	}
	
	private static int askNumberBetween(int min, int max) {
		int i;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.printf("Entrez un nombre entre %d et %d : ",min,max);
			try{
				
				i = sc.nextInt();
				sc.nextLine();
				
			}catch(Exception e){
				i = min-1;
				continue;
			}
			
		}while(!(i >= min && i <= max));
		sc.close();
		return i;
	}

}
