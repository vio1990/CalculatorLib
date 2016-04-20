package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;

import java.util.ArrayList;

public final class DataHandler {

    private String operationFlag;

    private String numberType;

    private ArrayList<String> numbers = new ArrayList<>();

    public void inputDataHandling(String inputData) throws WrongInputDataException, IncorrectInputDataException {

        StringBuilder tempNumber = new StringBuilder();
        boolean checkOperator = false;

        for (int i = 0; i < inputData.length(); i++) {

            char inputUnit = inputData.charAt(i);

            if (inputUnit - '0' >= 0 && inputUnit - '9' <= 0) {
                tempNumber.append(inputUnit);
            } else if (inputUnit == '+' && checkOperator == false) {
                operationFlag = "plus";
                checkOperator = true;
                numbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '-' && checkOperator == false) {
                operationFlag = "minus";
                checkOperator = true;
                numbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '.') {
                tempNumber.append(inputUnit);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }

        }

        numbers.add(tempNumber.toString());

        checkingDataCorrectness(numbers, checkOperator);

    }

    public void numbersTypeCheck(ArrayList<String> numbers) {

        String firstNumber = numbers.get(0);
        String secondNumber = numbers.get(1);
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

    private void checkingDataCorrectness(ArrayList<String> operatingNumbers, boolean checkOperator) throws IncorrectInputDataException {
        if (operatingNumbers.size() != 2 || operatingNumbers.contains("") || checkOperator == false) {
            throw new IncorrectInputDataException("You've entered incorrect data!");
        }
    }

    public String getOperationFlag() {
        return operationFlag;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public String getNumberType() {
        return numberType;
    }
}