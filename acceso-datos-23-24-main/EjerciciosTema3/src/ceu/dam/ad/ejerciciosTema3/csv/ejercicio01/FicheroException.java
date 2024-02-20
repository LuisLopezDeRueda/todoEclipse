package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

public class FicheroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1620558941905514466L;

	public FicheroException() {
	}

	public FicheroException(String message) {
		super(message);
	}

	public FicheroException(Throwable cause) {
		super(cause);
	}

	public FicheroException(String message, Throwable cause) {
		super(message, cause);
	}

	public FicheroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
