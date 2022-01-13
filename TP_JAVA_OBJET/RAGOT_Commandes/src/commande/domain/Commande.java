//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\Commande.java

package commande.domain;

import java.time.LocalDate;

public class Commande {
	private Integer noCommande;
	private String adresseLivraison;
	private LocalDate dateCommande;

	private Article article;// Association de plusieurs à Un

	private Integer qte;

	/**
	 * @roseuid 61D413B3020F
	 */
	public Commande() {

	}

	/**
	 * @param noCommande
	 * @param adresseLivraison
	 * @param dateCommande
	 * @param article
	 * @param qte
	 */
	public Commande(Integer noCommande, String adresseLivraison, LocalDate dateCommande, Article article, Integer qte) {
		super();
		this.noCommande = noCommande;
		this.adresseLivraison = adresseLivraison;
		this.dateCommande = dateCommande;
		this.article = article;
		this.qte = qte;
	}

	/**
	 * @param noCommande
	 * @param adresseLivraison
	 * @param dateCommande
	 */
	public Commande(Integer noCommande, String adresseLivraison, LocalDate dateCommande) {
		this(noCommande,adresseLivraison,dateCommande,null,null);
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Integer getNoCommande() {
		return noCommande;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}
	
	
}
