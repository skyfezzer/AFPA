/***********************************************************************
 * Module:  Employe.java
 * Author:  Sk
 * Purpose: Defines the Class Employe
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid 72a03d2c-4871-4eed-9cb8-e1134ef5776b */
public class Employe extends Utilisateur {
   /** @pdOid 1aedbb5e-92e2-419a-8e99-ad83906aa100 */
   private String gradeEmploye;
   
   /** @pdRoleInfo migr=no name=Bibliotheque assc=travailler mult=1..1 */
   public Bibliotheque biblio;
   
   
   /** @pdGenerated default parent getter */
   public Bibliotheque getBiblio() {
      return biblio;
   }
   
   /** @pdGenerated default parent setter
     * @param newBibliotheque */
   public void setBiblio(Bibliotheque newBibliotheque) {
      if (this.biblio == null || !this.biblio.equals(newBibliotheque))
      {
         if (this.biblio != null)
         {
            Bibliotheque oldBibliotheque = this.biblio;
            this.biblio = null;
            oldBibliotheque.removeLesEmployes(this);
         }
         if (newBibliotheque != null)
         {
            this.biblio = newBibliotheque;
            this.biblio.addLesEmployes(this);
         }
      }
   }

}