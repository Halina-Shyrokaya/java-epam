package by.shirokaya.tasks.javaexceptions.customexception;

public class InvalidMarkException extends Exception {
    public InvalidMarkException() {
    }

    public InvalidMarkException(String message) {
        super(message);
    }

    public InvalidMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMarkException(Throwable cause) {
        super(cause);
    }
}
