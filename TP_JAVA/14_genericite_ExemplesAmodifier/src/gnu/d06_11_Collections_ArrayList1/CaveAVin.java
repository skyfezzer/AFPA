
package gnu.d06_11_Collections_ArrayList1;

//import gnu.d05_Reutilisation_Classes.metier.Boisson;
//import gnu.d05_Reutilisation_Classes.metier.BoissonAlcoolisee;
import gnu.d07_2_Interface.metier.Boisson;
import gnu.d07_2_Interface.metier.BoissonAlcoolisee;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

class CaveAVin {
	public static void main(String[] args) {
		// Creation d'instances de boisson
		Boisson soda = new Boisson("Soif !", 2);
		Boisson bordeaux = new BoissonAlcoolisee("Bordeaux", 4.5f, 12);

		// Creation d'un ensemble illimite
		//ArrayList<Boisson> caveAVin = new ArrayList<>();
		List<Boisson> caveAVin = new ArrayList<>();

		// Ajout des boissons dans la cave a vin
		caveAVin.add(soda);
		caveAVin.add(soda);
		// La 3eme et la 4eme places sont vides
		caveAVin.add(null);
		caveAVin.add(null);

		// Ajout de 4 bouteilles de Bordeaux
		for (int i = 4; i <= 7; i++)
			caveAVin.add(bordeaux);

		// Affectation de la 4eme place
		caveAVin.set(3, new Boisson("Limonade", 2));
		
		// Calcul et affichage du prix du casier
		// et du nombre de places laissees vide
		float prix = 0;
		int placesVides = 0;
		//for (int i = 0; i < caveAVin.size(); i++) {
		for(Boisson boisson : caveAVin) {
			// L'ensemble peut contenir n'importe
			// quel objet => Conversion de la
			// reference en classe Boisson
			//Boisson boisson = caveAVin.get(i);
			if (boisson != null)
				prix += boisson.getPrix();
			else
				placesVides++;
		}
		JOptionPane.showMessageDialog(null, "Valeur de la cave : " + prix
				+ " \u20AC" + "\n" + placesVides + " place vide");
		System.exit(0);
	}
}
