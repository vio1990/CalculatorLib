package com.ozerian.lib.calculator.exceptions;

/**
 * Exception throws when there are problems with input data after some methods and operations.
 */
public class IncorrectInputDataException extends Exception {

    public IncorrectInputDataException(String message) {
        super(message);
    }
}
