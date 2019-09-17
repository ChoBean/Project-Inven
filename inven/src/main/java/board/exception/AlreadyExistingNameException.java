package board.exception;

public class AlreadyExistingNameException extends RuntimeException{
	public AlreadyExistingNameException(String message) {
		super(message);
	}
}
