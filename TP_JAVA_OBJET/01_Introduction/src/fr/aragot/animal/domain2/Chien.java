package fr.aragot.animal.domain2;

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
		return "Je suis un chien" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	@Override
	public void parle() {
		System.out.println(this.getNom() + " parle : wouf wouf");
		
	}
}
