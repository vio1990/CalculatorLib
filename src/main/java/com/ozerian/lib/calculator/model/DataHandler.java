package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.WrongInputDataException;

import java.util.ArrayList;

public final class DataHandler {

    private String operationFlag;

    public ArrayList inputDataHandling(String inputData) throws WrongInputDataException {

        StringBuilder tempNumber = new StringBuilder();
        ArrayList<String> operatingNumbers = new ArrayList();

        for (int i = 0; i < inputData.length(); i++) {

            char inputUnit = inputData.charAt(i);

            if (inputUnit - '0' >= 0 && inputUnit - '9' <= 0) {
                tempNumber.append(inputUnit);
            } else if (inputUnit == '+') {
                operationFlag = "plus";
                operatingNumbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '-') {
                operationFlag = "minus";
                operatingNumbers.add(tempNumber.toString());
                tempNumber = new StringBuilder();
            } else if (inputUnit == '.' || inputUnit == ',') {
                tempNumber.append(inputUnit);
            } else {
                throw new WrongInputDataException("Wrong input data!");
            }
        }
        operatingNumbers.add(tempNumber.toString());
        return operatingNumbers;
    }

    public String getOperationFlag() {
        return operationFlag;
    }
}