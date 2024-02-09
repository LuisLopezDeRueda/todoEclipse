package EJ4.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteExceptionAPI extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7309665251941759134L;

	public ClienteExceptionAPI() {
	}

	public ClienteExceptionAPI(String message) {
		super(message);

	}

	public ClienteExceptionAPI(Throwable cause) {
		super(cause);

	}

	public ClienteExceptionAPI(String message, Throwable cause) {
		super(message, cause);

	}

	public ClienteExceptionAPI(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
