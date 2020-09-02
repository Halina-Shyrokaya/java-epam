package by.shirokaya.tasks.javaexceptions.customexception;

public class NotExistingFacultyException extends Exception {
    public NotExistingFacultyException() {
    }

    public NotExistingFacultyException(String message) {
        super(message);
    }

    public NotExistingFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistingFacultyException(Throwable cause) {
        super(cause);
    }
}
