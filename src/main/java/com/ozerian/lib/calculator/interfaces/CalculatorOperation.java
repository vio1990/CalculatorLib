package com.ozerian.lib.calculator.interfaces;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;

/**
 * Interface for common calculator operations.
 * It is being used for addition new operations in
 * the application.
 */
public interface CalculatorOperation {

    /**
     * This method executes some math operation.
     *
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public void calculate() throws IncorrectInputDataException;


    /**
     * Method returns the result of executed operation.
     *
     * @return String result of the executed operation.
     */
    public String getOperationResult();
}
