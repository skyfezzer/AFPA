package darman.part05;

import java.util.Scanner;

public class Exo5_01 {

	public static void main(String[] args) {
		askNumberBetween(1, 3);
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
			System.out.printf("(i(=%d) >= min) = %s",i, (i >= min));
			System.out.printf("\n(i(=%d) <= max) = %s",i, (i<=max));
		}while(!(i >= min && i <= max));
		sc.close();
		return i;
	}

}
