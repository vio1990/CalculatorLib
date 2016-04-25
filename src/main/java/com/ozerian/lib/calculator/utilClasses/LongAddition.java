package com.ozerian.lib.calculator.utilClasses;

import com.ozerian.lib.calculator.interfaces.Addition;

public class LongAddition implements Addition<Long> {

    @Override
    public void addition(Long firstNumber, Long secondNumber) {
        long result = firstNumber + secondNumber;
    }
}
