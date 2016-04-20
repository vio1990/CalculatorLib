package com.ozerian.lib.calculator.interfaces;

/**
 * Interface for extracting of root different number types.
 * User can add another type of data.
 */
public interface CalculatorSquareRoot {

    /**
     * Method extracts of root an input number (for int data type).
     * @param number int number for extracting of root.
     * @return String with result.
     */
    public String intSquareRoot(int number);

    /**
     * Method extracts of root an input number (for long data type).
     * @param number long number for extracting of root.
     * @return String with result.
     */
    public String longSSquareRoot(long number);

    /**
     * Method extracts of root an input number (for float data type).
     * @param number float number for extracting of root.
     * @return String with result.
     */
    public String floatSquareRoot(float number);

    /**
     * Method extracts of root an input number (for double data type).
     * @param number double number for extracting of root.
     * @return String with result.
     */
    public String doubleSquareRoot(double number);


}

