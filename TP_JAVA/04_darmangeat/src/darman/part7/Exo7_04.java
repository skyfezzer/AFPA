package darman.part7;

import java.util.Arrays;

public class Exo7_04 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3};
		
		arr = removeIndexFromArray(arr, 1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static int[] removeIndexFromArray(int[] arr,int parami) {
		int newArr[] = new int[arr.length-1];
		for(int i = 0,j = 0;i<arr.length;i++,j++) {
			if(i==parami) {
				j--;
				continue;
			}
			newArr[j] = arr[i];
		}
		return newArr;
	}

}
