package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;
import com.ozerian.lib.calculator.interfaces.CalculatorAddition;
import com.ozerian.lib.calculator.interfaces.CalculatorSubstraction;

/**
 * Util class for parsing and calculating of the inpit string expression.
 * User can add appropriate operations with implementing the appropriate interfaces.
 * User can add supported data types with adding it in interfaces.
 */
public final class Calculator implements CalculatorAddition, CalculatorSubstraction {

    /**
     * Method with dataHandler object for parsing and checking input data.
     * This method also calculates and returns the result of math operation.
     *
     * @param inputData String input math expression by user.
     * @return String with the result of the math operation.
     * @throws WrongInputDataException     Throws when there are problems with input data initially.
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public String calculatorExecution(String inputData) throws WrongInputDataException, IncorrectInputDataException {
        DataHandler handler = new DataHandler();
        StringBuilder result = new StringBuilder();
        handler.inputDataHandling(inputData);
        handler.numbersTypeCheck(handler.getNumbers());

        operatorCheckAndCalculate(handler, result);
        return result.toString();
    }

    /**
     * Checking operator's value, checking data type and calculating.
     *
     * @param handler DataHandler object with the values of the handling.
     * @param result  StringBuilder object for result's formation.
     * @throws WrongInputDataException Throws when there are problems with input data initially.
     */
    private void operatorCheckAndCalculate(DataHandler handler, StringBuilder result) throws WrongInputDataException {
        if ("plus".equals(handler.getOperationFlag())) {
            if ("int".equals(handler.getNumberType())) {
                intCheckAndAdd(handler, result);
            } else if ("long".equals(handler.getNumberType())) {
                longCheckAndAdd(handler, result);
            } else if ("float".equals(handler.getNumberType())) {
                floatCheckAndAdd(handler, result);
            } else if ("double".equals(handler.getNumberType())) {
                doubleCheckAndAdd(handler, result);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }
        } else if ("minus".equals(handler.getOperationFlag())) {
            if ("int".equals(handler.getNumberType())) {
                intCheckAndSubtract(handler, result);
            } else if ("long".equals(handler.getNumberType())) {
                longCheckAndSubtract(handler, result);
            } else if ("float".equals(handler.getNumberType())) {
                floatCheckAndSubtract(handler, result);
            } else if ("double".equals(handler.getNumberType())) {
                doubleCheckAndSubtract(handler, result);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }
        } else {
            throw new WrongInputDataException("Wrong input data!");
        }
    }

    /**
     * Checking if the data type - double. If so - subtract operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void doubleCheckAndSubtract(DataHandler handler, StringBuilder result) {
        double firstNumber = Double.parseDouble(handler.getNumbers().get(0));
        double secondNumber = Double.parseDouble(handler.getNumbers().get(1));
        result.append(doubleSubtract(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - float. If so - subtract operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void floatCheckAndSubtract(DataHandler handler, StringBuilder result) {
        float firstNumber = Float.parseFloat(handler.getNumbers().get(0));
        float secondNumber = Float.parseFloat(handler.getNumbers().get(1));
        result.append(floatSubtract(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - long. If so - subtract operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void longCheckAndSubtract(DataHandler handler, StringBuilder result) {
        long firstNumber = Long.parseLong(handler.getNumbers().get(0));
        long secondNumber = Long.parseLong(handler.getNumbers().get(1));
        result.append(longSubtract(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - int. If so - subtract operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void intCheckAndSubtract(DataHandler handler, StringBuilder result) {
        int firstNumber = Integer.parseInt(handler.getNumbers().get(0));
        int secondNumber = Integer.parseInt(handler.getNumbers().get(1));
        result.append(intSubtract(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - double. If so - add operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void doubleCheckAndAdd(DataHandler handler, StringBuilder result) {
        double firstNumber = Double.parseDouble(handler.getNumbers().get(0));
        double secondNumber = Double.parseDouble(handler.getNumbers().get(1));
        result.append(doubleAdd(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - float. If so - add operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void floatCheckAndAdd(DataHandler handler, StringBuilder result) {
        float firstNumber = Float.parseFloat(handler.getNumbers().get(0));
        float secondNumber = Float.parseFloat(handler.getNumbers().get(1));
        result.append(floatAdd(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - long. If so - add operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void longCheckAndAdd(DataHandler handler, StringBuilder result) {
        long firstNumber = Long.parseLong(handler.getNumbers().get(0));
        long secondNumber = Long.parseLong(handler.getNumbers().get(1));
        result.append(longAdd(firstNumber, secondNumber));
    }

    /**
     * Checking if the data type - int. If so - add operation.
     *
     * @param handler DataHandler object for checking.
     * @param result  StringBuilder object for result's formation.
     */
    private void intCheckAndAdd(DataHandler handler, StringBuilder result) {
        int firstNumber = Integer.parseInt(handler.getNumbers().get(0));
        int secondNumber = Integer.parseInt(handler.getNumbers().get(1));
        result.append(intAdd(firstNumber, secondNumber));
    }

    /**
     * Method for addition int numbers.
     *
     * @param first  int first summand.
     * @param second int second summand.
     * @return String result of int addition.
     */
    @Override
    public String intAdd(int first, int second) {
        int result = first + second;
        String textResult = first + "+" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for addition long numbers.
     *
     * @param first  long first summand.
     * @param second long second summand.
     * @return String result of int addition.
     */
    @Override
    public String longAdd(long first, long second) {
        long result = first + second;
        String textResult = first + "+" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for addition float numbers.
     *
     * @param first  float first summand.
     * @param second float second summand.
     * @return String result of int addition.
     */
    @Override
    public String floatAdd(float first, float second) {
        float result = first + second;
        String textResult = first + "+" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for addition double numbers.
     *
     * @param first  double first summand.
     * @param second double second summand.
     * @return String result of int addition.
     */
    @Override
    public String doubleAdd(double first, double second) {
        double result = first + second;
        String textResult = first + "+" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for subtraction int numbers.
     *
     * @param first  int minuend number.
     * @param second int subtrahend number.
     * @return String result of int subtraction.
     */
    @Override
    public String intSubtract(int first, int second) {
        int result = first - second;
        String textResult = first + "-" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for subtraction long numbers.
     *
     * @param first  long minuend number.
     * @param second long subtrahend number.
     * @return String result of int subtraction.
     */
    @Override
    public String longSubtract(long first, long second) {
        long result = first - second;
        String textResult = first + "-" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for subtraction float numbers.
     *
     * @param first  float minuend number.
     * @param second float subtrahend number.
     * @return String result of int subtraction.
     */
    @Override
    public String floatSubtract(float first, float second) {
        float result = first - second;
        String textResult = first + "-" + second + "=" + result;
        return textResult;
    }

    /**
     * Method for subtraction double numbers.
     *
     * @param first double minuend number.
     * @param second double subtrahend number.
     * @return String result of int subtraction.
     */
    @Override
    public String doubleSubtract(double first, double second) {
        double result = first - second;
        String textResult = first + "-" + second + "=" + result;
        return textResult;
    }
}
