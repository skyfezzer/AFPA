/*
 * Fichier org/gnu/test/CasierBouteilles.java
 *
 */
package gnu.d06_10_Collections_tableau;

//import gnu.d05_Reutilisation_Classes.metier.Boisson;
//import gnu.d05_Reutilisation_Classes.metier.BoissonAlcoolisee;
import gnu.d07_2_Interface.metier.Boisson;
import gnu.d07_2_Interface.metier.BoissonAlcoolisee;

import javax.swing.JOptionPane;

class CasierBouteilles {
	public static void main(String[] args) {
		// Creation d'instances de boisson
		Boisson soda = new Boisson("Soif !", 2);
		Boisson bordeaux = new BoissonAlcoolisee("Bordeaux", 4.5f, 12);
		// Creation d'un casier de 9 boissons
		Boisson[] casier = new Boisson[9];
		// Affectation des boissons aux cases
		casier[0] = soda;
		casier[1] = soda;
		// La 3eme et la 4eme cases sont vides

		// Ajout de 4 bouteilles de Bordeaux
		for (int i = 4; i <= 7; i++)
			casier[i] = bordeaux;
		// Affectation de la 4eme place
		casier[3] = new Boisson("Limonade ", 2);
		// Calcul et affichage du prix du casier
		// et du nombre de cases libres
		float prix = 0;
		int casesLibres = 0;
		for (int i = 0; i < casier.length; i++) {
			// Le tableau ne peut contenir que des
			// references de classe Boisson
			// => Pas besoin de conversion
			Boisson boisson = casier[i];
			if (boisson != null)
				prix += boisson.getPrix();
			else
				casesLibres++;
		}
		JOptionPane.showMessageDialog(null, "Valeur du casier " + prix
				+ " \u20AC" + "\n" + casesLibres + " cases libres");
		System.exit(0);
	}
}
