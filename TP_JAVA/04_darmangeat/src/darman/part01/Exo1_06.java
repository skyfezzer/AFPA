package darman.part01;

public class Exo1_06 {

	public static void main(String[] args) {
		Object a,b,temp;
		a=10;
		b=5;
		System.out.printf("avant le swap : a=%d, b=%d",a,b);
		temp=a;
		a=b;
		b=temp;
		System.out.printf(" // apres le swap : a=%d, b=%d",a,b);
	}
	
	
	

}
