
package gnu.d06_12_Collections_ArrayList2;

import java.util.*;

public class Loto
{
  /**
   * Renvoie une liste de 6 nombres tires aleatoirement dans
   * un ensemble de nombres compris entre 1 et 49.
   */
  public static List creerTirage ()
  {
    // Creation d'une collection des 49 entiers de 1 a 49
    ArrayList boulesLoto = new ArrayList (49);
    for (int i = 1; i <= 49; i++)
      boulesLoto.add (new Integer (i));

    // Melange aleatoire de la collection boulesLoto
    // Conversion implicite d'une reference d'une classe vers l'interface qu'elle
    // implemente acceptee : la classe java.util.ArrayList implemente java.util.List
    Collections.shuffle (boulesLoto);
    // Extraction des 6 premiers entiers de la collection melangee :
    // subList renvoie une reference designant un objet dont la classe implemente
    // l'interface java.util.List
    return boulesLoto.subList(0, 6);
  }
}

