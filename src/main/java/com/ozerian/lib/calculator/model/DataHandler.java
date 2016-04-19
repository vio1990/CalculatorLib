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