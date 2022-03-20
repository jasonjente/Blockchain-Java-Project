package application.blockchain.model;

public class BlockValidationException extends Exception {
    public BlockValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlockValidationException(String message) {
        super(message);
    }
}
