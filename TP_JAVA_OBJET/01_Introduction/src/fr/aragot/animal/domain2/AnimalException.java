package fr.aragot.animal.domain2;

public class AnimalException extends RuntimeException{

	private static final long serialVersionUID = 4454379424160208417L;
	
	public AnimalException() {}
	public AnimalException(String message) {
		super(message);
	}
	
}

