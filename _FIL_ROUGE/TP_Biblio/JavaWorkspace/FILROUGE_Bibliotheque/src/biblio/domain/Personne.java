/***********************************************************************
 * Module:  Personne.java
 * Author:  Sk
 * Purpose: Defines the Class Personne
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/**
 * Cette classe conceptualise une personne
 * 
 * @pdOid 978dd6ec-dad4-4d97-8242-7b797fbe685c
 */
public class Personne {
	public Personne(Integer noPersonne, String nom, String prenom) {
		super();
		this.setNoPersonne(noPersonne);
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	/** @pdOid 499f13d8-9063-41c0-9f8e-4cce48656376 */
	private Integer noPersonne;
	/** @pdOid 30852531-7f3f-4f20-bfca-76771a4d0d4e */
	private String nom;
	/** @pdOid 5e803e20-ce72-4ba3-b5d3-6e4edb323bab */
	private String prenom;

	public Integer getNoPersonne() {
		return noPersonne;
	}

	public void setNoPersonne(Integer noPersonne) {
		this.noPersonne = noPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}