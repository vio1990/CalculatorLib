package com.ozerian.lib.calculator.exceptions;

/**
 * Exception throws when the calculator doesn't support this type of the operation.
 */
public class NotSupportedException extends Exception {

    public NotSupportedException(String message) {
        super(message);
    }
}
