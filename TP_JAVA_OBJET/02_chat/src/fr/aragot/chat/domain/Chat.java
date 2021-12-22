package fr.aragot.chat.domain;

import fr.aragot.animal.domain2.Mammifere;

/**
 * Un chat est un {@link Mammifere} pouvant parler, plus précisément miauler.
 * @author Alexis RAGOT
 *
 */
public class Chat extends Mammifere {

	/**
	 * Constructeur vide de la classe Chat
	 */
	public Chat() {
		super();
	}
	
	/**
	 * Constructeur de la classe Chat
	 * @param nom Le nom du chat
	 */
	public Chat(String nom) {
		super(nom);
	}
	
	@Override
	public String toString() {
		return String.format("Je suis un %s de nom %s", this.getClass().getSimpleName(),this.getNom());
	}


	@Override
	public void parle() {
		System.out.println(this.getNom() + " parle : miaou miaou");
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -3110099575149501307L;

}
