package fr.afpa.util;

import java.math.BigInteger;

import javax.swing.JOptionPane;
import fr.afpa.math.Math;

public class CalculFactorBig {

	public static void main(String[] args) {
		BigInteger target;
		do {
			try {
				String messageBox = JOptionPane.showInputDialog("Entrez un nombre dont on calculera la factorielle :");
				if(null == messageBox) {
					break;
				}
				
				target = new BigInteger(messageBox);
				
				// Approche différente pour calculer la factorielle de larges nombres :
				// Approche de Gosper sur l'approximation de Stirling :
				double dResult = (target.doubleValue()*java.lang.Math.log10(target.doubleValue()))
						- (target.doubleValue()*java.lang.Math.log10(java.lang.Math.E))
						+ (java.lang.Math.log10(java.lang.Math.sqrt((2.*target.doubleValue()+1f/3)*java.lang.Math.PI)));
				BigInteger test = BigInteger.TEN.pow((int) java.lang.Math.round(dResult));
				System.out.println("test.length(): " + test.toString().length());
				//Chronometre
				long debut = System.currentTimeMillis();
				BigInteger result = Math.factorielleFor(target);
				long fin = System.currentTimeMillis();
				System.out.printf("Factorielle calculée en %d ms\n",fin-debut);
				
				// Récupération de la longueur du string, et vérification que le résultat 
				// Ne soit pas négatif
				String sResult = result.toString();
				if(result.compareTo(BigInteger.ZERO) < 0) {
					System.out.println("result negatif");
				}
				System.out.printf("\nLongueur de factorielle de %d : %d",target,sResult.length());
				JOptionPane.showMessageDialog(null, String.format("\nLongueur de factorielle de %d : %d",target,sResult.length()));
				
				//System.out.printf("\nFactorielle de %d via factorielle BigInteger : %d",target,result);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Une erreur est survenue : La saisie n'est pas un nombre correct.");;
			}catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Une erreur est survenue : Veuillez entrer un nombre inférieur à 21.");;
			}
		}while(true);
		

	}

}
