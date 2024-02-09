package Ejercicio5.Service;

public class LibroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7311699312230770386L;

	public LibroException() {
	}

	public LibroException(String message) {
		super(message);

	}

	public LibroException(Throwable cause) {
		super(cause);

	}

	public LibroException(String message, Throwable cause) {
		super(message, cause);

	}

	public LibroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
