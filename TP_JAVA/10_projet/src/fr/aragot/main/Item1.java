package fr.aragot.main;

import java.util.Arrays;

public class Item1 {

	
	public static void main(String[] args) {
		int[] tab1 = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] tab2 = new int[10];
		
		// COPIE DE REFERENCE :
		tab2 = tab1;
		System.out.println("tab1 = " + Arrays.toString(tab1));
	
	}

}
