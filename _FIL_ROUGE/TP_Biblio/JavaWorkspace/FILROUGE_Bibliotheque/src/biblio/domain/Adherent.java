/***********************************************************************
 * Module:  Adherent.java
 * Author:  Sk
 * Purpose: Defines the Class Adherent
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/** @pdOid 8a8d7a07-c165-4871-a32c-3ed3a50450ff */
public class Adherent extends Utilisateur {
	public Adherent(Integer noPersonne, String nom, String prenom, String noTelAdherent, String pin) {
		super(noPersonne, nom, prenom, (short) 0);
		this.noTelAdherent = noTelAdherent;
		this.pin = pin;
	}

	/** @pdOid 79d98ff4-9d92-4033-8785-c4f1fe85cd52 */
	private String noTelAdherent;
	/** @pdOid d2bc03ae-6a2a-4a47-8197-305abdb0c3fb */
	private String pin;

	/**
	 * Un adhérent peut être puni de 0 à plusieurs amendes. Une amende puni un et un
	 * seul utilisateur.
	 */
	/**
	 * @pdRoleInfo migr=no name=Dette assc=punir coll=java.util.Collection
	 *             impl=java.util.ArrayList mult=0..*
	 */
	public java.util.Collection<Dette> lesDettes;
	
	/**
	 * @return the noTelAdherent
	 */
	public String getNoTelAdherent() {
		return noTelAdherent;
	}

	/**
	 * @param noTelAdherent the noTelAdherent to set
	 */
	public void setNoTelAdherent(String noTelAdherent) {
		this.noTelAdherent = noTelAdherent;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Dette> getLesDettes() {
		if (lesDettes == null)
			lesDettes = new java.util.ArrayList<Dette>();
		return lesDettes;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<Dette> getIteratorLesDettes() {
		if (lesDettes == null)
			lesDettes = new java.util.ArrayList<Dette>();
		return lesDettes.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newLesDettes
	 */
	public void setLesDettes(java.util.Collection<Dette> newLesDettes) {
		removeAllLesDettes();
		for (java.util.Iterator<Dette> iter = newLesDettes.iterator(); iter.hasNext();)
			addLesDettes(iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDette
	 */
	public void addLesDettes(Dette newDette) {
		if (newDette == null)
			return;
		if (this.lesDettes == null)
			this.lesDettes = new java.util.ArrayList<Dette>();
		if (!this.lesDettes.contains(newDette)) {
			this.lesDettes.add(newDette);
			newDette.setAdherent(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDette
	 */
	public void removeLesDettes(Dette oldDette) {
		if (oldDette == null)
			return;
		if (this.lesDettes != null)
			if (this.lesDettes.contains(oldDette)) {
				this.lesDettes.remove(oldDette);
				oldDette.setAdherent((Adherent) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllLesDettes() {
		if (lesDettes != null) {
			Dette oldDette;
			for (java.util.Iterator<Dette> iter = getIteratorLesDettes(); iter.hasNext();) {
				oldDette = iter.next();
				iter.remove();
				oldDette.setAdherent((Adherent) null);
			}
		}
	}

	@Override
	public String toString() {
		return "Adherent [getNoTelAdherent()=" + getNoTelAdherent() + ", getPin()=" + getPin() + ", getLesDettes()="
				+ getLesDettes() + ", getNoPersonne()=" + getNoPersonne() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}
	
	

}