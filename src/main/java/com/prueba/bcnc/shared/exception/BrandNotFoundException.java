package com.prueba.bcnc.shared.exception;

/**
 * The type Brand not found exception.
 */
public class BrandNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Brand not found exception.
     *
     * @param message the message
     */
    public BrandNotFoundException(String message) {
        super(message);
    }
}
