package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for multiplication different number types.
 * User can add another type of data.
 */
public interface CalculatorMultiplication {

    /**
     * This method multiplies one number by another (for int data type).
     * @param first int first multiplier.
     * @param second int second multiplier.
     * @return String with result of multiplication.
     */
    public String intMultiply(int first, int second);

    /**
     * This method multiplies one number by another (for long data type).
     * @param first long first multiplier.
     * @param second long second multiplier.
     * @return String with result of multiplication.
     */
    public String longMultiply(long first, long second);

    /**
     * This method multiplies one number by another (for float data type).
     * @param first float first multiplier.
     * @param second float second multiplier.
     * @return String with result of multiplication.
     */
    public String floatMultiply(float first, float second);

    /**
     * This method multiplies one number by another (for double data type).
     * @param first double first multiplier.
     * @param second double second multiplier.
     * @return String with result of multiplication.
     */
    public String doubleMultiply(double first, double second);

}
