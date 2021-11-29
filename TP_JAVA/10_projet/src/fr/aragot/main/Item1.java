package fr.aragot.main;

import java.util.Arrays;

public class Item1 {
	private static int[] tab1, tab2;
	
	public static void main(String[] args) {
		copieParRef();
		System.out.println();
		copieParClone();
		System.out.println();
		copieParCase();
	}
	
	private static void copieParCase() {
		initTableaux();
		System.out.println("Avant copieParCase :");
		afficheTableaux();
		for(int i = 0; i < tab2.length;i++) {
			tab2[i] = tab1[i];
		}
		changementTab1();
		System.out.println("Après copieParCase :");
		afficheTableaux();
		
	}

	private static void copieParRef() {
		initTableaux();
		System.out.println("Avant copieParRef :");
		afficheTableaux();
		tab2 = tab1;
		changementTab1();
		System.out.println("Après copieParRef :");
		afficheTableaux();
	}
	
	private static void copieParClone() {
		initTableaux();
		System.out.println("Avant copieParClone :");
		afficheTableaux();
		tab2 = tab1.clone();
		changementTab1();
		System.out.println("Après copieParClone :");
		afficheTableaux();
		
	}
	
	//========== METHODES INTERNES ==========
	
	private static void afficheTableaux(){
		System.out.println("tab1 = " + Arrays.toString(tab1));
		System.out.println("tab2 = " + Arrays.toString(tab2));
	}
	
	private static void initTableaux() {
		tab1 = new int[] {1,2,3,4,5,6,7,8,9,10};
		tab2 = new int[10];
	}
	
	private static void changementTab1() {
		for(int i = 0;i<tab1.length;i++) {
			tab1[i] = 10;
		}
	}
	
	

}
