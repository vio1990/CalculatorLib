package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;

import java.util.ArrayList;

/**
 * Class for handling input math expression.
 * With String operationFlag (parses and shows the operator of math operation).
 * String numberType (shows the type of input data).
 * ArrayList stringNumbers with the participants of the math operation.
 */
public final class DataParser {

    public DataParser(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public static final int INDEX_OF_FIRST_NUMBER = 0;
    public static final int INDEX_OF_SECOND_NUMBER = 1;

    private OperationFactory operationFactory;

    private String operationFlag;

    private String numberType;

    private ArrayList<String> stringNumbers = new ArrayList<>();


    /**
     * Definition of the operator's type and filling the List with participants of
     * the math. operation.
     *
     * @param inputData String with input math expression.
     * @throws WrongInputDataException     Throws when there are problems with input data initially.
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public void inputDataHandling(String inputData) throws WrongInputDataException, IncorrectInputDataException {

        StringBuilder tempNumber = new StringBuilder();

        boolean checkOperator = false;

        for (int i = 0; i < inputData.length(); i++) {

            char inputUnit = inputData.charAt(i);

            if (inputUnit - '0' >= 0 && inputUnit - '9' <= 0) {
                tempNumber.append(inputUnit);
            } else if (operationFactory.getOperations().containsKey(String.valueOf(inputUnit)) && checkOperator == false) {
                operationFlag = String.valueOf(inputUnit);
                checkOperator = true;
                stringNumbers.add(INDEX_OF_FIRST_NUMBER, tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '.') {
                tempNumber.append(inputUnit);
            } else {
                throw new WrongInputDataException("Wrong input data or this math operation is not supported!");
            }
        }

        stringNumbers.add(tempNumber.toString());

        checkingDataCorrectness(stringNumbers, checkOperator);

    }

    /**
     * Trying to parse input data to supported data type. In this way
     * if there are no NumberFormatException - parsing is correct.
     *
     * @param numbers ArrayList with participants of the math operation.
     */
    public void numbersTypeCheck(ArrayList<String> numbers) {

        String firstNumber = numbers.get(INDEX_OF_FIRST_NUMBER);
        String secondNumber = numbers.get(INDEX_OF_SECOND_NUMBER);
        String numberTypes = new String();
        boolean checkFlag = false;

        if (checkFlag == false) {
            try {
                int firstInt = Integer.valueOf(firstNumber);
                int secondInt = Integer.valueOf(secondNumber);
                numberTypes = "int";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                long firstLong = Long.valueOf(firstNumber);
                long secondLong = Long.valueOf(secondNumber);
                numberTypes = "long";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                float firstFloat = Float.valueOf(firstNumber);
                float secondFloat = Float.valueOf(secondNumber);
                numberTypes = "float";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                double firstDouble = Double.valueOf(firstNumber);
                double secondDouble = Double.valueOf(secondNumber);
                numberTypes = "double";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (numberTypes == null) {
            throw new NumberFormatException();
        }
        numberType = numberTypes;
    }

    /**
     * Checking correctness of the data after parsing.
     *
     * @param operatingNumbers ArrayList with the participants of the math operation.
     * @param checkOperator    boolean flag, which shows if there are correct math operator.
     * @throws IncorrectInputDataException throws when there are any problems with the data.
     */
    private void checkingDataCorrectness(ArrayList<String> operatingNumbers, boolean checkOperator) throws IncorrectInputDataException {
        if (operatingNumbers.size() != 2 || operatingNumbers.contains("") || checkOperator == false) {
            throw new IncorrectInputDataException("You've entered incorrect data!");
        }
    }

    /**
     * Method returns the value of the math operator of the input expression.
     *
     * @return String appropriate value of the class field operation Flag.
     */
    public String getOperationFlag() {
        return operationFlag;
    }

    /**
     * Method returns the List with values of the participants of the math operation.
     *
     * @return ArrayList with values of the participants of the math operation..
     */
    public ArrayList<String> getStringNumbers() {
        return stringNumbers;
    }

    /**
     * Method shows participants' data type.
     *
     * @return String with data type.
     */
    public String getNumberType() {
        return numberType;
    }

}