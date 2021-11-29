package fr.aragot.main;

public class Item1 {

	public static void main(String[] args) {
		System.out.println("10 Euros = " + FinanceTools.fromEuroToPound(10) + "£");
		System.out.println("60 Francs = " + FinanceTools.fromFrancToPound(60) + "£");
		System.out.println(FinanceTools.arrondi(10.1239, 3));
		System.out.println(FinanceTools.troncature(10.1239, 3));

	}
	
	static class FinanceTools {
		private static final double EURO_TO_POUND_RATE = 0.846;
		private static final double FRANC_TO_EURO_RATE = 6.55957;
		
		//		CONVERSIONS
		/**
		 * Convertit une somme en Euro vers une somme en Livres Sterling
		 * @param euros	Somme en Euros
		 * @return		La somme en Livres Sterling
		 */
		public static double fromEuroToPound(double euros) {
			return euros/EURO_TO_POUND_RATE;
		}
		/**
		 * Convertit une somme en Livres Sterling vers une somme en Euro
		 * @param pounds	Somme en Livres Sterling
		 * @return		La somme en Euros
		 */
		public static double fromPoundToEuro(double pounds) {
			return pounds*EURO_TO_POUND_RATE;
		}
		
		/**
		 * Convertit une somme en Euros vers une somme en Livres Sterling
		 * @param francs	Somme en Francs
		 * @return		La somme en Livres Sterling
		 */
		public static double fromFrancToPound(double francs) {
			return fromEuroToPound(fromFrancToEuro(francs));
		}
		/**
		 * Convertit une somme en Livres Sterling vers une somme en Francs FRF
		 * @param pounds	Somme en Livres Sterling
		 * @return		La somme en Francs FRF
		 */
		public static double fromPoundToFranc(double pounds) {
			return fromEuroToFranc(fromPoundToEuro(pounds));
		}
		/**
		 * Convertit une somme en Euros vers une somme en Francs FRF
		 * @param euros	Somme en Euros
		 * @return		La somme en Francs FRF
		 */
		public static double fromEuroToFranc(double euros) {
			return euros*FRANC_TO_EURO_RATE;
		}
		/**
		 * Convertit une somme en Francs FRF vers une somme en Euros
		 * @param francs	Somme en Francs FRF
		 * @return		La somme en Euros
		 */
		public static double fromFrancToEuro(double francs) {
			return francs/FRANC_TO_EURO_RATE;
		}
		
		//		TOOLS
		public static double arrondi(double value, int virguleIndex){
			return Math.round(value*Math.pow(10, virguleIndex))/Math.pow(10, virguleIndex);
		}
		
		public static double troncature(double value, int index) {
			return Math.floor(value*Math.pow(10, index))/Math.pow(10, index);
		}
		
	}

}
