package fr.aragot.bookstore.test;


import java.util.Arrays;
import java.util.Comparator;

import fr.aragot.bookstore.domain.Comptable;
import fr.aragot.bookstore.domain.Livre;

public class TestLivre {

	public static void main(String[] args) {
    	Livre livre1 = new Livre("Harry Potter","J.K. Rowling",100,19.99);
        Livre livre2 = new Livre("Astérix","Goscinny","Uderzo",150,15.00);
        Livre livre3 = new Livre("La fille de brooklyn","Musso",200,20.00);
        Livre livre4 = new Livre("Le labyrinthe","Dashner",250,20.00);
        System.out.println("nbPages de livre1 : " + livre1.getNbPages());
        System.out.println("nbPages de livre2 : " + livre2.getNbPages());
        System.out.println("nbPages cumulés : " + (livre1.getNbPages() + livre2.getNbPages()));
        System.out.println("Auteur du livre1 : " + livre1.getAuteur());
        System.out.println("Auteur du livre2 : " + livre2.getAuteur());
        // Prints an Object and then terminate the line. 
        // This method calls at first String.valueOf(x) to get the printed object's string value, 
        // then behaves as though it invokes print(String) and then println().
        // valueOf : if the argument is null, then a string equal to "null"; otherwise, the value of obj.toString() is returned.
        System.out.println(livre1);
        System.out.println("Diff : " + livre1.compare(livre2));
        System.out.println("Prix total : " + Comptable.getInstance().getTotalPrix());
        System.out.println("Hascode l1 : " + livre1.hashCode());
        System.out.println("Hascode l2 : " + livre2.hashCode());
        Livre[] livres = new Livre[4];
        livres[0] = livre1;
        livres[1] = livre4;
        livres[2] = livre3;
        livres[3] = livre2;
        System.out.println("=== Avant sort");
        System.out.println(Arrays.toString(livres));
        Arrays.sort(livres);
        System.out.println("=== Apres sort normal");
        System.out.println(Arrays.toString(livres));
        Arrays.sort(livres,Comparator.reverseOrder());
        System.out.println("=== Apres sort descendant");
        System.out.println(Arrays.toString(livres));
    }
	
}
