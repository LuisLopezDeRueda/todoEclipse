package fct.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class fechasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6913601036092451098L;

	public fechasException() {
		// TODO Auto-generated constructor stub
	}

	public fechasException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public fechasException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public fechasException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public fechasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
