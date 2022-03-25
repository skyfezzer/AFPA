/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Sk
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid ae25ba2a-475a-4ee4-bed1-0a6b08bf0710 */
public class Utilisateur extends Personne {
   /** Un prêt est attribué à un et un seul utilisateur.
    * Un utilisateur peut réaliser de 0 à plusieurs emprunts. */
   /** @pdRoleInfo migr=no name=Pret assc=attribuer coll=java.util.Collection impl=java.util.ArrayList mult=0..* side=A */
   public java.util.Collection<Pret> lesPrets;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pret> getLesPrets() {
      if (lesPrets == null)
         lesPrets = new java.util.ArrayList<Pret>();
      return lesPrets;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesPrets() {
      if (lesPrets == null)
         lesPrets = new java.util.ArrayList<Pret>();
      return lesPrets.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesPrets */
   public void setLesPrets(java.util.Collection<Pret> newLesPrets) {
      removeAllLesPrets();
      for (java.util.Iterator iter = newLesPrets.iterator(); iter.hasNext();)
         addLesPrets((Pret)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPret */
   public void addLesPrets(Pret newPret) {
      if (newPret == null)
         return;
      if (this.lesPrets == null)
         this.lesPrets = new java.util.ArrayList<Pret>();
      if (!this.lesPrets.contains(newPret))
      {
         this.lesPrets.add(newPret);
         newPret.setUtilisateur(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPret */
   public void removeLesPrets(Pret oldPret) {
      if (oldPret == null)
         return;
      if (this.lesPrets != null)
         if (this.lesPrets.contains(oldPret))
         {
            this.lesPrets.remove(oldPret);
            oldPret.setUtilisateur((Utilisateur)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesPrets() {
      if (lesPrets != null)
      {
         Pret oldPret;
         for (java.util.Iterator iter = getIteratorLesPrets(); iter.hasNext();)
         {
            oldPret = (Pret)iter.next();
            iter.remove();
            oldPret.setUtilisateur((Utilisateur)null);
         }
      }
   }

}