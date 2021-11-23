package fr.aragot.part4;

import java.security.Timestamp;

public class Item4 {
	private static final int MIN_PREM = 2;
	private static final int MAX_PREM = 100;
	
	
	public static void main(String[] args) {
		String result = "";
		long debut = System.nanoTime();
		for(int i = MIN_PREM;i < MAX_PREM;i++) {
			boolean divisible = false;
			for(int j = MIN_PREM;j<i;j++) {
				if(i%j==0) {
					divisible = true;
				}
			}
			if(!divisible) {
				result += i + " ";
			}
		}
		long fin = System.nanoTime();
		
		System.out.println(result);
		System.out.printf("\nTrouvé en %.1fms.", (float)(fin-debut)/1000000);
		

	}

}
