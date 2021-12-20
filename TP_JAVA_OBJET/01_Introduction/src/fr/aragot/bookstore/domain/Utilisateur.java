package fr.aragot.bookstore.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilisateur extends Personne {
	private Livre livre;
	private LocalDate dateEmprunt;
	private static int dureeMaxPret = 15;
	private static DateTimeFormatter dtf;
	private static int compteur = 0;
	
	// ===== CONSTRUCTEURS =====
	public Utilisateur() {
		this(null,null);
	}
	public Utilisateur(String nom, String prenom) {
		this(nom,prenom,String.valueOf(compteur++));
	}
	public Utilisateur(String nom, String prenom, String id) {
		this(nom,prenom,id,null);
	}
	
	public Utilisateur(String nom, String prenom, Livre livre) {
		this(nom,prenom,String.valueOf(compteur++),livre);
	}
	
	public Utilisateur(String nom, String prenom, String id, Livre livre) {
		super();
		((Utilisateur) this.setNom(nom)
			.setPrenom(prenom)
			.setIdUtilisateur(id))
			.setLivre(livre);
	}
	// ===== METHODES =====

	public Livre getLivre() {
		return livre;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	
	public boolean isPretEnRetard() {
		if(dateEmprunt == null)
			return false;
		return dateEmprunt.plusDays(dureeMaxPret).isAfter(LocalDate.now());
	}

	public static int getDureeMaxPret() {
		return dureeMaxPret;
	}
	// === SETTERS ===

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
}
