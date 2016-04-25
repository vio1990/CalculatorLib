package com.ozerian.lib.calculator.interfaces;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;

/**
 * Interface for subtraction different number types.
 * User can add another type of data.
 */
public interface Subtraction extends CalculatorOperation {

    /**
     * This method subtracts two numbers.
     *
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public void subtract() throws IncorrectInputDataException;
}
