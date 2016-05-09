package com.ozerian.lib.calculator.interfaces;


/**
 * Interface for common calculator operations.
 * It is being used for addition new operations in
 * the application.
 */
public interface CalculatorOperation {

    /**
     * Method for description of execution some math operation.
     */
    public void calculate(String firstOperand, String secondOperand);

    /**
     * Addition appropriate math operation to OperationRegister.
     *
     * @param operationSymbol String value of math operation.
     */
    public void addOperationToRegister(String operationSymbol);

    /**
     * Method returns the result of executed operation.
     *
     * @return String result of the executed operation.
     */
    public String getOperationResult();
}
