package com.ozerian.lib.calculator.utilClasses;

import com.ozerian.lib.calculator.interfaces.Addition;

public final class FloatAddition implements Addition<Float> {

    @Override
    public void addition(Float firstNumber, Float secondNumber) {
        float result = firstNumber + secondNumber;
    }
}
