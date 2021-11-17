package darman.part6;

public class Exo6_06 {
	public static void main(String[] args) {
		int[] suite = new int[8];
		suite[0] = 1;
		System.out.println(suite[0]);
		suite[1] = 1;
		System.out.println(suite[1]);
		for(int i = 2; i < 8; i++) {
			suite[i] = suite[i-1] + suite[i-2];
			System.out.println(suite[i]);
		}
	}
}
