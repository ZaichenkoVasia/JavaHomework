package ua.mycompany.proxy.exception;

public class EntityNotFoundRuntimeException extends RuntimeException {
    public EntityNotFoundRuntimeException(String message) {
        super(message);
    }
}
