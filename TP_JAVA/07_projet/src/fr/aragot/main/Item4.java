package fr.aragot.main;

public class Item4 {

	public static void main(String[] args) {
		int var1;
		float var2;
		double var3;
		short var4;
		long var5;
		byte var6;
		char var7;
		
		double base = 456789.7890123456789;
		
		var1 = (int) base;
		System.out.println("int var = "+var1);
		
		var2 = (float)base;
		System.out.println("float var = "+var2);
		
		var3 = (double)base;
		System.out.println("double var = "+var3);
		
		var4 = (short)base;
		System.out.println("short var = "+var4);
		
		var5 = (long)base;
		System.out.println("long var = "+var5);
		
		var6 = (byte)base;
		System.out.println("byte var = "+var6);
		
		var7 = (char)base;
		System.out.println("char var = "+var7);
	}

}

