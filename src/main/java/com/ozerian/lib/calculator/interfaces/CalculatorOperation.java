package com.ozerian.lib.calculator.interfaces;


/**
 * Interface for common calculator operations.
 * It is being used for addition new operations in
 * the application.
 */
public interface CalculatorOperation {

    /**
     * This method executes some math operation.
     */
    public void calculate(String firstOperand, String secondOperand);

    public void addOperationToRegister(String operationSymbol);

    /**
     * Method returns the result of executed operation.
     *
     * @return String result of the executed operation.
     */
    public String getOperationResult();
}
