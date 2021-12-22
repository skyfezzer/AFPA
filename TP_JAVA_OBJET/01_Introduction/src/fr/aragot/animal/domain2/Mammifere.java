package fr.aragot.animal.domain2;

import java.io.Serializable;

/**
 * Un mammif�re est un {@link Animal} impl�mentant l'interface {@link Serializable}
 * 
 * @author Alexis RAGOT
 *
 */
public class Mammifere extends Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6006103040145757758L;

	/**
	 * Constructeur vide de la classe Mammifere
	 */
	public Mammifere() {
		super();
	}
	
	/**
	 * Constructeur de la classe Mammif�re
	 * @param nom Le nom du mammif�re
	 */
	public Mammifere(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Je suis un mammif�re" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	
}
