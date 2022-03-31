/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Sk
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/** @pdOid ae25ba2a-475a-4ee4-bed1-0a6b08bf0710 */
public abstract class Utilisateur{
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
	private String nom, prenom;
	private Integer noPersonne;
	
	public Utilisateur(Integer noPersonne, String nom, String prenom, Short employe) {
		this(noPersonne,nom,prenom,employe,null);
	}
	
	
	public Utilisateur(Integer noPersonne, String nom, String prenom, Short employe, Collection<Pret> lesPrets) {
		super();
		this.noPersonne = noPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.employe = employe;
		this.lesPrets = lesPrets;
	}


	/**
	 * @return the lesPrets
	 */
	public java.util.Collection<Pret> getLesPrets() {
		return lesPrets;
	}
	/**
	 * @param lesPrets the lesPrets to set
	 */
	public void setLesPrets(java.util.Collection<Pret> lesPrets) {
		this.lesPrets = lesPrets;
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
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the noPersonne
	 */
	public Integer getNoPersonne() {
		return noPersonne;
	}


	/**
	 * @param noPersonne the noPersonne to set
	 */
	public void setNoPersonne(Integer noPersonne) {
		this.noPersonne = noPersonne;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noPersonne == null) ? 0 : noPersonne.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (noPersonne == null) {
			if (other.noPersonne != null)
				return false;
		} else if (!noPersonne.equals(other.noPersonne))
			return false;
		return true;
	}


	public boolean isEmploye() {
		if(getEmploye()!=null) {
			if(getEmploye()==1) {
				return true;
			}
		}
		return false;
	}

	
	
}