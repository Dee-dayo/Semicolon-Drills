package bankApp;

public class NoAccountFound extends RuntimeException {
    public NoAccountFound(String message) {
        super(message);
    }
}
