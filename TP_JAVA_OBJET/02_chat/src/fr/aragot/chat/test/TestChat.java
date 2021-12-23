package fr.aragot.chat.test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import fr.aragot.animal.domain2.Animal;
import fr.aragot.animal.domain2.Chien;
import fr.aragot.animal.domain2.Homme;
import fr.aragot.animal.domain2.Mammifere;
import fr.aragot.chat.domain.Chat;

public class TestChat {

	public static void main(String[] args) {
		
		// ===== CREATION DES OBJETS =====
		Animal[] animaux = new Animal[3];
		animaux[0] = new Animal("Truc");
		animaux[1] = new Chien("Médor");
		animaux[2] = new Homme("Robert");
		
		// ===== TEST DE parle() =====
		System.out.println("====== parle() via List.stream ======");
		List<Animal> animauxList = Arrays.asList(animaux);
		animauxList.stream().forEach(x->x.parle());
		System.out.println();
		System.out.println("====== Médor compareTo un new Chien(\"Robert\") ======");
		System.out.println(animaux[1].compareTo(new Chien("Robert")));
		System.out.println();
		
		// ===== TEST DE CAST =====
		Animal a = new Mammifere("unMammifère");
		Comparable<?> c = new Homme("Jean");
		Serializable s = new Chien("Medor");
		Homme h1 = (Homme) c;
		//Homme h2 = (Homme) s; => ClassCastException
		
		
		// ===== TEST DE parle() =====
		System.out.println("====== parle() via TreeSet.stream ======");
		TreeSet<Animal> ts = new TreeSet<Animal>();
		ts.addAll(animauxList);
		ts.forEach(x->x.parle());
		System.out.println();
		
		// ===== TEST DE Chat =====
		System.out.println("====== Création d'un chat 'félix' ======");
		Chat chat = new Chat("Félix");
		System.out.println(chat);
		chat.parle();

		
		

	}

}
