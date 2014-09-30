package exceptions;

public class InvalidMovementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMovementException() {
		super("Invalid movement, the position should be between (0,0) and (2,2)");
	}

}
