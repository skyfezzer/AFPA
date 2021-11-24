package darman.part05;

import java.util.Scanner;

public class Exo5_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vars = new int[20];
		int i = 0, max = 0, iMax = 0;
		boolean firstLoop = true;
		while(i<vars.length) {
			System.out.printf("Entrez le nombre %d/%d : ",i+1,vars.length);
			try{
				vars[i] = Integer.parseInt(sc.nextLine());
				if(firstLoop) {
					firstLoop = false;
					max = vars[i];
					iMax = i+1;
				}else {
					if(vars[i] > max) {
						max = vars[i];
						iMax = i+1;
					}
				}
				i++;
				continue;
			}catch(Exception e) {
				System.out.println("Merci de r�essayer");
			}
		};
		
		System.out.printf("\nLa plus grand valeur entr�e est '%d', %de valeur entr�e",max,iMax);
		sc.close();

	}

}
