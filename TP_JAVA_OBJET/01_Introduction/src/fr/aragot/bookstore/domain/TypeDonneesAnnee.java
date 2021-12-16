package fr.aragot.bookstore.domain;

public class TypeDonneesAnnee {
	
	private Livre livre;
	private int annee;
	
	public TypeDonneesAnnee(int annee, Livre l) {
		this.setAnnee(annee,l);
	}

	public int getAnnee() {
		return annee;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setAnnee(int annee, Livre livre) {
		if(annee <= 0) {
			throw new IllegalArgumentException("L'année ne peut pas être négative");
		}
		this.annee = annee;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	
}
