package darman.part8;

public class Exo8_05 {
	public static void main(String[] args) {
		int[][] x = new int[4][2];
		int k,m;
		for(k=0;k<=3;k++) {
			for(m=0;m<=1;m++) {
				//x[k][m] = 2*k+(m+1);
				x[k][m] = (k+1)+4*m;
			}
		}
		
		for(k=0;k<=3;k++)
			for(m=0;m<=1;m++)
				System.out.println(x[k][m]);
	}
}
