package ua.mycompany.task4.exception;

public class UncorrectLoginException extends RuntimeException{
    public UncorrectLoginException(String message) {
        super(message);
    }
}
