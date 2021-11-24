package darman.part07;

import java.util.Arrays;

public class Exo7_05 {

	public static void main(String[] args) {
		String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Arrays.sort(arr);
		System.out.println(trouve(arr,"a"));
		

	}
	
	private static boolean trouve(String[] arr, String sToFind) {
		return trouve(arr,0,arr.length,sToFind);
	}
	private static boolean trouve(String[] arr, int min, int max, String sToFind) {
		if(min>=max){
			return false;
		}
		int milieu = (min+max)/2;
		/*
		 * System.out.printf("\nSEARCHING BETWEEN %d and %d",min,max);
		 * System.out.printf("\n\tmilieu=%d, arr[milieu]=\"%s\", 
		 * 		arr[milieu].compareTo(sToFind)=%d",
		 * 		milieu,arr[milieu],
		 * 		arr[milieu].compareTo(sToFind));
		 *
		*/
		int myVal = sToFind.compareTo(arr[milieu]);
		if(myVal == 0) {
			return true;
		}else if(myVal < 0) {
			if(milieu==max) {
				return false;
			}
			return trouve(arr,min,milieu,sToFind);
		}else {
			if(milieu==min){
				return false;
			}
			return trouve(arr,milieu,max,sToFind);
		}
		
		
		
		
	}

}
