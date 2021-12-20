package fr.aragot.animal.domain2;

public class Homme extends Mammifere {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1820798011402632323L;

	public Homme() {
		super();
	}
	public Homme(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Je suis un homme" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
	@Override
	public void parle() {
		System.out.println(this.getNom() + " parle : Vive le polymorphisme !");
		
	}
	
}
