package diary;

public class InvalidUsernameException extends RuntimeException{
    public InvalidUsernameException(String message) {
        super(message);
    }
}
