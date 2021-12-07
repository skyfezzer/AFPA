package fr.afpa.util;

import java.time.DayOfWeek;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

public class TrouveJoursFeries {

	static final MonthDay[] joursFeries = {
			MonthDay.of(1, 1),
			MonthDay.of(5, 1),
			MonthDay.of(5, 8),
			MonthDay.of(7, 14),
			MonthDay.of(8, 15),
			MonthDay.of(11, 01),
			MonthDay.of(11, 11),
			MonthDay.of(12, 25),
	};
	
	static final DateTimeFormatter LOCALIZED_FORMAT = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.FRENCH);
	static final char DOT = '\u25AA';
	
	public static void main(String[] args) {
		int year = demandeAnnee();
		afficheJoursFeries(year);

	}

	private static void afficheJoursFeries(int year) {
		StringBuilder sb2 = new StringBuilder();
		int nbJoursWeekend = 0;
		for(MonthDay mDay : joursFeries) {
			sb2.append(DOT+mDay.atYear(year).format(LOCALIZED_FORMAT)+'\n');
			if(mDay.atYear(year).getDayOfWeek().equals(DayOfWeek.SATURDAY) || mDay.atYear(year).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				nbJoursWeekend++;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Calendrier français des jours fériés de %d (%d jours hors weekend) :\n", year,11-nbJoursWeekend));
		sb.append("Jours fériés fixes :\n");
		sb.append(DOT+"Lundi de pâques\n");
		sb.append(DOT+"Jeudi de l'ascension\n");
		sb.append(DOT+"Lundi de pentecôte\n");
		sb.append("Jours fériés mobiles :\n");
		sb.append(sb2);
		
		
		JOptionPane.showMessageDialog(null,sb.toString());
		
	}

	private static int demandeAnnee() {
		while(true) {
			try {
				return Integer.parseInt(JOptionPane.showInputDialog(null,"Année dont on cherche les jours fériés :"));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erreur dans la lecture de l'année, merci d'entrer une année correcte.");
			}
		}
	}
	
	

}
