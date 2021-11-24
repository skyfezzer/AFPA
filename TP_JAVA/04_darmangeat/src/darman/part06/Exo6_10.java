package darman.part06;

public class Exo6_10 {

	public static void main(String[] args) {
		int[] tab1 = {10,20,40,80};
		int[] tab2 = {1,1,1,1};
		int[] sommeTab = sommeElementsEntre(tab1, tab2);
		for(int i = 0;i<sommeTab.length;i++) {
			System.out.println(sommeTab[i]);
		}

	}
	
	private static int[] sommeElementsEntre(int[] tab, int[] tab2) {
		if(tab.length != tab2.length) {
			System.err.println("sommeElementsEntre(tab,tab) ne fonctionne qu'avez deux tableaux de la même taille.");
			return null;
		}
		
		int result[] = new int[tab.length];
		for(int i = 0;i<tab.length;i++) {
			result[i] = tab[i] + tab2[i];
		}
		
		
		return result;
	}

}
