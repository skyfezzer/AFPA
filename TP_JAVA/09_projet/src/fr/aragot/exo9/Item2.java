package fr.aragot.exo9;

public class Item2 {

	private static final String CHAINE = "L'�l�ve";
	
	public static void main(String[] args) {
		for(char c : CHAINE.toCharArray()) {
			System.out.printf("\\u%04x ",(int)c);
		}

	}

}
