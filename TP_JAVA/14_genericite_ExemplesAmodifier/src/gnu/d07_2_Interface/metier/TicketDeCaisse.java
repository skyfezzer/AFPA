
package gnu.d07_2_Interface.metier;

import java.util.ArrayList;

/**
 * Classe memorisant un ensemble de commandes a payer.
 */
public class TicketDeCaisse {
	private ArrayList<Payable> lignes = new ArrayList<Payable>();//association

	/**
	 * Ajoute une ligne de commande a ce ticket.
	 */
	public void ajouterLigne(Payable ligne) {
		this.lignes.add(ligne);
	}

	/**
	 * Renvoie la somme des prix des commandes ajoutees a ce ticket.
	 */
	public float getPrixTotal() {
		float prix = 0;
		for (int i = 0; i < lignes.size(); i++) {
			Payable ligne = (Payable) this.lignes.get(i);
			prix += ligne.getPrix();
		}
		return prix;
	}
}
