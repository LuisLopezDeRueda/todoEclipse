package practica.services;

public class LoginDenegadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7360183604781393498L;

	public LoginDenegadoException() {
	}

	public LoginDenegadoException(String message) {
		super(message);

	}

	public LoginDenegadoException(Throwable cause) {
		super(cause);

	}

	public LoginDenegadoException(String message, Throwable cause) {
		super(message, cause);

	}

	public LoginDenegadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
