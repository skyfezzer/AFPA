/***********************************************************************
 * Module:  Livre.java
 * Author:  Sk
 * Purpose: Defines the Class Livre
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** @pdOid 3dc881a9-d352-4459-8918-2ee46d90f92a */
public class Livre {
   /** @pdOid 1686e6e2-9085-4c8c-b0d5-f917a7d67835 */
   private Integer iSBNLivre;
   /** @pdOid e1246a4b-5252-443e-a629-05a7725ea6b4 */
   private String titreLivre;
   
   /** Un livre est matérialisé par 0 à plusieurs exemplaires.
    * Un exemplaire matérialise un livre. */
   /** @pdRoleInfo migr=no name=Exemplaire assc=materialiser coll=java.util.Collection impl=java.util.ArrayList mult=1..* side=A */
   public java.util.Collection<Exemplaire> lesExemplaires;
   /** Un livre est écrit par un auteur.
    * Un auteur peut écrire 0 ou plusieurs livres. */
   /** @pdRoleInfo migr=no name=Auteur assc=ecrire mult=1..1 side=A */
   public Auteur auteur;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Exemplaire> getLesExemplaires() {
      if (lesExemplaires == null)
         lesExemplaires = new java.util.ArrayList<Exemplaire>();
      return lesExemplaires;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesExemplaires() {
      if (lesExemplaires == null)
         lesExemplaires = new java.util.ArrayList<Exemplaire>();
      return lesExemplaires.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesExemplaires */
   public void setLesExemplaires(java.util.Collection<Exemplaire> newLesExemplaires) {
      removeAllLesExemplaires();
      for (java.util.Iterator iter = newLesExemplaires.iterator(); iter.hasNext();)
         addLesExemplaires((Exemplaire)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExemplaire */
   public void addLesExemplaires(Exemplaire newExemplaire) {
      if (newExemplaire == null)
         return;
      if (this.lesExemplaires == null)
         this.lesExemplaires = new java.util.ArrayList<Exemplaire>();
      if (!this.lesExemplaires.contains(newExemplaire))
      {
         this.lesExemplaires.add(newExemplaire);
         newExemplaire.setLivre(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldExemplaire */
   public void removeLesExemplaires(Exemplaire oldExemplaire) {
      if (oldExemplaire == null)
         return;
      if (this.lesExemplaires != null)
         if (this.lesExemplaires.contains(oldExemplaire))
         {
            this.lesExemplaires.remove(oldExemplaire);
            oldExemplaire.setLivre((Livre)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesExemplaires() {
      if (lesExemplaires != null)
      {
         Exemplaire oldExemplaire;
         for (java.util.Iterator iter = getIteratorLesExemplaires(); iter.hasNext();)
         {
            oldExemplaire = (Exemplaire)iter.next();
            iter.remove();
            oldExemplaire.setLivre((Livre)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Auteur getAuteur() {
      return auteur;
   }
   
   /** @pdGenerated default parent setter
     * @param newAuteur */
   public void setAuteur(Auteur newAuteur) {
      if (this.auteur == null || !this.auteur.equals(newAuteur))
      {
         if (this.auteur != null)
         {
            Auteur oldAuteur = this.auteur;
            this.auteur = null;
            oldAuteur.removeRealisations(this);
         }
         if (newAuteur != null)
         {
            this.auteur = newAuteur;
            this.auteur.addRealisations(this);
         }
      }
   }

}