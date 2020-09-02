package by.shirokaya.tasks.javaexceptions.customexception;

public class NoMarksInStudentException extends Exception {

    public NoMarksInStudentException() {
    }

    public NoMarksInStudentException(String message) {
        super(message);
    }

    public NoMarksInStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMarksInStudentException(Throwable cause) {
        super(cause);
    }
}
