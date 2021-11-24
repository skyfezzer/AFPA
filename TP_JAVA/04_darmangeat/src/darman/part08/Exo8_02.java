package darman.part08;

public class Exo8_02 {
	public static void main(String[] args) {
		int[][] x = new int[2][3];
		int i,j,val;
		val = 1;
		for(i=0;i<=1;i++) {
			for(j=0;j<=2;j++) {
				x[i][j] = val;
				val = val + 1;
			}
		}
		
		for(i=0;i<=1;i++)
			for(j=0;j<=2;j++)
				System.out.println(x[i][j]);
	}
}
