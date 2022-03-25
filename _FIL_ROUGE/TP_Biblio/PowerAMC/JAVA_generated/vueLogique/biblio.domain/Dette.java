/***********************************************************************
 * Module:  Dette.java
 * Author:  Sk
 * Purpose: Defines the Class Dette
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** Cette classe conceptualise les dettes (amendes).
 * 
 * @pdOid 20c495dd-bd0a-4c19-8df1-aee2f887e477 */
public class Dette {
   /** @pdOid 3fa8c685-95f8-4fe9-af87-925d19ee9ec9 */
   private Integer noDette;
   /** @pdOid 002ab04a-a251-4783-871d-e254921ea7ca */
   private Float montantDette;
   /** @pdOid 1250fc9a-07d6-4dd1-9192-4b0c3a8b968d */
   private String motifDette;
   /** @pdOid 4f846ab6-6666-455d-99c2-364a3fb3fc0e */
   private Date dateDette;
   
   /** Une amende est payé en 0 à plusieurs paiements.
    * Un paiement paie une et une seule amende. */
   /** @pdRoleInfo migr=no name=Paiement assc=payer coll=java.util.Collection impl=java.util.ArrayList mult=0..* side=A */
   public java.util.Collection<Paiement> lesPaiements;
   /** Un adhérent peut être puni de 0 à plusieurs amendes.
    * Une amende puni un et un seul utilisateur. */
   /** @pdRoleInfo migr=no name=Adherent assc=punir mult=1..1 side=A */
   public Adherent adherent;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Paiement> getLesPaiements() {
      if (lesPaiements == null)
         lesPaiements = new java.util.ArrayList<Paiement>();
      return lesPaiements;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesPaiements() {
      if (lesPaiements == null)
         lesPaiements = new java.util.ArrayList<Paiement>();
      return lesPaiements.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesPaiements */
   public void setLesPaiements(java.util.Collection<Paiement> newLesPaiements) {
      removeAllLesPaiements();
      for (java.util.Iterator iter = newLesPaiements.iterator(); iter.hasNext();)
         addLesPaiements((Paiement)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPaiement */
   public void addLesPaiements(Paiement newPaiement) {
      if (newPaiement == null)
         return;
      if (this.lesPaiements == null)
         this.lesPaiements = new java.util.ArrayList<Paiement>();
      if (!this.lesPaiements.contains(newPaiement))
      {
         this.lesPaiements.add(newPaiement);
         newPaiement.setDette(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPaiement */
   public void removeLesPaiements(Paiement oldPaiement) {
      if (oldPaiement == null)
         return;
      if (this.lesPaiements != null)
         if (this.lesPaiements.contains(oldPaiement))
         {
            this.lesPaiements.remove(oldPaiement);
            oldPaiement.setDette((Dette)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesPaiements() {
      if (lesPaiements != null)
      {
         Paiement oldPaiement;
         for (java.util.Iterator iter = getIteratorLesPaiements(); iter.hasNext();)
         {
            oldPaiement = (Paiement)iter.next();
            iter.remove();
            oldPaiement.setDette((Dette)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Adherent getAdherent() {
      return adherent;
   }
   
   /** @pdGenerated default parent setter
     * @param newAdherent */
   public void setAdherent(Adherent newAdherent) {
      if (this.adherent == null || !this.adherent.equals(newAdherent))
      {
         if (this.adherent != null)
         {
            Adherent oldAdherent = this.adherent;
            this.adherent = null;
            oldAdherent.removeLesDettes(this);
         }
         if (newAdherent != null)
         {
            this.adherent = newAdherent;
            this.adherent.addLesDettes(this);
         }
      }
   }

}