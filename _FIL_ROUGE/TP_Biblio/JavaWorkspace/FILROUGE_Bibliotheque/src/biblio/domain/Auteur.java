/***********************************************************************
 * Module:  Auteur.java
 * Author:  Sk
 * Purpose: Defines the Class Auteur
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/** @pdOid 9d5d6f1d-93eb-463b-b328-28ade5346507 */
public class Auteur {
	public Auteur(Integer noAuteur, String nomCompletAuteur) {
		super();
		this.noAuteur = noAuteur;
		this.nomCompletAuteur = nomCompletAuteur;
	}

	/** @pdOid 6cbae86b-10d1-41f0-9bc9-2845defa7d56 */
	private Integer noAuteur;
	/** @pdOid 09fe3b7a-cbd0-4521-a7ad-79848fa06032 */
	private String nomCompletAuteur;

	/**
	 * Un livre est écrit par un auteur. Un auteur peut écrire 0 ou plusieurs
	 * livres.
	 */
	/**
	 * @pdRoleInfo migr=no name=Livre assc=ecrire coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..*
	 */
	public java.util.Collection<Livre> realisations;

	/** @pdGenerated default getter */
	public java.util.Collection<Livre> getRealisations() {
		if (realisations == null)
			realisations = new java.util.HashSet<Livre>();
		return realisations;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorRealisations() {
		if (realisations == null)
			realisations = new java.util.HashSet<Livre>();
		return realisations.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newRealisations
	 */
	public void setRealisations(java.util.Collection<Livre> newRealisations) {
		removeAllRealisations();
		for (java.util.Iterator iter = newRealisations.iterator(); iter.hasNext();)
			addRealisations((Livre) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newLivre
	 */
	public void addRealisations(Livre newLivre) {
		if (newLivre == null)
			return;
		if (this.realisations == null)
			this.realisations = new java.util.HashSet<Livre>();
		if (!this.realisations.contains(newLivre)) {
			this.realisations.add(newLivre);
			newLivre.setAuteur(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldLivre
	 */
	public void removeRealisations(Livre oldLivre) {
		if (oldLivre == null)
			return;
		if (this.realisations != null)
			if (this.realisations.contains(oldLivre)) {
				this.realisations.remove(oldLivre);
				oldLivre.setAuteur((Auteur) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllRealisations() {
		if (realisations != null) {
			Livre oldLivre;
			for (java.util.Iterator iter = getIteratorRealisations(); iter.hasNext();) {
				oldLivre = (Livre) iter.next();
				iter.remove();
				oldLivre.setAuteur((Auteur) null);
			}
		}
	}

	/**
	 * @return the noAuteur
	 */
	public Integer getNoAuteur() {
		return noAuteur;
	}

	/**
	 * @param noAuteur the noAuteur to set
	 */
	public void setNoAuteur(Integer noAuteur) {
		this.noAuteur = noAuteur;
	}

	/**
	 * @return the nomCompletAuteur
	 */
	public String getNomCompletAuteur() {
		return nomCompletAuteur;
	}

	/**
	 * @param nomCompletAuteur the nomCompletAuteur to set
	 */
	public void setNomCompletAuteur(String nomCompletAuteur) {
		this.nomCompletAuteur = nomCompletAuteur;
	}

	@Override
	public String toString() {
		return "Auteur [getRealisations()=" + getRealisations() + ", getNoAuteur()=" + getNoAuteur()
				+ ", getNomCompletAuteur()=" + getNomCompletAuteur() + "]";
	}
	
	

}