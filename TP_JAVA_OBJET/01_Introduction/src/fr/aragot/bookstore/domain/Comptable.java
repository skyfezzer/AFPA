package fr.aragot.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

public class Comptable {
	// ===== VARIABLES =====
	private static Comptable singleton;
	
	private List<Livre> livres = new ArrayList<>();
	
	// ===== CONSTRUCTEURS =====
	private Comptable() {
		
	}
	
	// ===== METHODES =====
	public static Comptable getInstance() {
		if(singleton==null) {
			singleton = new Comptable();
		}
		
		return singleton;
	}
	
	public void comptabilise(Livre l) {
		livres.add(l);		
	}
	
	
	/**
	 * @return La somme de tous les prix des livres comptabilis�s
	 */
	public double getTotalPrix() {
		return livres.stream().mapToDouble(x->x.getPrix()).sum();
	}
	
}
