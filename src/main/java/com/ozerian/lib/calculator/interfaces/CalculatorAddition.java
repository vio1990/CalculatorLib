package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for addition different number types.
 * User can add another type of data.
 */
public interface CalculatorAddition {

    /**
     * This method adds one number to another (for int data type).
     * @param first int first summand.
     * @param second int second summand.
     * @return String with result of addition.
     */
    public String intAdd(int first, int second);

    /**
     * This method adds one number to another (for long data type).
     * @param first long first summand.
     * @param second long second summand.
     * @return String with result of addition.
     */
    public String longAdd(long first, long second);

    /**
     * This method adds one number to another (for float data type).
     * @param first float first summand.
     * @param second float second summand.
     * @return String with result of addition.
     */
    public String floatAdd(float first, float second);

    /**
     * This method adds one number to another (for double data type).
     * @param first double first summand.
     * @param second double second summand.
     * @return String with result of addition.
     */
    public String doubleAdd(double first, double second);



}
