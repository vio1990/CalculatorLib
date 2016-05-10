package com.ozerian.lib.calculator.util;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is created for possibility to add new math operations.
 */
public final class OperationRegister {

    /**
     * Private constructor for impossibility to create new class object.
     */
    private OperationRegister() {
    }

    private static Map<String, CalculatorOperation> operations = new HashMap<>();

    /**
     * Addition a new math operation.
     *
     * @param operator      String operator. For example, "+", "-", "/", "*" etc.
     * @param mathOperation CalculatorOperation object with the logic of adding math operation.
     */
    public static void addOperation(String operator, CalculatorOperation mathOperation) {
        operations.put(operator, mathOperation);
    }

    /**
     * This method returns the HashMap with supported operations.
     *
     * @return Map with supported operations.
     */
    public static Map<String, CalculatorOperation> getOperations() {
        return operations;
    }
}
