package bankApp;

public class InvalidPinException extends RuntimeException {
    public InvalidPinException(String message){
        super(message);
    }
}
