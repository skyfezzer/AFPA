package darman.part7;

import java.util.Arrays;

public class Exo7_03 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3};
		for(int i = 0; i < (arr.length)/2;i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-i-1] = temp;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
