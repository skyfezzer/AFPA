/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Sk
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/** @pdOid ae25ba2a-475a-4ee4-bed1-0a6b08bf0710 */
public class Utilisateur extends Personne {
	/**
	 * Un prêt est attribué à un et un seul utilisateur. Un utilisateur peut
	 * réaliser de 0 à plusieurs emprunts.
	 */
	/**
	 * @pdRoleInfo migr=no name=Pret assc=attribuer coll=java.util.Collection
	 *             impl=java.util.ArrayList mult=0..* side=A
	 */
	public java.util.Collection<Pret> lesPrets;
	private Short employe;

	public Utilisateur(Integer noPersonne, String nom, String prenom, Short employe) {
		super(noPersonne, nom, prenom);
		this.setEmploye(employe);
	}
	public Utilisateur(Integer noPersonne, String nom, String prenom) {
		this(noPersonne,nom,prenom,null);
	}
	/** @pdGenerated default getter */
	public java.util.Collection<Pret> getLesPrets() {
		if (lesPrets == null)
			lesPrets = new java.util.ArrayList<Pret>();
		return lesPrets;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator<Pret> getIteratorLesPrets() {
		if (lesPrets == null)
			lesPrets = new java.util.ArrayList<Pret>();
		return lesPrets.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newLesPrets
	 */
	public void setLesPrets(java.util.Collection<Pret> newLesPrets) {
		removeAllLesPrets();
		for (Iterator<Pret> iter = newLesPrets.iterator(); iter.hasNext();)
			addLesPrets(iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newPret
	 */
	public void addLesPrets(Pret newPret) {
		if (newPret == null)
			return;
		if (this.lesPrets == null)
			this.lesPrets = new java.util.ArrayList<Pret>();
		if (!this.lesPrets.contains(newPret)) {
			this.lesPrets.add(newPret);
			newPret.setUtilisateur(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldPret
	 */
	public void removeLesPrets(Pret oldPret) {
		if (oldPret == null)
			return;
		if (this.lesPrets != null)
			if (this.lesPrets.contains(oldPret)) {
				this.lesPrets.remove(oldPret);
				oldPret.setUtilisateur((Utilisateur) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllLesPrets() {
		if (lesPrets != null) {
			Pret oldPret;
			for (java.util.Iterator<Pret> iter = getIteratorLesPrets(); iter.hasNext();) {
				oldPret = iter.next();
				iter.remove();
				oldPret.setUtilisateur((Utilisateur) null);
			}
		}
	}
	/**
	 * @return the employe
	 */
	public Short getEmploye() {
		return employe;
	}
	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Short employe) {
		this.employe = employe;
	}
	
	

}