package darman.part06;

public class Exo6_09 {

	public static void main(String[] args) {
		int[] myTab = {1,2,3,0};
		
		System.out.println(sommeTableau(myTab));
	}
	
	private static int sommeTableau(int[] tab) {
		int result = 0;
		for(int i = 0;i<tab.length;i++) {
			result += tab[i];
		}
		return result;
	}

}
