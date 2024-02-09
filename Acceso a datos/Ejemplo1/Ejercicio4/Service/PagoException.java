package Service;

public class PagoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2608980360148103319L;

	public PagoException() {
	}

	public PagoException(String message) {
		super(message);

	}

	public PagoException(Throwable cause) {
		super(cause);

	}

	public PagoException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
