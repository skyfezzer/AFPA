package fr.aragot.animal.domain2;

/**
 * Un poisson est un {@link Animal}.
 * @author Alexis RAGOT
 *
 */
public class Poisson extends Animal {

	@Override
	public String toString() {
		return "Je suis un poisson" + (this.getNom()!=null?" de nom "+this.getNom():"")+".";
	}
	
}
