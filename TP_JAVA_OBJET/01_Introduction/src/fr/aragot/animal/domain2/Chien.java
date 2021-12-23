package fr.aragot.animal.domain2;

/**
 * Un chien est un {@link Mammifere} pouvant parler.
 * Un chien aboie quand il parle.
 * @author Alexis RAGOT
 *
 */
public class Chien extends Mammifere {
	
	/** Identifiant unique pour la sérialisation. */
	private static final long serialVersionUID = -2204082218115704974L;

	
	/**
	 * 	Constructeur de la classe Chien
	 * @param nom Le nom du chien
	 */
	public Chien(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return super.toString() + "Je suis un chien.";
	}
	
	@Override
	public void parle() {
		System.out.println(this.getNom() + " parle : wouf wouf");
		
	}
}
