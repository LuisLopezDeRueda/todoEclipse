package Servicio;

public class PeliculasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4448164890197900147L;

	public PeliculasException() {
	}

	public PeliculasException(String message) {
		super(message);

	}

	public PeliculasException(Throwable cause) {
		super(cause);

	}

	public PeliculasException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
