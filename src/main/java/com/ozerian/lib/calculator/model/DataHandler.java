package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;

import java.util.ArrayList;

public final class DataHandler {

    private String operationFlag;

    public ArrayList inputDataHandling(String inputData) throws WrongInputDataException, IncorrectInputDataException {

        StringBuilder tempNumber = new StringBuilder();
        ArrayList<String> operatingNumbers = new ArrayList();
        boolean checkOperator = false;

        for (int i = 0; i < inputData.length(); i++) {

            char inputUnit = inputData.charAt(i);

            if (inputUnit - '0' >= 0 && inputUnit - '9' <= 0) {
                tempNumber.append(inputUnit);
            } else if (inputUnit == '+' && checkOperator == false) {
                operationFlag = "plus";
                checkOperator = true;
                operatingNumbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '-' && checkOperator == false) {
                operationFlag = "minus";
                checkOperator = true;
                operatingNumbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '.' || inputUnit == ',') {
                tempNumber.append(inputUnit);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }

        }

        operatingNumbers.add(tempNumber.toString());

        checkingDataCorrectness(operatingNumbers, checkOperator);

        return operatingNumbers;
    }

    private void checkingDataCorrectness(ArrayList<String> operatingNumbers, boolean checkOperator) throws IncorrectInputDataException {
        if (operatingNumbers.size() != 2 || operatingNumbers.contains("") || checkOperator == false) {
            throw new IncorrectInputDataException("You've entered incorrect data!");
        }
    }

    public String getOperationFlag() {
        return operationFlag;
    }
}