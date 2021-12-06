package fr.afpa.util;

import java.time.LocalDate;
import java.time.Period;

public class UtilitaireBookstore {

	public static void main(String[] args) {
		testIsPretEnRetard();
		testIsPretEnRetard2();
		
		System.out.println(getAge(LocalDate.of(1998, 11, 14)));
	}
	
	private static void testIsPretEnRetard() {
		LocalDate dateEmprunt = LocalDate.of(2021, 11, 1);
		LocalDate mtn = LocalDate.of(2021, 11, 9);

		System.out.println(dateEmprunt + " - " + mtn + " : pas en retard");
		
		if((isPretEnRetard(dateEmprunt, mtn)) == false) {
			System.out.println("OK");
		}else {
			System.err.println("NOK");
		}
	}
	
	private static void testIsPretEnRetard2() {
		LocalDate dateEmprunt = LocalDate.of(2021, 11, 1);
		LocalDate mtn = LocalDate.of(2021, 11, 19);

		System.out.println(dateEmprunt + " - " + mtn + " : en retard");
		
		if((isPretEnRetard(dateEmprunt, mtn)) == true) {
			System.out.println("OK");
		}else {
			System.err.println("NOK");
		}
	}
	
	public static boolean isPretEnRetard(LocalDate emprunt, LocalDate maintenant) {
		return isPretEnRetard(emprunt, maintenant,15);
	}
	
	public static boolean isPretEnRetard(LocalDate emprunt,LocalDate maintenant,int dureeJoursPret) {
		return emprunt.plusDays(dureeJoursPret).isBefore(maintenant);
	}
	
	public static int getAge(LocalDate dateNaissance) {
		return getAge(dateNaissance, LocalDate.now());
	}
	
	public static int getAge(LocalDate dateNaissance, LocalDate now) {
		if(now.isBefore(dateNaissance)) {
			throw new IllegalArgumentException("Ne peut pas récupérer l'age d'une date future.");
		}
		return Period.between(dateNaissance, now).getYears();
	}

}
