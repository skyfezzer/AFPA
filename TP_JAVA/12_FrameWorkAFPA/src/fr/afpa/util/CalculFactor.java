package fr.afpa.util;

import javax.swing.JOptionPane;

import fr.afpa.math.Math;

public class CalculFactor {

	public static void main(String[] args) {
		long target;
		do {
			try {
				String messageBox = JOptionPane.showInputDialog("Entrez un nombre dont on calculera la factorielle :");
				if(null == messageBox) {
					break;
				}
				target = Long.parseLong(messageBox);
				JOptionPane.showMessageDialog(null, String.format("\nFactorielle de %d via factorielleFor : %d",target,Math.factorielleFor(target)));
				JOptionPane.showMessageDialog(null, String.format("\nFactorielle de %d via factorRecursif : %d",target,Math.factorielle(target)));
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Une erreur est survenue : La saisie n'est pas un nombre correct.");;
			}catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Une erreur est survenue : Veuillez entrer un nombre inférieur à 21.");;
			}
		}while(true);
		

	}

}
