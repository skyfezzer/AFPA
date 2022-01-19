package fr.aragot.cdtheque;

public class CD implements Comparable<CD>{
	private String reference,titre,auteur,genre;
	public CD() {
		this("","","","");
	}
	
	public CD(String reference, String titre, String auteur, String genre) {
		this.setReference(reference).setAuteur(auteur).setTitre(titre).setGenre(genre);
	}

	public String getReference() {
		return reference;
	}
	public CD setReference(String reference) {
		this.reference = reference;
		return this;
	}
	public String getTitre() {
		return titre;
	}
	public CD setTitre(String titre) {
		this.titre = titre;
		return this;
	}
	public String getAuteur() {
		return auteur;
	}
	public CD setAuteur(String auteur) {
		this.auteur = auteur;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public CD setGenre(String genre) {
		this.genre = genre;
		return this;
	}

	@Override
	public String toString() {
		return "CD [reference=" + reference + ", titre=" + titre + ", auteur=" + auteur + ", genre=" + genre + "]";
	}

	@Override
	public int compareTo(CD o) {
		return this.getReference().compareTo(o.getReference());
	}
	
	
}
