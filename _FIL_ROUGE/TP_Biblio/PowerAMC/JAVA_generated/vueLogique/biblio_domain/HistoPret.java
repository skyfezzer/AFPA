/***********************************************************************
 * Module:  HistoPret.java
 * Author:  Sk
 * Purpose: Defines the Class HistoPret
 ***********************************************************************/

package vueLogique.biblio_domain;

import java.util.*;

/** Cette classe conceptualise la fin d'un prêt
 * 
 * @pdOid 16fa42b8-493b-4dbf-b513-a07e5790e95e */
public class HistoPret {
   /** @pdOid 23b91942-e30a-465d-9abf-47703266adc0 */
   private Integer noHisto;
   /** @pdOid daf3eb3f-3176-49d2-b159-b6261b32f723 */
   private Date dateRemise;
   
   /** Un historique stocke un et un seul prêt
    * Un prêt peut être stocké ou non par un historique. */
   /** @pdRoleInfo migr=no name=Pret assc=stocker mult=1..1 side=A */
   public Pret pret;

}