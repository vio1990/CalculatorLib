package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.interfaces.CalculatorOperation;
import com.ozerian.lib.calculator.util.DataParser;
import com.ozerian.lib.calculator.util.NumberAddition;
import com.ozerian.lib.calculator.util.NumberSubtraction;
import com.ozerian.lib.calculator.util.OperationRegister;

/**
 * Util Class for calculation different math operations with different types of data.
 * There is possibility to add new supported math operations and data types in library
 * through implementation of appropriate interfaces.
 * There is possibility to add new supported operations in application, in which this library
 * would be used.
 * This calculator supports basic operations, such as Addition and Subtraction.
 */
public final class Calculator {

    private DataParser parser = new DataParser();

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
        parser.inputDataHandling(inputExpression);
        parser.numbersTypeCheck(parser.getStringNumbers());
        operatorCheckAndOperate(parser, totalResult);
        parser.getStringNumbers().clear();
        return totalResult.toString();
    }

    /**
     * Method checks input data through the parser working. After that method calculates and forms the total result.
     *
     * @param parser DataParser for handling the input data.
     * @param result StringBuilder for formation of the total result after calculation.

     */
    public void operatorCheckAndOperate(DataParser parser, StringBuilder result) {
        if (OperationRegister.getOperations().containsKey(parser.getOperationFlag())) {
            CalculatorOperation mathOperation = OperationRegister.getOperations().get(parser.getOperationFlag());
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


            /*mathOperation.calculate();*/


            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            result.append(mathOperation.getOperationResult());
        /*} else {
            throw new NotSupportedException("This math operation is not supported!");*/
        }
    }

    /**
     * Method returns DataParser for possibility to add supported operations
     * and checking input data.
     *
     * @return DataParser object.
     */
    public DataParser getParser() {
        return parser;
    }
}
