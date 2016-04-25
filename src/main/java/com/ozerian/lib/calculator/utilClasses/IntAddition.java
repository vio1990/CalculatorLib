package com.ozerian.lib.calculator.utilClasses;

import com.ozerian.lib.calculator.interfaces.Addition;

public final class IntAddition implements Addition<Integer> {

    @Override
    public void addition(Integer firstNumber, Integer secondNumber) {
        int result = firstNumber + secondNumber;
    }

}
