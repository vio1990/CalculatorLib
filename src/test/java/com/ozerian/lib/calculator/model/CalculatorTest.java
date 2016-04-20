package com.ozerian.lib.calculator.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    @Test
    public void testCalculatorExecutionInt() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecution("53+15");
        String expected = "53+15=68";
        assertEquals(actual,expected);
    }

    @Test
    public void testCalculatorExecutionFloat() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecution("53.5+15");
        String expected = "53.5+15.0=68.5";
        assertEquals(actual,expected);
    }

    @Test
    public void testCalculatorExecutionIntMinus() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecution("53-15");
        String expected = "53-15=38";
        assertEquals(actual,expected);
    }

    @Test
    public void testCalculatorExecutionIntMinusVersa() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.calculatorExecution("15-53");
        String expected = "15-53=-38";
        assertEquals(actual,expected);
    }
}