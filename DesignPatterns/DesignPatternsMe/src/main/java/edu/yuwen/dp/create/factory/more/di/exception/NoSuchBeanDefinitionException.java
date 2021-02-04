package edu.yuwen.dp.create.factory.more.di.exception;

public class NoSuchBeanDefinitionException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public NoSuchBeanDefinitionException() {
        super();
    }

    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}
