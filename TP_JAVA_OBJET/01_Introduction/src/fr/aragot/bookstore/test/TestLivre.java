package fr.aragot.bookstore.test;


import fr.aragot.bookstore.domain.Livre;

public class TestLivre {

	public static void main(String[] args) {
		System.out.println(java.lang.ClassLoader.getSystemClassLoader().getResource("test.txt"));
		
    	Livre livre1 = new Livre("Harry Potter","J.K. Rowling",2);
        Livre livre2 = new Livre("Astérix","Goscinny","Uderzo",2);
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
        livre1.setNbPages(1);
        System.out.println("Diff : " + livre1.compare(livre2));
    }
	
}
