package EJ5.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ServerErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7316422999332004847L;

	public ServerErrorException() {
	}

	public ServerErrorException(String message) {
		super(message);

	}

	public ServerErrorException(Throwable cause) {
		super(cause);

	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);

	}

	public ServerErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
