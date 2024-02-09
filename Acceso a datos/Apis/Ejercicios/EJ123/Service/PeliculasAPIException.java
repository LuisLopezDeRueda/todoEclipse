package EJ123.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PeliculasAPIException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6461356682635061191L;

	public PeliculasAPIException() {
	}

	public PeliculasAPIException(String message) {
		super(message);

	}

	public PeliculasAPIException(Throwable cause) {
		super(cause);

	}

	public PeliculasAPIException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculasAPIException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
