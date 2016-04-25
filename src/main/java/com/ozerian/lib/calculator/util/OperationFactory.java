package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is created for possibility to add new math operations.
 */
public final class OperationFactory {

    private Map<String, CalculatorOperation> operations = new HashMap<>();

    /**
     * Addition a new math operation.
     * @param operator String operator. For example, "+", "-", "/", "*" etc.
     * @param mathOperation CalculatorOperation object with the logic of adding math operation.
     */
    public void addOperation(String operator, CalculatorOperation mathOperation) {
        operations.put(operator, mathOperation);
    }

    /**
     * This method returns the HashMap with supported operations.
     * @return Map with supported operations.
     */
    public Map<String, CalculatorOperation> getOperations() {
        return operations;
    }
}
