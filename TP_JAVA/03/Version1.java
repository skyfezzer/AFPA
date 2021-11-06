import java.util.Scanner;
import java.util.Arrays;
public class Version1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nom, prenom, adresse, fnte;
        char rep;
        do{
            // INPUTS
            System.out.print("Nom du cavalier\t: ");
            nom = sc.nextLine();

            System.out.print("Prénom du cavalier\t: ");
            prenom = sc.nextLine();

            System.out.print("Adresse du cavalier\t: ");
            adresse = sc.nextLine();

            System.out.print("Numero de carte FNTE\t: ");
            fnte = sc.nextLine();

            System.out.print("Vos 3 chevaux preferes (entrer 1 par 1)\t: ");
            String[] chevauxPref = {sc.nextLine(),sc.nextLine(),sc.nextLine()};

            // PRESENTATION 1
            System.out.printf("\n\nNom du cavalier \t: %s\n",nom);
            System.out.printf("Prenom du cavalier \t: %s\n",prenom);
            System.out.printf("Adresse du cavalier \t: %s\n",adresse);
            System.out.printf("Chevaux preferes \t: %s\n",chevauxPref[0]);
            System.out.printf("\t\t\t: %s\n",chevauxPref[1]);
            System.out.printf("\t\t\t: %s\n",chevauxPref[2]);
            System.out.printf("No carte FNTE \t: %s\n",fnte);

            // PRESENTATION 2
            System.out.println("\n\n");
            System.out.println("Cavalier no "+ fnte);
            System.out.println("\t" + nom + " " + prenom);
            System.out.println("\t"+adresse);
            System.out.println("Chevaux ; " + Arrays.toString(chevauxPref));

            // MESSAGE DE FIN
            do{
            System.out.print("Voulez-vous continuer (O/N) ?");
            try{
                rep = sc.nextLine().toLowerCase().charAt(0);
            }catch(Exception e){
                rep = ' ';
                continue;
            }
            }while(!(rep == 'o' || rep == 'n'));
        }while(rep == 'o');

        sc.close();
    }
}
