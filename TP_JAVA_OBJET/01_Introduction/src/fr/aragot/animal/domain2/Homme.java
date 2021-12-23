package fr.aragot.animal.domain2;

/**
 * Un Homme est un {@link Mammifere} pouvant parler.
 * @author Alexis RAGOT
 *
 */
public class Homme extends Mammifere {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1820798011402632323L;

	/**
	 *  Constructeur vide de la classe Homme
	 */
	public Homme() {
		super();
	}
	/**
	 * Constructeur de la classe Homme
	 * @param nom Le nom de l'Homme
	 */
	public Homme(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return super.toString() + "Je suis un homme.";
	}
	
	
	/**
	 * Affiche dans la sortie standard une parole de l'Homme.
	 */
	@Override
	public void parle() {
		System.out.println(this.getNom() + " parle : Vive le polymorphisme !");
		
	}
	
}
