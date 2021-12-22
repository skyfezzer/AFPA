package fr.aragot.animal.domain2;

import java.util.Objects;

/**
 * Animal est l'objet principal de ce programme.
 * Toutes les classes vont dériver de cette classe principale
 * @author Alexis RAGOT
 *
 */
public class Animal implements Comparable<Animal>,Nommable{
	/** Le nom de l'animal */
	private String nom;

	
	/**
	 * Constructeur vide de la classe Animal
	 */
	public Animal() {
		super();
	}
	
	/**
	 * Constructeur de la classe Animal
	 * @param nom Le nom de l'animal
	 */
	public Animal(String nom) {
		this.setNom(nom);
	}
	
	/**
	 * Modifie le nom de l'animal
	 * @param nom Le nouveau nom de l'animal
	 */
	private void setNom(String nom) {
		if(nom.length() > 15)
			throw new AnimalException("Le nom ne peut pas dépasser 15 carac.");
		this.nom=nom;
		
	}

	@Override
	public String getNom() {
		return nom;
	}

	/**
	 *	Compare l'animal actuel à un autre animal par le nom.
	 *	@param animal un {@link Animal} à comparer à l'animal actuel
	 *  @return un {@code int} représendant la différence des noms dans l'ordre alphanumerique
	 */
	@Override
	public int compareTo(Animal animal) {
		return getNom().compareTo(animal.getNom());
	}
	
	@Override
	public String toString() {
		return "Je suis un animal" + (nom!=null?" de nom "+this.getNom():"")+".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	/**
	 *	Compare l'animal avec un objet passé en paramètre.
	 *	@param obj un Objet java.
	 *	@return {@code true} si l'objet est un Animal, et que les noms sont égaux.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nom, other.nom);
	}
	
	
	/**
	 * Affiche dans la sortie standard un message contenant le cri de l'animal.
	 */
	public void parle() {
		System.out.println(this.getNom() + " parle : brrrrrrrrrrrrrrr");
		
	}
	
}

class AnimalException extends RuntimeException{

	private static final long serialVersionUID = 4454379424160208417L;
	
	public AnimalException() {}
	public AnimalException(String message) {
		super(message);
	}
	
}
