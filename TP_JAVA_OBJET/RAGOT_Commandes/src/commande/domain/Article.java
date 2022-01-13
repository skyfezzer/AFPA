//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\Article.java

package commande.domain;


public class Article implements Payable 
{
   private Integer noArticle;
   private String description;
   private float prixUnitaire;
   private EnumStatusStock etatStock;
   private static int compteur = 1000;
   
   /**
    * @roseuid 61D413B301C2
    */
   public Article() 
   {
    
   }
   
   public Article(Integer noArticle, String description, float prixUnitaire) {
	   this(noArticle,description,prixUnitaire,EnumStatusStock.PLEIN_100);
   }
   public Article(String description, float prixUnitaire) {
	   this(description,prixUnitaire,EnumStatusStock.PLEIN_100);
   }
   
   public Article(String description, float prixUnitaire, EnumStatusStock etatStock) {
	   this(compteur++,description,prixUnitaire,etatStock);
   }
   
   /**
 * @param noArticle
 * @param description
 * @param prixUnitaire
 * @param etatStock
 */
public Article(Integer noArticle, String description, float prixUnitaire, EnumStatusStock etatStock) {
	super();
	this.noArticle = noArticle;
	this.description = description;
	this.prixUnitaire = prixUnitaire;
	this.etatStock = etatStock;
}

/**
    * @return Currency
    * @roseuid 61D413B301D4
    */
   public float getPrix() 
   {
    return prixUnitaire;
   }

@Override
public String toString() {
	return "Article [noArticle=" + noArticle + ", description=" + description + ", prixUnitaire=" + prixUnitaire
			+ ", etatStock=" + etatStock + "]";
}
   
   
}
