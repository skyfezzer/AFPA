package darman.part04;

import java.util.Scanner;

public class Exo4_07 {

	public static void main(String[] args) {
		int age, annPermis, nbAccidents, annFid;
		String result = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Entrez l'age: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println( "Entrez le nombre d'années de permis: ");
		annPermis = sc.nextInt();
		sc.nextLine();
		System.out.println( "Entrez le nombre d'accidents: ");
		nbAccidents = sc.nextInt();
		sc.nextLine();
		System.out.println( "Entrez le nombre d'années d'assurance: ");
		annFid = sc.nextInt();
		sc.close();
		
		if((age<25 && annPermis < 2 && nbAccidents == 0)
			|| (age >= 25 && annPermis < 2 && nbAccidents == 1)
			|| (age >= 25 && annPermis >= 2 && nbAccidents == 2)) {
			result = annFid<5?"ROUGE":"ORANGE";
		}else if((nbAccidents == 0) && ((age < 25 && annPermis >= 2)||(age >= 25 && annPermis < 2))
			|| (age >= 25 && annPermis >= 2 && nbAccidents == 1)) {
			result = annFid<5?"ORANGE":"VERT";
		}else if(age >= 25 && annPermis >= 2 && nbAccidents == 0) {
			result = annFid<5?"VERT":"BLEU";
		}else {
			result = "REFUSÉ";
		}

		System.out.printf("L'assurance vous propose un contrat %s",result);
	}

}
