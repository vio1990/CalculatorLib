package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;

import java.util.ArrayList;

public final class DataHandler {

    private String operationFlag;
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
            } else if (inputUnit == '.' || inputUnit == ',') {
                tempNumber.append(inputUnit);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }

        }

        numbers.add(tempNumber.toString());

        checkingDataCorrectness(numbers, checkOperator);

    }

    public String numbersTypeCheck(ArrayList<String> numbers) {
        String firstNumber = numbers.get(0);
        String secondNumber = numbers.get(1);
        String numberTypes;

        try {
            int firstInt = Integer.parseInt(firstNumber);
            int secondInt = Integer.parseInt(secondNumber);
            numberTypes = "int";
        } catch (NumberFormatException e) {
            numberTypes = null;
        }

        try {
            long firstLong = Long.parseLong(firstNumber);
            long secondLong = Long.parseLong(secondNumber);
            numberTypes = "long";
        } catch (NumberFormatException e) {
            numberTypes = null;
        }

        try {
            float firstFloat = Float.parseFloat(firstNumber);
            float secondFloat = Float.parseFloat(secondNumber);
            numberTypes = "float";
        } catch (NumberFormatException e) {
            numberTypes = null;
        }

        try {
            double firstDouble = Double.parseDouble(firstNumber);
            double secondDouble = Double.parseDouble(secondNumber);
            numberTypes = "double";
        } catch (NumberFormatException e) {
            numberTypes = null;
        }

        return numberTypes;
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
}