package fr.afpa.util;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import javax.swing.JOptionPane;

public class CalculAnniversaire {
	
	LocalDate dateAnniversaire;
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.FRENCH);
		
		String str = JOptionPane.showInputDialog(null, "Date d'anniversaire (jj/mm) :");
		MonthDay mdAnniv = MonthDay.from(DateTimeFormatter.ofPattern("dd/MM").parse(str));
		LocalDate dateAnniv = CalculerProchainAnniversaire(mdAnniv);
		AfficheDateAnniv(dateAnniv);
		
	}
	
	private static void AfficheDateAnniv(LocalDate dateAnniv) {
		long daysDiff = ChronoUnit.DAYS.between(LocalDate.now(),dateAnniv);
		String localizedDate = dateAnniv.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy"));
		String result = String.format("Votre prochain anniversaire est dans %d jours,\nle %s", daysDiff, localizedDate);
		
		JOptionPane.showMessageDialog(null, result);		
				
	}

	private static LocalDate CalculerProchainAnniversaire(MonthDay dateAnniv) {
		int year = LocalDate.now().getYear();
		if(MonthDay.now().isAfter(dateAnniv)) {
			year++;
		}
		return dateAnniv.atYear(year);
	}


	
	

}
