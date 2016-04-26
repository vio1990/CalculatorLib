package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.NotSupportedException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;
import com.ozerian.lib.calculator.interfaces.CalculatorOperation;
import com.ozerian.lib.calculator.util.DataParser;
import com.ozerian.lib.calculator.util.NumberAddition;
import com.ozerian.lib.calculator.util.NumberSubtraction;
import com.ozerian.lib.calculator.util.OperationFactory;

/**
 * Util Class for calculation different math operations with different types of data.
 * There is possibility to add new supported math operations and data types in library
 * through implementation of appropriate interfaces.
 * There is possibility to add new supported operations in application, in which this library
 * would be used.
 * This calculator supports basic operations, such as Addition and Subtraction.
 */
public final class Calculator {

    private OperationFactory supportedOperation = new OperationFactory();

    private DataParser parser = new DataParser(supportedOperation);

    private NumberAddition numberAddition = new NumberAddition(parser, supportedOperation);
    private NumberSubtraction numberSubtraction = new NumberSubtraction(parser, supportedOperation);

    /**
     * This method handles an input data, calculates and returns the result.
     *
     * @param inputExpression String with math expression.
     * @return String with total result of the operation.
     * @throws WrongInputDataException     Throws when there are problems with input data initially.
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     * @throws NotSupportedException       Throws when there are attempt to use not supported operation.
     */
    public String calculatorExecute(String inputExpression) throws WrongInputDataException, IncorrectInputDataException, NotSupportedException {
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
     * @throws NotSupportedException       Throws when there are attempt to use not supported operation.
     * @throws IncorrectInputDataException Throws when there are problems with input data after some methods
     *                                     and operations.
     */
    public void operatorCheckAndOperate(DataParser parser, StringBuilder result) throws NotSupportedException, IncorrectInputDataException {
        if (supportedOperation.getOperations().containsKey(parser.getOperationFlag())) {
            CalculatorOperation mathOperation = this.supportedOperation.getOperations().get(parser.getOperationFlag());
            mathOperation.calculate();
            result.append(mathOperation.getOperationResult());
        } else {
            throw new NotSupportedException("This math operation is not supported!");
        }
    }

    /**
     * Method returns OperationFactory for possibility to check supported operations.
     *
     * @return OperationFactory object.
     */
    public OperationFactory getSupportedOperation() {
        return supportedOperation;
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
