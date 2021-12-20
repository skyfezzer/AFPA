package fr.aragot.bookstore.domain;

public class Personne implements IBavard{

	protected String nom;
	protected String prenom;
	protected String id;

	public Personne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getIdUtilisateur() {
		return id;
	}

	public Personne setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Personne setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	public Personne setIdUtilisateur(String id) {
		this.id = id;
		return this;
	}

	@Override
	public void parle() {
		System.out.printf("Je m'appelle %s %s.\n",nom,prenom);
		
	}

}