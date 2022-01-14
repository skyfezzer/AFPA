package fr.aragot.webmail;

public class AdresseMail {
	private String nom;
	private String email;
	
	public AdresseMail() {
		this("","");
	}

	public AdresseMail(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return nom + ", " + email;
	}
	
	
	
	
}
