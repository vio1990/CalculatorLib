package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;
import com.ozerian.lib.calculator.util.NumberAddition;
import com.ozerian.lib.calculator.util.NumberSubtraction;
import com.ozerian.lib.calculator.util.OperationRegister;
import com.ozerian.lib.calculator.util.Parser;

/**
 * Util Class for calculation different math operations with different types of data.
 * There is possibility to add new supported math operations and data types in library
 * through implementation of appropriate interfaces.
 * There is possibility to add new supported operations in application, in which this library
 * would be used.
 * This calculator supports basic operations, such as Addition and Subtraction.
 */
public final class Calculator {

    private Parser parser = new Parser();

    private NumberAddition numberAddition = new NumberAddition(parser);
    private NumberSubtraction numberSubtraction = new NumberSubtraction(parser);

    /**
     * This method handles an input data, calculates and returns the result.
     *
     * @param inputExpression String with math expression.
     * @return String with total result of the operation.
     */
    public String calculatorExecute(String inputExpression) {
        StringBuilder totalResult = new StringBuilder();
        parser.parse(inputExpression);
        parser.numbersTypeCheck(parser.getFirstNumber(), parser.getSecondNumber());
        operatorCheckAndOperate(parser, totalResult);
        parser.clearData();
        return totalResult.toString();
    }

    /**
     * Method checks input data through the parser working. After that method calculates and forms the total result.
     *
     * @param parser DataParser for handling the input data.
     * @param result StringBuilder for formation of the total result after calculation.
     */
    public void operatorCheckAndOperate(Parser parser, StringBuilder result) {
        if (OperationRegister.getOperations().containsKey(parser.getOperationName())) {
            CalculatorOperation mathOperation = OperationRegister.getOperations().get(parser.getOperationName());
            mathOperation.calculate(parser.getFirstNumber(), parser.getSecondNumber());
            result.append(mathOperation.getOperationResult());
        } else {
            throw new UnsupportedOperationException("This math operation is not supported!");
        }
    }

    /**
     * Method returns DataParser for possibility to add supported operations
     * and checking input data.
     *
     * @return DataParser object.
     */
    public Parser getParser() {
        return parser;
    }
}
