package com.ozerian.lib.calculator.interfaces;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;

/**
 * Interface for addition different number types.
 * User can add another type of data.
 */
public interface Addition extends CalculatorOperation{

    /**
     * This method adds two numbers.
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public void add() throws IncorrectInputDataException;
}
