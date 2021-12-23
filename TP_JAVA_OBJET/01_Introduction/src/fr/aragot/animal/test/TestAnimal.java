package fr.aragot.animal.test;

import java.util.Arrays;

import fr.aragot.animal.domain2.Animal;
import fr.aragot.animal.domain2.Chien;
import fr.aragot.animal.domain2.Homme;

public class TestAnimal {

	public static void main(String[] args) {
		Animal[] animaux = new Animal[3];
		animaux[0] = new Animal("Truc");
		animaux[1] = new Chien("Médor");
		animaux[2] = new Homme("Robert");
		Arrays.asList(animaux).stream().forEach(System.out::println);
		System.out.println(animaux[1].compareTo(new Chien("Robert")));

	}

}
