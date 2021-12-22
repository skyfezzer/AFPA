package fr.aragot.animal.domain2;

import java.io.Serializable;

/**
 * Un mammifère est un {@link Animal} implémentant l'interface {@link Serializable}
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
	 * Constructeur de la classe Mammifère
	 * @param nom Le nom du mammifère
	 */
	public Mammifere(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Je suis un mammifère" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	
}
