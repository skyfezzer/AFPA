
package gnu.d06_12_Collections_ArrayList2;


import java.util.List;
import javax.swing.JOptionPane;


class GrilleLoto
{
  public static void main (String[] args)
  {
    List tirageLoto = Loto.creerTirage ();
    // Construction d'un tableau HTML (balise <table>) affichant une grille de loto
    String grilleLoto = "<html><table border='1'>";
    for (int ligne = 0; ligne < 10; ligne++)
    {
      // Ajout d'une ligne au tableau HTML (balise <tr>)
      grilleLoto += "<tr>";
      for (int colonne = 0; colonne < 5; colonne++)
      {
        int boule = ligne + (colonne * 10);
        // Ajout d'une cellule a la ligne (balise <td>)
        grilleLoto += "<td><font size='+2'>";
        if (boule > 0)
          // Appel de la methode contains declaree dans l'interface java.util.List
          // et implementee par la classe de l'objet designe par tirageLoto
          if (tirageLoto.contains (new Integer (boule)))
            grilleLoto += "<b>" + boule + "</b>";
          else
            grilleLoto += "<font color='gray'>" + boule + "</font>";
        grilleLoto += "</font></td>";
      }
      grilleLoto += "</tr>";
    }
    grilleLoto += "</table></html>";
    // Affichage du tableau HTML dans une boite de dialogue de titre Loto et sans icone
    JOptionPane.showMessageDialog (null, grilleLoto, "Loto", JOptionPane.PLAIN_MESSAGE);
    System.exit (0);
  }
}
