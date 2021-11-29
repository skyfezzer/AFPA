package fr.aragot.main;

public class Item3 {

	public static void main(String[] args) {
		long ssn = 2550675113052L;
		int key = 79;
		System.out.println("2550675113052 - clé 79");
		System.out.println(isSSkeyValid(ssn, key)?"clé OK":"clé NOK");

	}

	public static boolean isSSkeyValid(long socialSecurityNumber,int key) {
		if(97 - (socialSecurityNumber%97) == key)
			return true;
		return false;
	}
}
