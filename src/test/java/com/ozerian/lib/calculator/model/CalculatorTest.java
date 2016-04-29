package com.ozerian.lib.calculator.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    @Test
    public void testCalculatorAdditionInt() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecute("5+3");
        String expected = "5+3=8";
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculatorAdditionFloat() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecute("5.3+3");
        String expected = "5.3+3.0=8.3";
        assertEquals(actual, expected);

    }

    @Test
    public void testCalculatorSubtractionInt() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecute("5-8");
        String expected = "5-8=-3";
        assertEquals(actual, expected);

    }

    @Test
    public void testCalculatorSubtractionBigInt() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecute("4654655-877576");
        String expected = "4654655-877576=3777079";
        assertEquals(actual, expected);
    }

  /*  @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongInputData() throws IncorrectInputDataException, NotSupportedException, WrongInputDataException {
        Calculator calculator = new Calculator();
        calculator.calculatorExecute("65464 - sdf");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionIncorrectData() throws IncorrectInputDataException, NotSupportedException, WrongInputDataException {
        Calculator calculator = new Calculator();
        calculator.calculatorExecute("65464");
    }*/

}