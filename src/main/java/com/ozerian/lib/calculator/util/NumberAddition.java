package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.interfaces.Addition;

/**
 * Class for addition number's data types.
 */
public final class NumberAddition implements Addition {

    public static final int INDEX_OF_FIRST_NUMBER = 0;
    public static final int INDEX_OF_SECOND_NUMBER = 1;
    private DataParser parser;
    private OperationFactory operationFactory;
    private StringBuilder operationResult = new StringBuilder();

    /**
     * Creation new object with parser and operationFactory.
     *
     * @param parser           DataParser for checking data type.
     * @param operationFactory OperationFactory for checking supported operations.
     */
    public NumberAddition(DataParser parser, OperationFactory operationFactory) {
        this.parser = parser;
        this.operationFactory = operationFactory;
        operationFactory.addOperation("+", this);
    }

    /**
     * Checking data type and addition after definition.
     *
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    @Override
    public void add() throws IncorrectInputDataException {
        if ("int".equals(parser.getNumberType())) {
            int firstNumber = Integer.parseInt(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            int secondNumber = Integer.parseInt(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            addInt(firstNumber, secondNumber);
        } else if ("long".equals(parser.getNumberType())) {
            long firstNumber = Long.parseLong(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            long secondNumber = Long.parseLong(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            addLong(firstNumber, secondNumber);
        } else if ("double".equals(parser.getNumberType())) {
            double firstNumber = Double.parseDouble(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            double secondNumber = Double.parseDouble(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            addDouble(firstNumber, secondNumber);
        } else if ("float".equals(parser.getNumberType())) {
            float firstNumber = Float.parseFloat(parser.getStringNumbers().get(INDEX_OF_FIRST_NUMBER));
            float secondNumber = Float.parseFloat(parser.getStringNumbers().get(INDEX_OF_SECOND_NUMBER));
            addFloat(firstNumber, secondNumber);
        } else {
            throw new IncorrectInputDataException("Impossible parsing!");
        }
    }

    /**
     * Addition operation for int data type.
     *
     * @param firstNumber  int first summand
     * @param secondNumber int second summand.
     */
    public void addInt(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult.append(textResult);
    }

    /**
     * Addition operation for long data type.
     *
     * @param firstNumber  long first summand
     * @param secondNumber long second summand.
     */
    public void addLong(long firstNumber, long secondNumber) {
        long result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult.append(textResult);
    }

    /**
     * Addition operation for float data type.
     *
     * @param firstNumber  float first summand
     * @param secondNumber float second summand.
     */
    public void addFloat(float firstNumber, float secondNumber) {
        float result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult.append(textResult);

    }

    /**
     * Addition operation for double data type.
     *
     * @param firstNumber  double first summand
     * @param secondNumber double second summand.
     */
    public void addDouble(double firstNumber, double secondNumber) {
        double result = firstNumber + secondNumber;
        String textResult = firstNumber + "+" + secondNumber + "=" + result;
        operationResult.append(textResult);

    }

    /**
     * Override method for execution add operation.
     *
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    @Override
    public void calculate() throws IncorrectInputDataException {
        this.add();
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
