package fr.aragot.exo9;

public class Item3 {

	private static final String CHAINE = "MotDePasseSuperSecret";
	public static void main(String[] args) {
		String pwd = CesarEncrypt(CHAINE, 3);
		System.out.println(CHAINE);
		System.out.println(pwd);
		System.out.println(CesarDecrypt(pwd, 3));

	}
	
	private static String CesarEncrypt(String s, int offset) {
		StringBuilder sb = new StringBuilder();
		for(Character c : s.toCharArray()){
			sb.append((char)(c+offset));
		}
		return sb.toString();
	}
	
	private static String CesarDecrypt(String s, int offset) {
		return CesarEncrypt(s,-offset);
	}

}
