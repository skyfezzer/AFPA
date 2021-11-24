package darman.part01;

public class Exo1_07 {
	public static void main(String[] args) {
		Object a,b,c,temp;
		a="variableA";
		b=12;
		c='y';
		System.out.println("a="+a+", b="+b+", c="+c);
		temp=c;
		c=b;
		b=a;
		a=temp;
		System.out.println("a="+a+", b="+b+", c="+c);
	}
}
