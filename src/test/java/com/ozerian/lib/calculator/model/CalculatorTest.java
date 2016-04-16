package com.ozerian.lib.calculator.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testHandleAndCalculate() throws Exception {
        Calculator calculator = new Calculator();
        String actual = calculator.handleAndCalculate("5+3");
        String expected = "8";
        assertEquals(actual, expected);
    }
}