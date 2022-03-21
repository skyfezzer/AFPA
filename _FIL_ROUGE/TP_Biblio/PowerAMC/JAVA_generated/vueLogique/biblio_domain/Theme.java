/***********************************************************************
 * Module:  Theme.java
 * Author:  Sk
 * Purpose: Defines the Class Theme
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid 880a7a76-e034-4bc3-93b2-47ec73ee7d19 */
public class Theme {
   /** @pdOid 8c519983-fabb-404e-86db-fd30c2671c7f */
   private String noTheme;
   /** @pdOid d2006ee4-8b7e-4e3d-8bfc-c51b11ecce66 */
   private String intituleTheme;
   
   /** Un emplacement est attribué pour un Thème.
    * Un thème peut être attribué à 0 ou plusieurs emplacements. */
   /** @pdRoleInfo migr=no name=Emplacement assc=trier coll=java.util.Collection impl=java.util.ArrayList mult=0..* side=A */
   public java.util.Collection<Emplacement> lesEmplacements;
   
   
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
         newEmplacement.setTheme(this);      
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
            oldEmplacement.setTheme((Theme)null);
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
            oldEmplacement.setTheme((Theme)null);
         }
      }
   }

}