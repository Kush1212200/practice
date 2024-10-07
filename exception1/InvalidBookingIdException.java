package exception1;

public class InvalidBookingIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBookingIdException(String message) {
		super(message);
	}
}
