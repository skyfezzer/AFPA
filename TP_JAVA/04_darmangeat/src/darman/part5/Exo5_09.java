package darman.part5;

import java.util.Scanner;

public class Exo5_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int curVal = 0;
		int i = 0, max = 0, iMax = 0;
		boolean firstLoop = true;
		do {
			System.out.printf("Entrez le nombre numero %d : ",i+1);
			try{
				curVal = Integer.parseInt(sc.nextLine());
				if(firstLoop) {
					firstLoop = false;
					max = curVal;
					iMax = i+1;
				}else {
					if(curVal > max) {
						max = curVal;
						iMax = i+1;
					}
				}
				i++;
				continue;
			}catch(Exception e) {
				System.out.println("Merci de réessayer");
			}
		}while(curVal != 0);
		
		System.out.printf("\nLa plus grand valeur entrée est '%d', %de valeur entrée",max,iMax);
		sc.close();

	}

}
