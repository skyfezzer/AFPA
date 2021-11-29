package fr.aragot.main;

public class Item2 {

	public static void main(String[] args) {
		tracerLigne(10, 'o',true);
		
	}
	
	public static void tracerLigne() {
		tracerLigne(20);
	}
	public static void tracerLigne(int nbChars) {
		tracerLigne(nbChars,'-');
	}
	public static void tracerLigne(int nbChars, char usedChar) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < nbChars;i++) {
			sb.append(usedChar);
		}
		System.out.println(sb.toString());
	}
	public static void tracerLigne(int nbChars, char usedChar, boolean recursif) {
		tracerLigne(nbChars,usedChar,true,1);
	}

	private static void tracerLigne(int nbChars, char usedChar, boolean recursif, int index) {
		if(index < nbChars)
			tracerLigne(nbChars,usedChar,true,++index);
		System.out.print(usedChar);
	}

}
