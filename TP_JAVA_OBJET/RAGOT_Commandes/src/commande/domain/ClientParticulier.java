//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\ClientParticulier.java

package commande.domain;

import java.time.LocalDate;

public class ClientParticulier extends Client 
{
   
   /**
    * L'adresse personnelle du Client
    */
   private String adressePersonnelle;
   

/**
 * @param adressePersonnelle
 */
	public ClientParticulier(String nom,String prenom, LocalDate dateNaiss,String adressePersonnelle) {
		super(nom,prenom,dateNaiss);
		this.adressePersonnelle = adressePersonnelle;
	}


public String getAdressePersonnelle() {
	return adressePersonnelle;
}


public void setAdressePersonnelle(String adressePersonnelle) {
	this.adressePersonnelle = adressePersonnelle;
}
	
   
}
