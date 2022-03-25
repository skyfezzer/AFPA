/***********************************************************************
 * Module:  Employe.java
 * Author:  Sk
 * Purpose: Defines the Class Employe
 ***********************************************************************/

package biblio.domain;

/** @pdOid 72a03d2c-4871-4eed-9cb8-e1134ef5776b */
public class Employe extends Utilisateur {
	public Employe(Integer noPersonne, String nom, String prenom, String gradeEmploye, Bibliotheque biblio) {
		super(noPersonne, nom, prenom, (short) 1);
		this.setGradeEmploye(gradeEmploye);
		this.setBiblio(biblio);
	}

	private String gradeEmploye;

	/** @pdRoleInfo migr=no name=Bibliotheque assc=travailler mult=1..1 */
	public Bibliotheque biblio;

	/** @pdGenerated default parent getter */
	public Bibliotheque getBiblio() {
		return biblio;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newBibliotheque
	 */
	public void setBiblio(Bibliotheque newBibliotheque) {
		if (this.biblio == null || !this.biblio.equals(newBibliotheque)) {
			if (this.biblio != null) {
				Bibliotheque oldBibliotheque = this.biblio;
				this.biblio = null;
				oldBibliotheque.removeLesEmployes(this);
			}
			if (newBibliotheque != null) {
				this.biblio = newBibliotheque;
				this.biblio.addLesEmployes(this);
			}
		}
	}

	/**
	 * @return the gradeEmploye
	 */
	public String getGradeEmploye() {
		return gradeEmploye;
	}

	/**
	 * @param gradeEmploye the gradeEmploye to set
	 */
	public void setGradeEmploye(String gradeEmploye) {
		this.gradeEmploye = gradeEmploye;
	}

	@Override
	public String toString() {
		return "Employe [getBiblio()=" + getBiblio() + ", getGradeEmploye()=" + getGradeEmploye() + ", getNoPersonne()="
				+ getNoPersonne() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}

	
}