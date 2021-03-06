package com.ozerian.lib.calculator.util;

import java.util.ArrayList;

/**
 * Class for parsing input string to double type value.
 */
public final class Parser {

    private final int INDEX_OF_FIRST_NUMBER = 0;
    private final int INDEX_OF_SECOND_NUMBER = 1;

    private String operationName;

    private String numberType;

    private String firstNumber;

    private String secondNumber;

    /**
     * Parsing input string to double. Checking every
     * char of input string and change a condition of state
     * machine, depending on the char value.
     *
     * @param inputExpression input string.
     * @return double result of state machine's parsing procedures.
     */
    public void parse(String inputExpression) {
        StateMachine stateMachine = new StateMachine();

        for (int i = 0; i < inputExpression.length(); i++) {
            char charOfInputExpression = inputExpression.charAt(i);
            stateMachine.next(charOfInputExpression);
        }
        operationName = stateMachine.getOperator();
        firstNumber = stateMachine.getNumbers().get(INDEX_OF_FIRST_NUMBER);
        secondNumber = stateMachine.getNumbers().get(INDEX_OF_SECOND_NUMBER);
        numbersTypeCheck(firstNumber, secondNumber);
    }

    /**
     * This method clear all of parser parameters for next executions.
     */
    public void clearData() {
        operationName = null;
        numberType = null;
        firstNumber = null;
        secondNumber = null;
    }

    /**
     * Class with conditions, which are being changed,
     * depending on the input char.
     */
    static class StateMachine {

        /**
         * Change the condition of the State machine, depending on
         * the input char and executing appropriate operations with the char by Parser data.
         *
         * @param charOfInputExpression input char.
         */
        public void next(char charOfInputExpression) {
            currentState = currentState.next(charOfInputExpression, data);
        }

        private State currentState = State.INIT;

        private ParseData data = new ParseData();

        /**
         * Returning the result of parsing.
         *
         * @return double result.
         */
        public String getOperator() {
            String operatorType = null;
            if (currentState == State.VALID_END || currentState == State.NUMBER) {
                operatorType = data.getOperationType();
            }
            return operatorType;
        }

        /**
         * Returning the result of parsing.
         *
         * @return double result.
         */
        public ArrayList<String> getNumbers() {
            ArrayList<String> operatorType = new ArrayList();
            if (currentState == State.VALID_END || currentState == State.NUMBER) {
                data.operandsNumbers.add(data.tempNumber.toString());
                operatorType = data.operandsNumbers;
            } else {
                throw new IllegalArgumentException("Incorrect input data!");
            }
            return operatorType;
        }

        /**
         * Appropriate State machine conditions, depending on input chars.
         */
        public enum State {
            INIT {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    if (partOfExpression - '0' <= 9 && partOfExpression - '0' >= 0) {
                        data.numberForm(partOfExpression);
                        return NUMBER;
                    } else if (partOfExpression == '-' || partOfExpression == '+') {
                        data.numberForm(partOfExpression);
                        return SIGN;
                    } else if (partOfExpression == ' ') {
                        return INIT;
                    }
                    return INVALID_END;
                }
            }, NUMBER {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    if (partOfExpression - '0' <= 9 && partOfExpression - '0' >= 0 || partOfExpression == '.') {
                        data.numberForm(partOfExpression);
                        return NUMBER;
                    } else if (OperationRegister.getOperations().containsKey(String.valueOf(partOfExpression))) {
                        data.operationForm(partOfExpression);
                        data.operandsNumbers.add(data.tempNumber.toString());
                        data.tempNumber = new StringBuilder();
                        return OPERATOR;
                    }
                    return INVALID_END;
                }
            }, VALID_END {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    if (partOfExpression == ' ') {
                        return VALID_END;
                    }
                    return INVALID_END;
                }
            }, INVALID_END {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    return INVALID_END;
                }
            }, SIGN {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    if (partOfExpression - '0' <= 9 && partOfExpression - '0' >= 0) {
                        data.tempNumber.append(partOfExpression);
                        return NUMBER;
                    }
                    return INVALID_END;
                }
            }, OPERATOR {
                @Override
                public State next(char partOfExpression, ParseData data) {
                    if (partOfExpression - '0' <= 9 && partOfExpression - '0' >= 0) {
                        data.numberForm(partOfExpression);
                        return NUMBER;
                    } else if (OperationRegister.getOperations().containsKey(String.valueOf(partOfExpression))) {
                        data.operationForm(partOfExpression);
                        if (OperationRegister.getOperations().containsKey(data.operationType.toString())) {
                            return OPERATOR;
                        } else {
                            data.operationType.deleteCharAt(data.operationType.length() - 1);
                            data.tempNumber.append(partOfExpression);
                            return SIGN;
                        }
                    }
                    return INVALID_END;
                }
            };

            public abstract State next(char partOfExpression, ParseData data);
        }

        /**
         * Class, which generates the result and executes operations
         * with numbers.
         */
        private class ParseData {

            private StringBuilder tempNumber = new StringBuilder();

            private ArrayList<String> operandsNumbers = new ArrayList<>();

            private StringBuilder operationType = new StringBuilder();

            public void numberForm(char partOfNumber) {
                tempNumber.append(partOfNumber);
            }

            public void operationForm(char partOfExpression) {
                operationType.append(partOfExpression);
            }

            public String getOperationType() {
                return operationType.toString();
            }
        }
    }

    /**
     * Method tries to parse input String numbers and defines its type,
     * otherwise it would be exception.
     *
     * @param firstNumber  String first operand.
     * @param secondNumber String second operand.
     */
    public void numbersTypeCheck(String firstNumber, String secondNumber) {

        String numberTypes = new String();
        boolean checkFlag = false;

        if (checkFlag == false) {
            try {
                int firstInt = Integer.valueOf(firstNumber);
                int secondInt = Integer.valueOf(secondNumber);
                numberTypes = "int";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                long firstLong = Long.valueOf(firstNumber);
                long secondLong = Long.valueOf(secondNumber);
                numberTypes = "long";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                float firstFloat = Float.valueOf(firstNumber);
                float secondFloat = Float.valueOf(secondNumber);
                numberTypes = "float";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (checkFlag == false) {
            try {
                double firstDouble = Double.valueOf(firstNumber);
                double secondDouble = Double.valueOf(secondNumber);
                numberTypes = "double";
                checkFlag = true;
            } catch (NumberFormatException e) {
                numberTypes = null;
            }
        }

        if (numberTypes == null) {
            throw new NumberFormatException();
        }
        numberType = numberTypes;
    }

    /**
     * Method returns the value of the math operator of the input expression.
     *
     * @return String appropriate value of the class field operation Flag.
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Method shows participants' data type.
     *
     * @return String with data type.
     */
    public String getNumberType() {
        return numberType;
    }

    /**
     * Method returns first operand.
     *
     * @return String first participants of math operation.
     */
    public String getFirstNumber() {
        return firstNumber;
    }

    /**
     * Method returns second operand.
     *
     * @return String second participants of math operation.
     */
    public String getSecondNumber() {
        return secondNumber;
    }
}
