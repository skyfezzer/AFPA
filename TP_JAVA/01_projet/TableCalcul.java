import java.util.Scanner;
public class TableCalcul{
	public static void main(String[] args){
		// --- Variables
		Scanner sc = new Scanner(System.in);
		int nbMax = 0;


		// --- Procedure
		do{
			System.out.println("Entrez l'entier maximum (minimum 1) dont on calculera pow2 et sqrt :");
			
			try{
				nbMax = Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				System.out.println("Merci d'entrer un entier valide.");
			}
		}while(nbMax < 1);
		sc.close();
		System.out.println("Nombre\tCarre\tRacine carree");
		for(int i =0;i<=nbMax;i++){
			System.out.println(i + "\t"
				+ Math.pow(i,2) + "\t" 
				+ Math.sqrt(i));
		}
	}
}