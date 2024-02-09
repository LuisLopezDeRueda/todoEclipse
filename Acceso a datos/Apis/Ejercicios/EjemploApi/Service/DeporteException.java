package EjemploApi.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeporteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1501607007650513356L;

	public DeporteException() {
	}

	public DeporteException(String message) {
		super(message);

	}

	public DeporteException(Throwable cause) {
		super(cause);

	}

	public DeporteException(String message, Throwable cause) {
		super(message, cause);

	}

	public DeporteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
