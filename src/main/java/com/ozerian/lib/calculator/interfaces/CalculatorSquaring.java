package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for squaring different number types.
 * User can add another type of data.
 */
public interface CalculatorSquaring {

    /**
     * Method squares an input number (for int data type).
     * @param number int number for squaring.
     * @return String with result.
     */
    public String intSquared(int number);

    /**
     * Method squares an input number (for long data type).
     * @param number long number for squaring.
     * @return String with result.
     */
    public String longSquared(long number);

    /**
     * Method squares an input number (for float data type).
     * @param number float number for squaring.
     * @return String with result.
     */
    public String floatSquared(float number);

    /**
     * Method squares an input number (for double data type).
     * @param number double number for squaring.
     * @return String with result.
     */
    public String doubleSquared(double number);


}
