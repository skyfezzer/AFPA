package fr.aragot.animal.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fr.aragot.animal.domain2.Animal;
import fr.aragot.animal.domain2.Chien;
import fr.aragot.animal.domain2.Homme;
import fr.aragot.animal.domain2.AnimalException;

public class TestAnimals {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Animal[] animaux = null;
		try {
			animaux = returnAnimalTab();
		} catch (AnimalException e) {
			//e.printStackTrace();
			System.err.println("Err");
		}
		if(animaux!=null) {
			testPolymorphisme(animaux);
			testProgrammationFonctionnelle(animaux);
		}
		
		List<Animal> animauxList = null;
		try {
			animauxList = testCollectionInsteadOfBoard();
		} catch (AnimalException e) {
			System.err.println("Err");
		}
		if(animauxList!=null) {
			triLaCollection(animauxList);

		}

	}

	/**
	 * Question 6
	 * @author solen
	 */
	public static void triLaCollection(List<Animal> animauxList) {
		System.out.println("***********************************");
		System.out.println("Trier dans les 2 sens la collection");
		System.out.println("***********************************");
		System.out.println("Avant tri : " + animauxList);
		animauxList.sort(null);
		System.out.println("Après tri :" + animauxList);
		Collections.reverse(animauxList);
		System.out.println("Tri inverse :" + animauxList);
	}

	/**
	 * Question 5
	 * @author solen
	 */
	public static List<Animal> testCollectionInsteadOfBoard(){
		System.out.println("**************************************************************************");
		System.out.println("Utiliser une collection de type \"ensemble ordonné\" à la place du tableau");
		System.out.println("**************************************************************************");
		List<Animal> animauxList = new ArrayList<>();
		animauxList.add(new Animal("Truc"));
		animauxList.add(new Chien("Medor"));
		animauxList.add(new Homme("Robert"));
		//animauxList.add(new Homme("Roberto de la Vegas"));
		return animauxList;
	}
	
	/**
	 * Question 3
	 * @author solen
	 */
	public static void testProgrammationFonctionnelle(Animal[] animaux) {
		System.out.println("*************************************************************************************");
		System.out.println("En une ligne, transformer le tableau en List et faites parler l'ensemble (API Stream)");
		System.out.println("*************************************************************************************");
		
		List<Animal> animauxList = Arrays.asList(animaux);
		animauxList.stream().forEach(it -> {
			System.out.print(it.getNom() + " parle :");
			it.parle();
		});
	}

	/**
	 * Question 2
	 * @author solen
	 */
	public static void testPolymorphisme(Animal[] animaux) {
		System.out.println("***************************************************************************");
		System.out.println("On souhaite faire parler les animaux en mettant en oeuvre le polymorphisme.");
		System.out.println("***************************************************************************");
		for (Animal animal : animaux) {
			System.out.print(animal.getNom() + " parle :");
			animal.parle();
		}
	}

	/**
	 * retourne un tableau d'animaux
	 * @author solen
	 * @throws AnimalException 
	 */
	public static Animal[] returnAnimalTab(){
		Animal[] animaux = { new Animal("Truc"), new Chien("Medor"), new Homme("Robert") };

		List<Animal> animauxList = Arrays.asList(animaux);
		animauxList.stream().forEach(System.out::println);

		return animaux;
	}
}
