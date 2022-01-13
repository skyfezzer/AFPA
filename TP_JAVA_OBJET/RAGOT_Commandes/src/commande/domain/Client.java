//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\Client.java

package commande.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Personne {
	private Integer idClient;
	// private Commande commandes[]; //Association de Un à plusieurs
	private ArrayList<Commande> commandes = new ArrayList<>(); // Association de Un à plusieurs
	private static int compteur = 1000;

	/**
	 * @roseuid 61D413B30174
	 */
	public Client() {
		
	}
	

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @param idClient
	 */
	public Client(String nom, String prenom, LocalDate dateNaiss, Integer idClient) {
		super(nom, prenom, dateNaiss);
		this.idClient = idClient;
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 */
	public Client(String nom, String prenom, LocalDate dateNaiss) {
		this(nom, prenom, dateNaiss,compteur++);
	}


	public Client(Personne p) {
		this(p.getNom(),p.getPrenom(),p.getDateNaiss(),compteur++);
	}


	/**
	 * @return Currency
	 * @roseuid 61D41184022F
	 */
	public float getChiffreAffaire() {
		return (float) commandes.stream().mapToDouble(x->x.getQte()*x.getArticle().getPrix()).sum();
	}


	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", commandes=" + commandes + super.toString() + "]";
	}
	
}
