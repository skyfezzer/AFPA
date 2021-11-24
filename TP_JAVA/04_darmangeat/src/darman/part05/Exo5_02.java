package darman.part05;

import java.util.Scanner;

public class Exo5_02 {

	// A FINIR
	public static void main(String[] args) {
		askNumberBetween(10, 20);
	}
	
	private static int askNumberBetween(int min, int max) {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.printf("Entrez un nombre entre %d et %d : ",min,max);
			try{
				
				i = sc.nextInt();
				if(sc.hasNextLine()) {
					sc.nextLine();
				}

				if(i > max) {
					System.out.println("Plus petit !");
				}
				if(i < min) {
					System.out.println("Plus grand !");
				}
					
				
				
			}catch(Exception e){
				i = 0;
				sc.close();
				sc = new Scanner(System.in);
				continue;
			}
			
		}while(!(i >= min && i <= max));
		sc.close();
		return i;
	}

}
