/***********************************************************************
 * Module:  Adherent.java
 * Author:  Sk
 * Purpose: Defines the Class Adherent
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid 8a8d7a07-c165-4871-a32c-3ed3a50450ff */
public class Adherent extends Utilisateur {
   /** @pdOid 79d98ff4-9d92-4033-8785-c4f1fe85cd52 */
   private String noTelAdherent;
   /** @pdOid d2bc03ae-6a2a-4a47-8197-305abdb0c3fb */
   private String pin;
   
   /** Un adhérent peut être puni de 0 à plusieurs amendes.
    * Une amende puni un et un seul utilisateur. */
   /** @pdRoleInfo migr=no name=Dette assc=punir coll=java.util.Collection impl=java.util.ArrayList mult=0..* */
   public java.util.Collection<Dette> lesDettes;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Dette> getLesDettes() {
      if (lesDettes == null)
         lesDettes = new java.util.ArrayList<Dette>();
      return lesDettes;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesDettes() {
      if (lesDettes == null)
         lesDettes = new java.util.ArrayList<Dette>();
      return lesDettes.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesDettes */
   public void setLesDettes(java.util.Collection<Dette> newLesDettes) {
      removeAllLesDettes();
      for (java.util.Iterator iter = newLesDettes.iterator(); iter.hasNext();)
         addLesDettes((Dette)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDette */
   public void addLesDettes(Dette newDette) {
      if (newDette == null)
         return;
      if (this.lesDettes == null)
         this.lesDettes = new java.util.ArrayList<Dette>();
      if (!this.lesDettes.contains(newDette))
      {
         this.lesDettes.add(newDette);
         newDette.setAdherent(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldDette */
   public void removeLesDettes(Dette oldDette) {
      if (oldDette == null)
         return;
      if (this.lesDettes != null)
         if (this.lesDettes.contains(oldDette))
         {
            this.lesDettes.remove(oldDette);
            oldDette.setAdherent((Adherent)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesDettes() {
      if (lesDettes != null)
      {
         Dette oldDette;
         for (java.util.Iterator iter = getIteratorLesDettes(); iter.hasNext();)
         {
            oldDette = (Dette)iter.next();
            iter.remove();
            oldDette.setAdherent((Adherent)null);
         }
      }
   }

}