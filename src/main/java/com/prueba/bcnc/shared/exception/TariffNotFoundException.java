package com.prueba.bcnc.shared.exception;

/**
 * TariffNotFoundException
 */
public class TariffNotFoundException extends RuntimeException{
    /**
     * Instantiates a new Tariff not found exception.
     *
     * @param message the message
     */
    public TariffNotFoundException(String message) {
        super(message);
    }
}
