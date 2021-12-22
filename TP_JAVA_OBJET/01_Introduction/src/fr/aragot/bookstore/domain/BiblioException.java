package fr.aragot.bookstore.domain;

public class BiblioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7978768103383278985L;
	public BiblioException() {}
	public BiblioException(String msg) {
		super(msg);
	}
}
