package com.ozerian.lib.calculator.model;

import com.ozerian.lib.calculator.exceptions.IncorrectInputDataException;
import com.ozerian.lib.calculator.exceptions.WrongInputDataException;
import com.ozerian.lib.calculator.util.DataParser;
import com.ozerian.lib.calculator.util.NumberAddition;
import com.ozerian.lib.calculator.util.OperationFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class DataParserTest {

    public OperationFactory operationFactory = new OperationFactory();
    DataParser handler = new DataParser(operationFactory);


    @Test
    public void testNumbersTypeCheckInt() throws Exception {
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
        DataParser parser = new DataParser(operationFactory);
        new NumberAddition(parser, operationFactory);
        parser.inputDataHandling("375+271");
        ArrayList actual = parser.getStringNumbers();
        ArrayList expected = new ArrayList();
        expected.add("375");
        expected.add("271");
        assertEquals(actual, expected);
    }

    @Test
    public void testHandlingInputDataDouble() throws Exception {
        DataParser parser = new DataParser(operationFactory);
        new NumberAddition(parser, operationFactory);
        parser.inputDataHandling("375.4+271.5");
        ArrayList actual = parser.getStringNumbers();
        ArrayList expected = new ArrayList();
        expected.add("375.4");
        expected.add("271.5");
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionOneMoreOperator() throws Exception {
        handler.inputDataHandling("375.4+271.5+");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionNotEnoughNumbers() throws Exception {
        handler.inputDataHandling("375.4+");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionNotEnoughNumbersAndOperators() throws Exception {
        handler.inputDataHandling("375.4");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataLetters() throws Exception {
        handler.inputDataHandling("sdfasdf");
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void testExceptionWrongDataEmpty() throws Exception {
        handler.inputDataHandling("");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataOnlySpace() throws Exception {
        handler.inputDataHandling(" ");
    }

    @Test(expectedExceptions = WrongInputDataException.class)
    public void testExceptionWrongDataNumbersAndLetters() throws Exception {
        handler.inputDataHandling(" sdf 4654 + 1df");
    }
}