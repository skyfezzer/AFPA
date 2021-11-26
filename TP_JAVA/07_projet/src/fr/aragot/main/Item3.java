package fr.aragot.main;

import java.util.Scanner;

public class Item3 {
	static final float PI = (float) Math.PI;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le diamètre d'un cercle (cm) : ");
		float diametre = Float.parseFloat(sc.nextLine());
		sc.close();
		System.out.printf("Pour un cercle de diamètre %fcm, Surface = %fcm²",diametre,surfaceCercle(diametre/2));
	}
	
	private static float surfaceCercle(float rayon) {
		return (float) (PI*Math.pow(rayon, 2));
	}
}
