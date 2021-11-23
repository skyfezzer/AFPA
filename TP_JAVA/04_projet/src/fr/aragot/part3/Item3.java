package fr.aragot.part3;

import java.util.Scanner;

public class Item3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a=0,b=0,c=0;
		boolean flag = false, fini = false;
		
		while(!fini) {
			System.out.println("Soit une équation ax²+bx+c (2nd degré). Entrez les valeurs de a,b et c séparés par un espace :");
			while(!flag) {
				try {
					System.out.print("a b c : ");
					a=sc.nextFloat();
					b=sc.nextFloat();
					c=sc.nextFloat();
					sc.nextLine();
					flag = true;
				}catch(Exception e) {
					System.out.println("Réessayez.");
				}
			}
			
			float delta = delta(a,b,c);
			fini = true;
			if(delta > 0) {
				System.out.println("Il y a deux solutions :");
				double x1 = (-b-Math.sqrt(delta))/(2.*a);
				double x2 = (-b+Math.sqrt(delta))/(2.*a);
				System.out.printf("x1 = %f\n",x1);
				System.out.printf("x2 = %f\n",x2);
			}else if(delta == 0) {
				double x = (-b)/(2.*a);
				System.out.printf("La solution est x = %f",x);
			}else {
				System.out.println("Pas de solutions. On recommence !");
				fini = false;
			}
		}
	}
	
	private static float delta(float a, float b, float c) {
		return b*b-(4*a*c);
	}

}
