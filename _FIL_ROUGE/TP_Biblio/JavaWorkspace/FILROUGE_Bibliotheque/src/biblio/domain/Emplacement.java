/***********************************************************************
 * Module:  Emplacement.java
 * Author:  Sk
 * Purpose: Defines the Class Emplacement
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/** @pdOid e0efbe89-e2a1-4d06-85e9-723a70336213 */
public class Emplacement {
	public Emplacement(Integer noEmplacement, Bibliotheque bibliotheque, Theme theme) {
		super();
		this.setNoEmplacement(noEmplacement);
		this.setTheme(theme);
		this.setBibliotheque(bibliotheque);
	}

	/** @pdOid 0e5f56fc-31d6-4994-a5c9-975562eb9502 */
	private Integer noEmplacement;

	/**
	 * Un emplacement est attribué pour un Thème. Un thème peut être attribué à 0 ou
	 * plusieurs emplacements.
	 */
	/** @pdRoleInfo migr=no name=Theme assc=trier mult=1..1 */
	public Theme theme;
	/** @pdRoleInfo migr=no name=Bibliotheque assc=localiser mult=1..1 */
	public Bibliotheque bibliotheque;
	/**
	 * Un exemplaire peut se ranger dans un emplacement. Un emplacement range 0 à
	 * plusieurs exemplaires.
	 */
	/**
	 * @pdRoleInfo migr=no name=Exemplaire assc=ranger coll=java.util.Collection
	 *             impl=java.util.ArrayList mult=0..* side=A
	 */
	public java.util.Collection<Exemplaire> lesExemplaires;

	/** @pdGenerated default parent getter */
	public Theme getTheme() {
		return theme;
	}



	/** @pdGenerated default parent getter */
	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newBibliotheque
	 */
	public void setBibliotheque(Bibliotheque newBibliotheque) {
		if (this.bibliotheque == null || !this.bibliotheque.equals(newBibliotheque)) {
			if (this.bibliotheque != null) {
				Bibliotheque oldBibliotheque = this.bibliotheque;
				this.bibliotheque = null;
				oldBibliotheque.removeLesEmplacements(this);
			}
			if (newBibliotheque != null) {
				this.bibliotheque = newBibliotheque;
				this.bibliotheque.addLesEmplacements(this);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Exemplaire> getLesExemplaires() {
		if (lesExemplaires == null)
			lesExemplaires = new java.util.ArrayList<Exemplaire>();
		return lesExemplaires;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<Exemplaire> getIteratorLesExemplaires() {
		if (lesExemplaires == null)
			lesExemplaires = new java.util.ArrayList<Exemplaire>();
		return lesExemplaires.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newLesExemplaires
	 */
	public void setLesExemplaires(java.util.Collection<Exemplaire> newLesExemplaires) {
		removeAllLesExemplaires();
		for (java.util.Iterator<Exemplaire> iter = newLesExemplaires.iterator(); iter.hasNext();)
			addLesExemplaires(iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newExemplaire
	 */
	public void addLesExemplaires(Exemplaire newExemplaire) {
		if (newExemplaire == null)
			return;
		if (this.lesExemplaires == null)
			this.lesExemplaires = new java.util.ArrayList<Exemplaire>();
		if (!this.lesExemplaires.contains(newExemplaire)) {
			this.lesExemplaires.add(newExemplaire);
			newExemplaire.setEmplacement(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldExemplaire
	 */
	public void removeLesExemplaires(Exemplaire oldExemplaire) {
		if (oldExemplaire == null)
			return;
		if (this.lesExemplaires != null)
			if (this.lesExemplaires.contains(oldExemplaire)) {
				this.lesExemplaires.remove(oldExemplaire);
				oldExemplaire.setEmplacement((Emplacement) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllLesExemplaires() {
		if (lesExemplaires != null) {
			Exemplaire oldExemplaire;
			for (java.util.Iterator<Exemplaire> iter = getIteratorLesExemplaires(); iter.hasNext();) {
				oldExemplaire = iter.next();
				iter.remove();
				oldExemplaire.setEmplacement((Emplacement) null);
			}
		}
	}

	/**
	 * @return the noEmplacement
	 */
	public Integer getNoEmplacement() {
		return noEmplacement;
	}

	/**
	 * @param noEmplacement the noEmplacement to set
	 */
	public void setNoEmplacement(Integer noEmplacement) {
		this.noEmplacement = noEmplacement;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}