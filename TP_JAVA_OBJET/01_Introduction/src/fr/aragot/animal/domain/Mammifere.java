package fr.aragot.animal.domain;

import java.io.Serializable;

public class Mammifere extends Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6006103040145757758L;

	public Mammifere() {
		super();
	}
	
	public Mammifere(String nom) {
		super(nom);
		System.out.println("test");
	}

	@Override
	public String toString() {
		return "Je suis un mammifère" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	
}
