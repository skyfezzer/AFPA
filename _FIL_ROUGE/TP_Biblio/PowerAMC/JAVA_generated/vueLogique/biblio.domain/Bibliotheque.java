/***********************************************************************
 * Module:  Bibliotheque.java
 * Author:  Sk
 * Purpose: Defines the Class Bibliotheque
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid 08d0b88b-b332-4f4e-859a-9b0faff3c704 */
public class Bibliotheque {
   /** @pdOid a889c14e-04fb-4e34-8fb9-cb1fe1d516ba */
   private Integer noBibliotheque;
   /** @pdOid e0972d01-96f8-4ba3-9cba-4dd416b880fb */
   private String adresse;
   
   /** @pdRoleInfo migr=no name=Emplacement assc=localiser coll=java.util.Collection impl=java.util.ArrayList mult=0..* side=A */
   public java.util.Collection<Emplacement> lesEmplacements;
   /** @pdRoleInfo migr=no name=Employe assc=travailler coll=java.util.Collection impl=java.util.ArrayList mult=1..* side=A */
   public java.util.Collection<Employe> lesEmployes;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Emplacement> getLesEmplacements() {
      if (lesEmplacements == null)
         lesEmplacements = new java.util.ArrayList<Emplacement>();
      return lesEmplacements;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesEmplacements() {
      if (lesEmplacements == null)
         lesEmplacements = new java.util.ArrayList<Emplacement>();
      return lesEmplacements.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesEmplacements */
   public void setLesEmplacements(java.util.Collection<Emplacement> newLesEmplacements) {
      removeAllLesEmplacements();
      for (java.util.Iterator iter = newLesEmplacements.iterator(); iter.hasNext();)
         addLesEmplacements((Emplacement)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEmplacement */
   public void addLesEmplacements(Emplacement newEmplacement) {
      if (newEmplacement == null)
         return;
      if (this.lesEmplacements == null)
         this.lesEmplacements = new java.util.ArrayList<Emplacement>();
      if (!this.lesEmplacements.contains(newEmplacement))
      {
         this.lesEmplacements.add(newEmplacement);
         newEmplacement.setBibliotheque(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldEmplacement */
   public void removeLesEmplacements(Emplacement oldEmplacement) {
      if (oldEmplacement == null)
         return;
      if (this.lesEmplacements != null)
         if (this.lesEmplacements.contains(oldEmplacement))
         {
            this.lesEmplacements.remove(oldEmplacement);
            oldEmplacement.setBibliotheque((Bibliotheque)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesEmplacements() {
      if (lesEmplacements != null)
      {
         Emplacement oldEmplacement;
         for (java.util.Iterator iter = getIteratorLesEmplacements(); iter.hasNext();)
         {
            oldEmplacement = (Emplacement)iter.next();
            iter.remove();
            oldEmplacement.setBibliotheque((Bibliotheque)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Employe> getLesEmployes() {
      if (lesEmployes == null)
         lesEmployes = new java.util.ArrayList<Employe>();
      return lesEmployes;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesEmployes() {
      if (lesEmployes == null)
         lesEmployes = new java.util.ArrayList<Employe>();
      return lesEmployes.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesEmployes */
   public void setLesEmployes(java.util.Collection<Employe> newLesEmployes) {
      removeAllLesEmployes();
      for (java.util.Iterator iter = newLesEmployes.iterator(); iter.hasNext();)
         addLesEmployes((Employe)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEmploye */
   public void addLesEmployes(Employe newEmploye) {
      if (newEmploye == null)
         return;
      if (this.lesEmployes == null)
         this.lesEmployes = new java.util.ArrayList<Employe>();
      if (!this.lesEmployes.contains(newEmploye))
      {
         this.lesEmployes.add(newEmploye);
         newEmploye.setBiblio(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldEmploye */
   public void removeLesEmployes(Employe oldEmploye) {
      if (oldEmploye == null)
         return;
      if (this.lesEmployes != null)
         if (this.lesEmployes.contains(oldEmploye))
         {
            this.lesEmployes.remove(oldEmploye);
            oldEmploye.setBiblio((Bibliotheque)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesEmployes() {
      if (lesEmployes != null)
      {
         Employe oldEmploye;
         for (java.util.Iterator iter = getIteratorLesEmployes(); iter.hasNext();)
         {
            oldEmploye = (Employe)iter.next();
            iter.remove();
            oldEmploye.setBiblio((Bibliotheque)null);
         }
      }
   }

}