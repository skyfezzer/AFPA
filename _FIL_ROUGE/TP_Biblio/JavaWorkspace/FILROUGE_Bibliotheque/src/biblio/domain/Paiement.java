/***********************************************************************
 * Module:  Paiement.java
 * Author:  Sk
 * Purpose: Defines the Class Paiement
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/**
 * Cette classe conceptualise les paiements de cotisations ainsi que les
 * amendes.
 * 
 * @pdOid a79d694b-b0f4-4130-bc63-a76776df4567
 */
public class Paiement {
	
	public Paiement(Integer noPaiement, Float montantPaiement, Date datePaiement, String typePaiement, Dette dette) {
		super();
		this.setNoPaiement(noPaiement);
		this.setMontantPaiement(montantPaiement);
		this.setDatePaiement(datePaiement);
		this.setTypePaiement(typePaiement);
		this.setDette(dette);
		
	}

	/** @pdOid 6685521e-f7df-45a0-81e6-7e0a32569776 */
	private Integer noPaiement;
	/** @pdOid f5801919-81d7-452d-a305-1127b8943c7a */
	private Float montantPaiement;
	/** @pdOid 624d6de8-eb26-4be5-ab31-fe232a8897e5 */
	private Date datePaiement;
	/** @pdOid 7e7fe426-0ed0-4575-849e-534593a37241 */
	private String typePaiement;

	/**
	 * Une amende est payé en 0 à plusieurs paiements. Un paiement paie une et une
	 * seule amende.
	 */
	/** @pdRoleInfo migr=no name=Dette assc=payer mult=0..1 */
	public Dette dette;

	/** @pdGenerated default parent getter */
	public Dette getDette() {
		return dette;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newDette
	 */
	public void setDette(Dette newDette) {
		if (this.dette == null || !this.dette.equals(newDette)) {
			if (this.dette != null) {
				Dette oldDette = this.dette;
				this.dette = null;
				oldDette.removeLesPaiements(this);
			}
			if (newDette != null) {
				this.dette = newDette;
				this.dette.addLesPaiements(this);
			}
		}
	}

	/**
	 * @return the noPaiement
	 */
	public Integer getNoPaiement() {
		return noPaiement;
	}

	/**
	 * @param noPaiement the noPaiement to set
	 */
	public void setNoPaiement(Integer noPaiement) {
		this.noPaiement = noPaiement;
	}

	/**
	 * @return the montantPaiement
	 */
	public Float getMontantPaiement() {
		return montantPaiement;
	}

	/**
	 * @param montantPaiement the montantPaiement to set
	 */
	public void setMontantPaiement(Float montantPaiement) {
		this.montantPaiement = montantPaiement;
	}

	/**
	 * @return the datePaiement
	 */
	public Date getDatePaiement() {
		return datePaiement;
	}

	/**
	 * @param datePaiement the datePaiement to set
	 */
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	/**
	 * @return the typePaiement
	 */
	public String getTypePaiement() {
		return typePaiement;
	}

	/**
	 * @param typePaiement the typePaiement to set
	 */
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

}