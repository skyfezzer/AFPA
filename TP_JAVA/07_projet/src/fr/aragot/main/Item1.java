package fr.aragot.main;

public class Item1 {

	public static void main(String[] args) {
		for(short i = 0;i<40000;i++) {
			if(i%100==0) {
				System.out.printf("for short i from 0 to 40000, i=%d\n",i);
				// (short i = 32767 + 1) == -32768
				// un short ne peut pas aller jusqu'à 40 000, il peut contenir presque 65500 valeurs
				// mais ces valeurs sont signées ! donc de -32768 à 32767
			}
		}

	}

}
