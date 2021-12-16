package fr.aragot.bookstore.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilisateur {
	private String nom;
	private String prenom;
	private int id;
	private Livre livre;
	private LocalDate dateEmprunt;
	private static int dureeMaxPret = 15;
	private static DateTimeFormatter dtf;
	private static int compteur = 0;
	
	// ===== CONSTRUCTEURS =====
	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = compteur++;
	}
	
	public Utilisateur(String nom, String prenom, Livre livre) {
		
	}
	// ===== METHODES =====
	
	// === GETTERS ===
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getId() {
		return id;
	}

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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
}
