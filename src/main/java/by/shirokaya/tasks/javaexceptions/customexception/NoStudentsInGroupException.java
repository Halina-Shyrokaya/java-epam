package by.shirokaya.tasks.javaexceptions.customexception;

public class NoStudentsInGroupException extends Exception {
    public NoStudentsInGroupException() {
    }

    public NoStudentsInGroupException(String message) {
        super(message);
    }

    public NoStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupException(Throwable cause) {
        super(cause);
    }
}
