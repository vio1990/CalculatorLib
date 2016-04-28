package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;

/**
 * Class for subtraction number's data types.
 */
public final class NumberSubtraction implements CalculatorOperation {

    public static final int INDEX_OF_FIRST_NUMBER = 0;
    public static final int INDEX_OF_SECOND_NUMBER = 1;
    private DataParser parser;
    private StringBuilder operationResult = new StringBuilder();

    /**
     * Creation new object with parser and operationRegister.
     *
     * @param parser DataParser for checking data type.
     */
    public NumberSubtraction(DataParser parser) {
        this.parser = parser;
    }

    /**
     * Checking data type and subtraction after definition.
     */

    public void subtract(String firstOperand, String secondOperand) {
        if ("int".equals(parser.getNumberType())) {
            int firstNumber = Integer.parseInt(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            int secondNumber = Integer.parseInt(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            subtractInt(firstNumber, secondNumber);
        } else if ("long".equals(parser.getNumberType())) {
            long firstNumber = Long.parseLong(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            long secondNumber = Long.parseLong(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            subtractLong(firstNumber, secondNumber);
        } else if ("double".equals(parser.getNumberType())) {
            double firstNumber = Double.parseDouble(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            double secondNumber = Double.parseDouble(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            subtractDouble(firstNumber, secondNumber);
        } else if ("float".equals(parser.getNumberType())) {
            float firstNumber = Float.parseFloat(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            float secondNumber = Float.parseFloat(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            subtractFloat(firstNumber, secondNumber);
        } /*else {
            throw new IncorrectInputDataException("Impossible parsing!");
        }*/
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

    @Override
    public void addOperationToRegister(String operationSymbol) {
        operationSymbol = "-";
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