package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class DataParserTest {
    @Test
    public void testNumbersTypeCheckInt() throws Exception {
        DataParser handler = new DataParser();
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("2");
        numbers.add("3");
        handler.numbersTypeCheck(numbers);
        String actual = handler.getNumberType();
        String expected = "int";
        assertEquals(actual, expected);
    }

    @Test
    public void testNumbersTypeCheckFloat() throws Exception {
        DataParser handler = new DataParser();
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("2.1");
        numbers.add("3");
        handler.numbersTypeCheck(numbers);
        String actual = handler.getNumberType();
        String expected = "float";
        assertEquals(actual, expected);
    }

    @Test
    public void testHandlingInputDataInteger() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("375+271");
        ArrayList actual = handler.getNumbers();
        ArrayList expected = new ArrayList();
        expected.add("375");
        expected.add("271");
        assertEquals(actual, expected);
    }

    @Test
    public void testHandlingInputDataDouble() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("375.4+271.5");
        ArrayList actual = handler.getNumbers();
        ArrayList expected = new ArrayList();
        expected.add("375.4");
        expected.add("271.5");
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionOneMoreOperator() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("375.4+271.5+");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionNotEnoughNumbers() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("375.4+");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionNotEnoughNumbersAndOperators() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("375.4");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataLetters() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("sdfasdf");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionWrongDataEmpty() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling("");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataOnlySpace() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling(" ");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataNumbersAndLetters() throws Exception {
        DataParser handler = new DataParser();
        handler.inputDataHandling(" sdf 4654 + 1df");
    }
}