package com.lvan.jpademo.exception;

/**
 * @author Lvan
 * @since 2021/10/10
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
