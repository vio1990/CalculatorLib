package com.ozerian.lib.calculator.utilClasses;

import com.ozerian.lib.calculator.interfaces.Addition;

public final class DoubleAddition implements Addition<Double> {

    @Override
    public void addition(Double firstNumber, Double secondNumber) {
        double result = firstNumber + secondNumber;
    }
}
