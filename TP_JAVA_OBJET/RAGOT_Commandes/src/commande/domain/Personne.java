//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\Personne.java

package commande.domain;

import java.time.LocalDate;

/**
 * Le concept de la Personne
 */
public class Personne {
	private String nom;
	private String prenom;
	private LocalDate dateNaiss;

	/**
	 * @roseuid 61D413B30066
	 */

	public Personne(String nom, String prenom, LocalDate dateNaiss) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}

	public Personne() {
	}

	/**
	 * @return TypeAge
	 * @roseuid 61D411230024
	 */
	public TypeAge getAge() {

		return new TypeAge(dateNaiss.getYear() - LocalDate.now().getYear());
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + "]";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public static void main(String[] args) {

	}
}
