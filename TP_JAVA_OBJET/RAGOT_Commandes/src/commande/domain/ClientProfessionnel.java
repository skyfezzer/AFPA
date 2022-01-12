//Source file: E:\\22_ETUDE_CONCEPTOBJET_UMLDiagDeClasse__CUs__ROSE\\269_DEMO_20211222_Rose_PresentationDesDiagrammes_saufCU_LesCommandes\\java\\commande\\domain\\ClientProfessionnel.java

package commande.domain;

import java.time.LocalDate;

public class ClientProfessionnel extends Client 
{
   private String noSiret;
   
   /**
    * @roseuid 61D413B300CE
    */
   public ClientProfessionnel(String nom,String prenom, LocalDate dateNaiss,String noSiret) {
		super(nom,prenom,dateNaiss);
		this.noSiret = noSiret;
	}

@Override
public String toString() {
	return "ClientProfessionnel [noSiret=" + noSiret + super.toString() + "]";
}
   
}
