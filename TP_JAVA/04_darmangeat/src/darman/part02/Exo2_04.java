package darman.part02;

import java.util.Scanner;

public class Exo2_04 {

	public static void main(String[] args) {
		float prixHT, tvaRate;
		int quantity;
		Scanner sc = new Scanner(System.in);
		System.out.print("Prix de l'article HT (virgule avec ',' et non '.') : ");
		prixHT = sc.nextFloat();
		if(sc.hasNextLine())
			sc.nextLine();
		
		System.out.print("Quantit� d'articles : ");
		quantity = sc.nextInt();
		if(sc.hasNextLine())
			sc.nextLine();
		
		System.out.print("Taux de la TVA (en % de 1 � 100) : ");
		tvaRate = sc.nextFloat();
		if(sc.hasNextLine())
			sc.nextLine();
		sc.close();
		System.out.printf("%s\t%s\t%s\t%s\n","Prix HT","Qté","TVA","Prix TTC");
		System.out.printf("%.2f\t%d\t%.2f%%\t%.2f",prixHT,quantity,tvaRate,(prixHT * (1+(tvaRate/100)) * quantity));
	}

}
