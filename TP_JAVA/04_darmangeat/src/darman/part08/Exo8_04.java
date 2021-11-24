package darman.part08;

public class Exo8_04 {
	public static void main(String[] args) {
		int[][] x = new int[4][2];
		int k,m;
		for(k=0;k<=3;k++) {
			for(m=0;m<=1;m++) {
				x[k][m] = k+m;
			}
		}
		
		for(k=0;k<=3;k++)
			for(m=0;m<=1;m++)
				System.out.println(x[k][m]);
	}

}
