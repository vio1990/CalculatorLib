package com.ozerian.lib.calculator.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {

    @Test
    public void testParseFirstOperand() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15+23");
        String actual = parser.getFirstNumber();
        String expected = "15";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseSecondOperand() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15+23");
        String actual = parser.getSecondNumber();
        String expected = "23";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseOperatorTypePlus() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15+23");
        String actual = parser.getOperationName();
        String expected = "+";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseDataTypeInt() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15+23");
        String actual = parser.getNumberType();
        String expected = "int";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseDataTypeFloat() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15.2+23.1");
        String actual = parser.getNumberType();
        String expected = "float";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseDataTypeFloat2() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("15.2+23");
        String actual = parser.getNumberType();
        String expected = "float";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseDataTypeFloat3() throws Exception {
        Parser parser = new Parser();
        NumberAddition numberAddition = new NumberAddition(parser);
        parser.parse("125+23.15");
        String actual = parser.getNumberType();
        String expected = "float";
        assertEquals(actual,expected);
    }

    @Test
    public void testParseOperatorTypeMinus() throws Exception {
        Parser parser = new Parser();
        NumberSubtraction numberSubtraction = new NumberSubtraction(parser);
        parser.parse("15-23");
        String actual = parser.getOperationName();
        String expected = "-";
        assertEquals(actual,expected);
    }
}