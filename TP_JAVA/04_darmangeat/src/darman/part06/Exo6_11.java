package darman.part06;

public class Exo6_11 {

	public static void main(String[] args) {
		int[] tab1 = {4,8,7,12};
		int[] tab2 = {3,6};
		System.out.println(schtroumpf(tab1, tab2));
	}
	
	private static int schtroumpf(int[] tab, int[] tab2) {
		int result = 0;
		for(int i = 0;i <tab.length;i++) {
			for(int j=0;j<tab2.length;j++) {
				result += tab[i]*tab2[j];
			}
		}
		return result;
	}

}
