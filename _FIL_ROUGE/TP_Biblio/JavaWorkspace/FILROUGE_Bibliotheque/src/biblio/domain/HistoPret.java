/***********************************************************************
 * Module:  HistoPret.java
 * Author:  Sk
 * Purpose: Defines the Class HistoPret
 ***********************************************************************/

package biblio.domain;

import java.util.*;

/**
 * Cette classe conceptualise la fin d'un prêt
 * 
 * @pdOid 16fa42b8-493b-4dbf-b513-a07e5790e95e
 */
public class HistoPret {
	
	public HistoPret(Integer noHisto, Date dateRemise, Pret pret) {
		super();
		this.setNoHisto(noHisto);
		this.setDateRemise(dateRemise);
		this.setPret(pret);
	}

	/** @pdOid 23b91942-e30a-465d-9abf-47703266adc0 */
	private Integer noHisto;
	/** @pdOid daf3eb3f-3176-49d2-b159-b6261b32f723 */
	private Date dateRemise;

	/**
	 * Un historique stocke un et un seul prêt Un prêt peut être stocké ou non par
	 * un historique.
	 */
	/** @pdRoleInfo migr=no name=Pret assc=stocker mult=1..1 side=A */
	public Pret pret;

	/**
	 * @return the noHisto
	 */
	public Integer getNoHisto() {
		return noHisto;
	}

	/**
	 * @param noHisto the noHisto to set
	 */
	public void setNoHisto(Integer noHisto) {
		this.noHisto = noHisto;
	}

	/**
	 * @return the dateRemise
	 */
	public Date getDateRemise() {
		return dateRemise;
	}

	/**
	 * @param dateRemise the dateRemise to set
	 */
	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	/**
	 * @return the pret
	 */
	public Pret getPret() {
		return pret;
	}

	/**
	 * @param pret the pret to set
	 */
	public void setPret(Pret pret) {
		this.pret = pret;
	}

	
}