package fr.aragot.animal.domain2;

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
	}

	@Override
	public String toString() {
		return "Je suis un mammif�re" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	
}
