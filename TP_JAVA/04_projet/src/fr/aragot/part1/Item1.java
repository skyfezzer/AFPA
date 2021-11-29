package fr.aragot.part1;

import java.util.Scanner;

public class Item1 {
	// TAUX EUR/USD AU 23/11/2021
	private static final float EUROUSD_RATE = 1.12595f;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un montant en EURO :");
		double money = sc.nextDouble();
		sc.close();
		System.out.println(money + "€ = " + parseMoney(money));
		
	}
	
	private static String parseMoney(double amount) {
		String str = String.valueOf(amount);
		String result;
		String mult = "";
		if(str.length()>=7) {
			result = str.substring(0, str.length()-6);
			mult = "M";
		}else {
			if(str.length() >= 4) {
				result = str.substring(0, str.length()-3);
				mult = "K";
			}else {
				result = str;
			}
		}
		return String.format("$%.1f%s", euroToDollar(Float.parseFloat(result)),mult);
	}
	
	private static double euroToDollar(double euro) {
		return (euro*EUROUSD_RATE);
	}

}
