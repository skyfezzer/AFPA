/***********************************************************************
 * Module:  Pret.java
 * Author:  Sk
 * Purpose: Defines the Class Pret
 ***********************************************************************/

package biblio.domain;

import java.sql.Date;

/**
 * Cette classe conceptualise les prêts d'exemplaires.
 * 
 * @pdOid 09e251f1-51fa-4bba-b70b-5199423c6d0b
 */
public class Pret {	
	

	public Pret(Integer noPret, Date dateEmprunt, Integer dureePret, Exemplaire exemplaire, HistoPret historique_rendu,
			Utilisateur utilisateur) {
		super();
		this.setNoPret(noPret);
		this.setDateEmprunt(dateEmprunt);
		this.setDureePret(dureePret==null?DEFAULT_DUREE_PRET:dureePret);
		this.setHistorique_rendu(historique_rendu);
		this.setUtilisateur(utilisateur);
		this.setExemplaire(exemplaire);
	}

	/** @pdOid 19c56d99-f7bc-449c-b7f7-06a811d81ab8 */
	private Integer noPret;
	/** @pdOid 75e815d8-a436-4398-9210-aed70342f53a */
	private Date dateEmprunt;
	/** @pdOid 5ecaa4eb-856c-453e-8d39-0d141096b253 */
	private Integer dureePret;
	
	private Exemplaire exemplaire;
	

	public static final Integer DEFAULT_DUREE_PRET = 15;
	
	/**
	 * Un historique stocke un et un seul prêt Un prêt peut être stocké ou non par
	 * un historique.
	 */
	/** @pdRoleInfo migr=no name=HistoPret assc=stocker mult=0..1 */
	public HistoPret historique_rendu;
	/**
	 * Un prêt est attribué à un et un seul utilisateur. Un utilisateur peut
	 * réaliser de 0 à plusieurs emprunts.
	 */
	/** @pdRoleInfo migr=no name=Utilisateur assc=attribuer mult=1..1 */
	public Utilisateur utilisateur;

	/** @pdGenerated default parent getter */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newUtilisateur
	 */
	public void setUtilisateur(Utilisateur newUtilisateur) {
		if (this.utilisateur == null || !this.utilisateur.equals(newUtilisateur)) {
			if (this.utilisateur != null) {
				Utilisateur oldUtilisateur = this.utilisateur;
				this.utilisateur = null;
				oldUtilisateur.removeLesPrets(this);
			}
			if (newUtilisateur != null) {
				this.utilisateur = newUtilisateur;
				this.utilisateur.addLesPrets(this);
			}
		}
	}

	/**
	 * @return the noPret
	 */
	public Integer getNoPret() {
		return noPret;
	}

	/**
	 * @param noPret the noPret to set
	 */
	public void setNoPret(Integer noPret) {
		this.noPret = noPret;
	}

	/**
	 * @return the dateEmprunt
	 */
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * @param dateEmprunt the dateEmprunt to set
	 */
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	/**
	 * @return the dureePret
	 */
	public Integer getDureePret() {
		return dureePret;
	}

	/**
	 * @param dureePret the dureePret to set
	 */
	public void setDureePret(Integer dureePret) {
		this.dureePret = dureePret;
	}

	/**
	 * @return the historique_rendu
	 */
	public HistoPret getHistorique_rendu() {
		return historique_rendu;
	}

	/**
	 * @param historique_rendu the historique_rendu to set
	 */
	public void setHistorique_rendu(HistoPret historique_rendu) {
		this.historique_rendu = historique_rendu;
	}

	/**
	 * @return the exemplaire
	 */
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	/**
	 * @param exemplaire the exemplaire to set
	 */
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

}