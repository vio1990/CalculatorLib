package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;

/**
 * Class for subtraction number's data types.
 */
public final class NumberSubtraction implements CalculatorOperation {

    private Parser parser;
    private StringBuilder operationResult = new StringBuilder();

    /**
     * Creation new object with parser and operationRegister.
     *
     * @param parser DataParser for checking data type.
     */
    public NumberSubtraction(Parser parser) {
        this.parser = parser;
        addOperationToRegister("-");
    }

    /**
     * Checking data type and subtraction after definition.
     */

    public void subtract(String firstOperand, String secondOperand) {

        if ("int".equals(parser.getNumberType())) {
            int firstNumber = Integer.parseInt(firstOperand);
            int secondNumber = Integer.parseInt(secondOperand);
            subtractInt(firstNumber, secondNumber);
        } else if ("long".equals(parser.getNumberType())) {
            long firstNumber = Long.parseLong(firstOperand);
            long secondNumber = Long.parseLong(secondOperand);
            subtractLong(firstNumber, secondNumber);
        } else if ("double".equals(parser.getNumberType())) {
            double firstNumber = Double.parseDouble(firstOperand);
            double secondNumber = Double.parseDouble(secondOperand);
            subtractDouble(firstNumber, secondNumber);
        } else if ("float".equals(parser.getNumberType())) {
            float firstNumber = Float.parseFloat(firstOperand);
            float secondNumber = Float.parseFloat(secondOperand);
            subtractFloat(firstNumber, secondNumber);
        } else {
            throw new UnsupportedOperationException("Not supported data type!");
        }
    }

    /**
     * Subtraction operation for int data type.
     *
     * @param firstNumber  int minuend.
     * @param secondNumber int subtrahend.
     */
    public void subtractInt(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        String textResult = firstNumber + "-" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Subtraction operation for long data type.
     *
     * @param firstNumber  long minuend.
     * @param secondNumber long subtrahend.
     */
    public void subtractLong(long firstNumber, long secondNumber) {
        long result = firstNumber - secondNumber;
        String textResult = firstNumber + "-" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Subtraction operation for float data type.
     *
     * @param firstNumber  float minuend.
     * @param secondNumber float subtrahend.
     */
    public void subtractFloat(float firstNumber, float secondNumber) {
        float result = firstNumber - secondNumber;
        String textResult = firstNumber + "-" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Subtraction operation for double data type.
     *
     * @param firstNumber  double minuend.
     * @param secondNumber double subtrahend.
     */
    public void subtractDouble(double firstNumber, double secondNumber) {
        double result = firstNumber - secondNumber;
        String textResult = firstNumber + "-" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Override method for execution add operation.
     */
    @Override
    public void calculate(String firstOperand, String secondOperand) {
        this.subtract(firstOperand, secondOperand);
    }

    /**
     * Addition operation for support in calculator.
     *
     * @param operationSymbol String value of math operation.
     */
    @Override
    public void addOperationToRegister(String operationSymbol) {
        OperationRegister.addOperation(operationSymbol, this);
    }

    /**
     * Method returns the result of the executed operation.
     *
     * @return String result of the operation.
     */
    @Override
    public String getOperationResult() {
        return operationResult.toString();
    }
}