package darman.part08;

import java.util.Arrays;

public class Exo8_01 {

	public static void main(String[] args) {
		int[][] arr = new int[6][13];
		for(int i = 0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = 0;
			}
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
