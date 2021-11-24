package darman.part07;

import java.util.Arrays;

public class Exo7_06 {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9,11,12,41,101};
		int[] arr2 = {0,2,4,6,8,10,15,17,22,47,51,58};
		int[] newArr = fusionTableaux(arr1, arr2);
		System.out.println(Arrays.toString(newArr));
	}
	
	private static int[] fusionTableaux(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length+arr2.length];
		boolean arr1Fini = false, arr2Fini = false;
		for(int i = 0, j = 0,k=0;k<=result.length-1;k++) {
			
			if( !arr2Fini && ( arr1Fini || arr2[j] < arr1[i] )) {
				result[k] = arr2[j++];
				arr2Fini = j > arr2.length -1;
			}else {
				result[k] = arr1[i++];
				arr1Fini = i > arr1.length -1;
			}
		}
		
		return result;
	}

}
