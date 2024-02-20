package ejemplorest.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeporteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416436514349681215L;

	public DeporteNotFoundException() {
	}

	public DeporteNotFoundException(String message) {
		super(message);
	}

	public DeporteNotFoundException(Throwable cause) {
		super(cause);
	}

	public DeporteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeporteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
