package com.ozerian.lib.calculator.model;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testHandleAndCalculateInteger() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375+271");
        ArrayList expected = new ArrayList();
        expected.add("375");
        expected.add("271");
        assertEquals(actual, expected);
    }

    @Test
    public void testHandleAndCalculateDouble() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375.4+271.5");
        ArrayList expected = new ArrayList();
        expected.add("375.4");
        expected.add("271.5");
        assertEquals(actual, expected);
    }
}