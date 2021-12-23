package fr.aragot.animal.domain;

public class Chien extends Mammifere {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8967579181704581195L;

	public Chien(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return super.toString() + "Je suis un chien.";
	}
}
