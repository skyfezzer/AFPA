/***********************************************************************
 * Module:  EmprunterExemplaireController.java
 * Author:  Sk
 * Purpose: Defines the Class EmprunterExemplaireController
 ***********************************************************************/

package vueLogique.biblio_controller;

import vueLogique.biblio_ui.FenetreGestionEmprunts;
import vueLogique.biblio_ui.FenetreRecapEmprunt;
import vueLogique.biblio_ui.FenetreNouvelEmprunt;
import vueLogique.biblio_dao.AdherentDAO;
import vueLogique.biblio_dao.ExemplaireDAO;
import vueLogique.biblio_dao.PretDAO;
import vueLogique.biblio_domain.Adherent;
import java.util.*;

/** @pdOid 7dc61327-3cbe-4853-b399-0024b877fafa */
public class EmprunterExemplaireController {
   /** @pdRoleInfo migr=no name=FenetreGestionEmprunts assc=Ctl mult=0..1 */
   public FenetreGestionEmprunts fenetreGestionEmprunts;
   /** @pdRoleInfo migr=no name=FenetreRecapEmprunt assc=Ctl mult=0..1 */
   public FenetreRecapEmprunt fenetreRecapEmprunt;
   /** @pdRoleInfo migr=no name=FenetreNouvelEmprunt assc=Ctl mult=0..1 */
   public FenetreNouvelEmprunt fenetreNouvelEmprunt;
   /** @pdRoleInfo migr=no name=AdherentDAO assc=compteDao mult=0..1 */
   public AdherentDAO adherentDAO;
   /** @pdRoleInfo migr=no name=ExemplaireDAO assc=exemplaireDao mult=0..1 */
   public ExemplaireDAO exemplaireDAO;
   /** @pdRoleInfo migr=no name=PretDAO assc=pretDao mult=0..1 */
   public PretDAO pretDAO;
   /** @pdRoleInfo migr=no name=Adherent assc=client mult=0..1 */
   public Adherent adherent;
   
   /** @pdOid 08d64c15-64f3-4ee9-9779-e7a5697842e7 */
   public boolean isPinOK() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid b3c70733-b649-4847-8670-e9c3cc6a4ea5 */
   public boolean isUtilisateurOK() {
      // TODO: implement
      return false;
   }
   
   /** @param pin
    * @pdOid 8f9b0b2e-c990-4300-8824-a0a1999c9cc1 */
   public void enterPinAdherent(String pin) {
      // TODO: implement
   }
   
   /** @param noAdherent
    * @pdOid c1e22d9f-5c7a-4338-a250-c5489b92e577 */
   public void enterNoAdherent(int noAdherent) {
      // TODO: implement
   }
   
   /** @param isbn
    * @pdOid e8baeb1e-5131-42cd-97ba-7f8272da4fdb */
   public void enterISBNLivre(int isbn) {
      // TODO: implement
   }
   
   /** @param codeExemplaire
    * @pdOid 4734b06e-fd8a-46ea-a88c-4aa3b9a37f16 */
   public int enterCodeExemplaire(int codeExemplaire) {
      // TODO: implement
      return 0;
   }
   
   /** @param exemplaire
    * @pdOid 7138ae66-8e51-458e-a5a6-204fb6c61969 */
   public boolean isExemplaireDispo(Exemplaire exemplaire) {
      // TODO: implement
      return false;
   }
   
   /** @param emprunt
    * @pdOid 1068f1d3-4da7-4302-a907-ad3893b2bfc6 */
   public int validerEmprunt(Pret emprunt) {
      // TODO: implement
      return 0;
   }

}