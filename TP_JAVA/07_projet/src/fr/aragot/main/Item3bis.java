package fr.aragot.main;

import java.util.Scanner;

public class Item3bis {
	static final double PI = (double) Math.PI;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le diamètre d'un cercle (cm) : ");
		double diametre = Double.parseDouble(sc.nextLine());
		sc.close();
		System.out.printf("Pour un cercle de diamètre %fcm, Surface = %fcm²",diametre,surfaceCercle(diametre/2));
	}
	
	private static double surfaceCercle(double rayon) {
		return PI*Math.pow(rayon, 2);
	}
}
