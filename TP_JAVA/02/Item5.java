public class Item5 {
    public static void main(String[] args) {
        System.out.println("Racine carree de 4: " + Math.sqrt(4));
        System.out.println("Cos de PI/2: " + Math.cos(Math.PI / 2));
        System.out.println("Voici 5 entiers au hasard compris entre 1 et 10 :");
        for(int i=0;i<5;i++)
            System.out.println(Math.round(Math.random()*9+1));
    }
}
