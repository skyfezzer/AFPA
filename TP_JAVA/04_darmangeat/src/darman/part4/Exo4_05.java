package darman.part4;

import java.util.Scanner;

public class Exo4_05 {

	private static Scanner sc;
	public static void main(String[] args) {
		int age;
		boolean isHomme, paieImpots = false;
		sc = new Scanner(System.in);
		System.out.print("Entrez votre age : ");
		age = sc.nextInt();
		sc.nextLine();
		isHomme = demanderSexe() == 'h';
		
		if(isHomme && age >= 20) {
			paieImpots = true;
		}else if(!isHomme && age >= 18 && age <= 35){
			paieImpots = true;
		}
		
		System.out.printf("L%s de %d ans %s imposable.",(isHomme?"'homme":"a femme"),age,(paieImpots?"est":"n'est pas"));
		
		
		sc.close();
		
	}
	
	private static char demanderSexe() {
		char rep;
		do{
			System.out.print("Entrez votre sexe (H pour Homme, F pour Femme attendu) : ");
			try{
				rep = sc.nextLine().toLowerCase().charAt(0);
			}catch(Exception e){
				rep = ' ';
				continue;
			}
		}while(!(rep == 'h' || rep == 'f'));
		return rep;
	}

}
