package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.interfaces.CalculatorAdditon;
import com.ozerian.lib.calculator.interfaces.CalculatorSubstraction;

public final class Calculator implements CalculatorAdditon, CalculatorSubstraction {

    public void handleInputData(String inputData) {

        int number = 0;
        int firstNumber = 0;
        int secondNumber = 0;
        String operationIndicator = null;

        for (int i = 0; i < inputData.length(); i++) {

            char inputUnit = inputData.charAt(i);

            if (inputUnit - '0' >= 0 && inputUnit - '9' <= 0) {
                number = number * 10 + Character.getNumericValue(inputUnit);
            } else if (inputUnit == '+') {
                operationIndicator = "plus";
                firstNumber = number;
                number = 0;
            } else if (inputUnit == '-') {
                operationIndicator = "minus";
                firstNumber = number;
                number = 0;
            } else if (inputUnit == '.' || inputUnit == ',') {

            } else {
                // throw new Exception
            }
        }
        secondNumber = number;
        number = 0;

        if ("plus".equals(operationIndicator)) {
            add();
        }
    }

    @Override
    public String add() {
        return null;
    }

    @Override
    public String substract() {
        return null;
    }
}