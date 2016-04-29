package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;

/**
 * Class for addition number's data types.
 */
public final class NumberAddition implements CalculatorOperation {

    public static final int INDEX_OF_FIRST_NUMBER = 0;
    public static final int INDEX_OF_SECOND_NUMBER = 1;
    private DataParser parser;
    private StringBuilder operationResult = new StringBuilder();
    private String firstOperand = parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER);
    private String secondOperand = parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER);


    /**
     * Creation new object with parser and operationRegister.
     *
     * @param parser DataParser for checking data type.
     */
    public NumberAddition(DataParser parser) {
        this.parser = parser;
    }

    /**
     * Checking data type and addition after definition.
     */

    public void add(String firstOperand, String secondOperand) {

        firstOperand = parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER);
        secondOperand = parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER);

        if ("int".equals(parser.getNumberType())) {
            int firstNumber = Integer.parseInt(firstOperand);
            int secondNumber = Integer.parseInt(secondOperand);
            addInt(firstNumber, secondNumber);
        } else if ("long".equals(parser.getNumberType())) {
            long firstNumber = Long.parseLong(firstOperand);
            long secondNumber = Long.parseLong(secondOperand);
            addLong(firstNumber, secondNumber);
        } else if ("double".equals(parser.getNumberType())) {
            double firstNumber = Double.parseDouble(firstOperand);
            double secondNumber = Double.parseDouble(secondOperand);
            addDouble(firstNumber, secondNumber);
        } else if ("float".equals(parser.getNumberType())) {
            float firstNumber = Float.parseFloat(firstOperand);
            float secondNumber = Float.parseFloat(secondOperand);
            addFloat(firstNumber, secondNumber);
        } /*else {
            throw new IncorrectInputDataException("Impossible parsing!");
        }*/
    }

    /**
     * Addition operation for int data type.
     *
     * @param firstNumber  int first summand.
     * @param secondNumber int second summand.
     */
    public void addInt(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Addition operation for long data type.
     *
     * @param firstNumber  long first summand.
     * @param secondNumber long second summand.
     */
    public void addLong(long firstNumber, long secondNumber) {
        long result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Addition operation for float data type.
     *
     * @param firstNumber  float first summand.
     * @param secondNumber float second summand.
     */
    public void addFloat(float firstNumber, float secondNumber) {
        float result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);

    }

    /**
     * Addition operation for double data type.
     *
     * @param firstNumber  double first summand.
     * @param secondNumber double second summand.
     */
    public void addDouble(double firstNumber, double secondNumber) {
        double result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult = new StringBuilder();
        operationResult.append(textResult);
    }

    /**
     * Override method for execution add operation.
     */
    @Override
    public void calculate(String firstNumber, String secondNumber) {
        this.add(firstNumber, secondNumber);
    }

    @Override
    public void addOperationToRegister(String operationSymbol) {
        operationSymbol = "+";
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
