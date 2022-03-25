/***********************************************************************
 * Module:  Exemplaire.java
 * Author:  Sk
 * Purpose: Defines the Class Exemplaire
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/**
 * Cette classe conceptualise l'exemplaire d'un livre.
 * 
 * @pdOid cf477314-60cb-43c3-a4ee-107686219802
 */
public class Exemplaire {
	
	public Exemplaire(Short codeExemplaire, String commentaireExemplaire, Emplacement emplacement, Livre livre) {
		super();
		this.setCodeExemplaire(codeExemplaire);
		this.setCommentaireExemplaire(commentaireExemplaire);
		this.setEmplacement(emplacement);
		this.setLivre(livre);
	}

	/** @pdOid a008cd7e-ef35-4ff3-9323-8eb914bd4daa */
	private Short codeExemplaire;
	/** @pdOid ee0d396f-099a-42e6-9042-0b7f6d4cd3ed */
	private String commentaireExemplaire;

	/**
	 * Un exemplaire peut se ranger dans un emplacement. Un emplacement range 0 à
	 * plusieurs exemplaires.
	 */
	/** @pdRoleInfo migr=no name=Emplacement assc=ranger mult=0..1 */
	public Emplacement emplacement;
	/**
	 * Un livre est matérialisé par 0 à plusieurs exemplaires. Un exemplaire
	 * matérialise un livre.
	 */
	/** @pdRoleInfo migr=no name=Livre assc=materialiser mult=1..1 */
	public Livre livre;

	/** @pdGenerated default parent getter */
	public Emplacement getEmplacement() {
		return emplacement;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newEmplacement
	 */
	public void setEmplacement(Emplacement newEmplacement) {
		if (this.emplacement == null || !this.emplacement.equals(newEmplacement)) {
			if (this.emplacement != null) {
				Emplacement oldEmplacement = this.emplacement;
				this.emplacement = null;
				oldEmplacement.removeLesExemplaires(this);
			}
			if (newEmplacement != null) {
				this.emplacement = newEmplacement;
				this.emplacement.addLesExemplaires(this);
			}
		}
	}

	/** @pdGenerated default parent getter */
	public Livre getLivre() {
		return livre;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newLivre
	 */
	public void setLivre(Livre newLivre) {
		if (this.livre == null || !this.livre.equals(newLivre)) {
			if (this.livre != null) {
				Livre oldLivre = this.livre;
				this.livre = null;
				oldLivre.removeLesExemplaires(this);
			}
			if (newLivre != null) {
				this.livre = newLivre;
				this.livre.addLesExemplaires(this);
			}
		}
	}

	/**
	 * @return the codeExemplaire
	 */
	public Short getCodeExemplaire() {
		return codeExemplaire;
	}

	/**
	 * @param codeExemplaire the codeExemplaire to set
	 */
	public void setCodeExemplaire(Short codeExemplaire) {
		this.codeExemplaire = codeExemplaire;
	}

	/**
	 * @return the commentaireExemplaire
	 */
	public String getCommentaireExemplaire() {
		return commentaireExemplaire;
	}

	/**
	 * @param commentaireExemplaire the commentaireExemplaire to set
	 */
	public void setCommentaireExemplaire(String commentaireExemplaire) {
		this.commentaireExemplaire = commentaireExemplaire;
	}

	@Override
	public String toString() {
		return "Exemplaire [getEmplacement()=" + getEmplacement() + ", getLivre()=" + getLivre()
				+ ", getCodeExemplaire()=" + getCodeExemplaire() + ", getCommentaireExemplaire()="
				+ getCommentaireExemplaire() + "]";
	}
	

}