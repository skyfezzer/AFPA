package darman.part08;

import java.util.Arrays;

public class Exo8_06 {

	public static void main(String[] args) {
		int[][] arr = new int[12][8];
		int max, iMax, jMax;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = (int) (Math.random() * 100);
			}
		}
		iMax = 0;
		jMax = 0;
		max = arr[0][0];
		System.out.println(iMax + "," + jMax);
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {
				if(arr[i][j] > max) {
					iMax = i;
					jMax = j;
					max = arr[i][j];
				}
			}
		}
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.printf("Maximum = %d, trouvé en position %d,%d",max,iMax,jMax);

	}

}
