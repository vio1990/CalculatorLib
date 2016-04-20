package com.ozerian.lib.calculator.exceptions;

/**
 * Exception throws when there are problems with input data initially.
 */
public class WrongInputDataException extends Exception {

    public WrongInputDataException(String message) {
        super(message);
    }
}
