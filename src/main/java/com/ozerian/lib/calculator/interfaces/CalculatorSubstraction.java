package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for subtraction different number types.
 * User can add another type of data.
 */
public interface CalculatorSubstraction {

    /**
     * This method subtracts one number from another (for int data type).
     * @param first int minuend number.
     * @param second int subtrahend number.
     * @return String with result of subtraction.
     */
    public String intSubtract(int first, int second);


    /**
     * This method subtracts one number from another (for long data type).
     * @param first long minuend number.
     * @param second long subtrahend number.
     * @return String with result of subtraction.
     */
    public String longSubtract(long first, long second);

    /**
     * This method subtracts one number from another (for float data type).
     * @param first float minuend number.
     * @param second float subtrahend number.
     * @return String with result of subtraction.
     */
    public String floatSubtract(float first, float second);

    /**
     * This method subtracts one number from another (for double data type).
     * @param first double minuend number.
     * @param second double subtrahend number.
     * @return String with result of subtraction.
     */
    public String doubleSubtract(double first, double second);

}
