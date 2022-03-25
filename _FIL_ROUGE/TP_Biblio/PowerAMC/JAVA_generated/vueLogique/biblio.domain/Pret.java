/***********************************************************************
 * Module:  Pret.java
 * Author:  Sk
 * Purpose: Defines the Class Pret
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** Cette classe conceptualise les prêts d'exemplaires.
 * 
 * @pdOid 09e251f1-51fa-4bba-b70b-5199423c6d0b */
public class Pret {
   /** @pdOid 19c56d99-f7bc-449c-b7f7-06a811d81ab8 */
   private Integer noPret;
   /** @pdOid 75e815d8-a436-4398-9210-aed70342f53a */
   private Date dateEmprunt;
   /** @pdOid 5ecaa4eb-856c-453e-8d39-0d141096b253 */
   private Integer dureePret = 15;
   
   /** Un historique stocke un et un seul prêt
    * Un prêt peut être stocké ou non par un historique. */
   /** @pdRoleInfo migr=no name=HistoPret assc=stocker mult=0..1 */
   public HistoPret historique_rendu;
   /** Un prêt est attribué à un et un seul utilisateur.
    * Un utilisateur peut réaliser de 0 à plusieurs emprunts. */
   /** @pdRoleInfo migr=no name=Utilisateur assc=attribuer mult=1..1 */
   public Utilisateur utilisateur;
   
   
   /** @pdGenerated default parent getter */
   public Utilisateur getUtilisateur() {
      return utilisateur;
   }
   
   /** @pdGenerated default parent setter
     * @param newUtilisateur */
   public void setUtilisateur(Utilisateur newUtilisateur) {
      if (this.utilisateur == null || !this.utilisateur.equals(newUtilisateur))
      {
         if (this.utilisateur != null)
         {
            Utilisateur oldUtilisateur = this.utilisateur;
            this.utilisateur = null;
            oldUtilisateur.removeLesPrets(this);
         }
         if (newUtilisateur != null)
         {
            this.utilisateur = newUtilisateur;
            this.utilisateur.addLesPrets(this);
         }
      }
   }

}