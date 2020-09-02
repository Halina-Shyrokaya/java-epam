package by.shirokaya.tasks.javaexceptions.customexception;

public class NoSubjectsInStudentException extends Exception {
    public NoSubjectsInStudentException() {
    }

    public NoSubjectsInStudentException(String message) {
        super(message);
    }

    public NoSubjectsInStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectsInStudentException(Throwable cause) {
        super(cause);
    }
}
