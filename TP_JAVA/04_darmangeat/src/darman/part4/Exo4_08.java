package darman.part4;

import java.util.Scanner;

public class Exo4_08 {

	public static void main(String[] args) {
		int maxDaysMonth;
		int jour,mois,annee;
		boolean bissex;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un jour (FORMAT NUMERIQUE)");
		jour = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez un mois (FORMAT NUMERIQUE)");
		mois = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrez une ann�e (FORMAT NUMERIQUE)");
		annee = sc.nextInt();
		sc.nextLine();
		sc.close();
		bissex = ((annee%4==0) && (annee%100!=0)) || (annee%400==0);
		
		maxDaysMonth=mois==2?bissex?29:28:mois%2==0?mois<8?30:31:31;
		
		if(jour<=maxDaysMonth && mois <= 12 && mois > 0) {
			System.out.println("Date valide !");
		}else {
			System.out.println("Date non valide !");
		}
					
					
	}

}
