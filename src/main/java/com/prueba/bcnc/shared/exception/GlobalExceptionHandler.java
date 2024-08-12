package com.prueba.bcnc.shared.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle all other exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleAllOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }

    /**
     * Handle tariff not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(TariffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleTariffNotFoundException(TariffNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Handle product not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Handle brand not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(BrandNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleBrandNotFoundException(BrandNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Handle constraint violation exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            String propertyPath = cv.getPropertyPath().toString();
            String message = cv.getMessage();
            errors.put(propertyPath, message);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
