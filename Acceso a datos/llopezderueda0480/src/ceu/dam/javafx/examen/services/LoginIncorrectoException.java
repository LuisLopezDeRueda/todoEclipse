package ceu.dam.javafx.examen.services;

public class LoginIncorrectoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8647246023028628145L;

	public LoginIncorrectoException() {
		super();
	}

	public LoginIncorrectoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginIncorrectoException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginIncorrectoException(String message) {
		super(message);
	}

	public LoginIncorrectoException(Throwable cause) {
		super(cause);
	}

	
}
