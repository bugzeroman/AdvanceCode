package edu.yuwen.dp.create.factory.more.di.exception;

public class BeanCreationFailureException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public BeanCreationFailureException() {
        super();
    }

    public BeanCreationFailureException(String message) {
        super(message);
    }

    public BeanCreationFailureException(String message, ReflectiveOperationException e) {
        super(message, e);
    }
}