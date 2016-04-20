package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for division different number types.
 * User can add another type of data.
 */
public interface CalculatorDivision {

    /**
     * This method divides one number by another (for int data type).
     * @param first int first number.
     * @param second int second number.
     * @return String with result of division.
     */
    public String intDivide(int first, int second);

    /**
     * This method divides one number by another (for long data type).
     * @param first long first number.
     * @param second long second number.
     * @return String with result of division.
     */
    public String longDivide(long first, long second);

    /**
     * This method divides one number by another (for float data type).
     * @param first float first number.
     * @param second float second number.
     * @return String with result of division.
     */
    public String floatDivide(float first, float second);

    /**
     * This method divides one number by another (for double data type).
     * @param first double first number.
     * @param second double second number.
     * @return String with result of division.
     */
    public String doubleDivide(double first, double second);

}
