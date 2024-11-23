package com.example.demo.utils;

/**
 * Custom exception class to represent "Not Found" errors.
 * This exception is thrown when a requested resource cannot be found.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Default constructor that sets a default error message.
     * This constructor is used when the exception is thrown without a specific message.
     */
    public NotFoundException() {
        super("Resource not found");
    }

    /**
     * Constructor that accepts a custom error message.
     * This constructor allows for a custom message to be provided when the exception is thrown.
     *
     * @param message the custom error message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor that accepts a custom error message and a cause.
     * This constructor allows for a custom message and the underlying cause of the exception to be specified.
     *
     * @param message the custom error message
     * @param cause   the underlying cause of the exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor that accepts a cause.
     * This constructor allows for an underlying cause to be provided when the exception is thrown.
     *
     * @param cause the underlying cause of the exception
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
