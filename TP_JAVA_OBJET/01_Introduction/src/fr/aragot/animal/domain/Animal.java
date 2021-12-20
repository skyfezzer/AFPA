package fr.aragot.animal.domain;

import java.util.Objects;

public class Animal implements Comparable<Animal>,Nommable{
	private String nom;

	
	public Animal() {
		super();
	}
	
	public Animal(String nom) {
		this.setNom(nom);
	}
	
	private void setNom(String nom) {
		this.nom=nom;
		
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public int compareTo(Animal o) {
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString() {
		return "Je suis un animal" + (nom!=null?" de nom "+this.getNom():"")+".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nom, other.nom);
	}
	
}
