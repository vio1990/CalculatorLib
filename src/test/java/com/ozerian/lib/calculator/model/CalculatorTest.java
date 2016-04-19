package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testHandlingInputDataInteger() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375+271");
        ArrayList expected = new ArrayList();
        expected.add("375");
        expected.add("271");
        assertEquals(actual, expected);
    }

    @Test
    public void testHandlingInputDataDouble() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375.4+271.5");
        ArrayList expected = new ArrayList();
        expected.add("375.4");
        expected.add("271.5");
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionOneMoreOperator() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375.4+271.5+");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionNotEnoughNumbers() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375.4+");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionNotEnoughNumbersAndOperators() throws Exception {
        DataHandler handler = new DataHandler();
        ArrayList actual = handler.inputDataHandling("375.4");
    }
}