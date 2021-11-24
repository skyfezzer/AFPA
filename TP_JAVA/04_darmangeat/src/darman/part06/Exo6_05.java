package darman.part06;

public class Exo6_05 {

	public static void main(String[] args) {
		int n[] = new int[7];
		n[0] = 1;
		System.out.println(n[0]);
		for(int i = 1; i < 7; i++) {
			n[i] = n[i-1] + 2;
			System.out.println(n[i]);
		}

	}

}
