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

    private ArrayList<String> stringNumbers;


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
            operationName = stateMachine.getOperator();
            stringNumbers = stateMachine.getNumbers();
            numbersTypeCheck(stringNumbers);
        }
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
                operatorType = data.operandsNumbers;
            }
            return operatorType;
        }

        /**
         * Appropriate State machine conditions.
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
                        data.tempNumber = new StringBuilder();
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
     * Trying to parse input data to supported data type. In this way
     * if there are no NumberFormatException - parsing is correct.
     *
     * @param numbers ArrayList with participants of the math operation.
     */
    public void numbersTypeCheck(ArrayList<String> numbers) {

        String firstNumber = numbers.get(INDEX_OF_FIRST_NUMBER);
        String secondNumber = numbers.get(INDEX_OF_SECOND_NUMBER);
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
     * Method returns the List with values of the participants of the math operation.
     *
     * @return ArrayList with values of the participants of the math operation..
     */
    public ArrayList<String> getStringNumbers() {
        return stringNumbers;
    }

    /**
     * Method shows participants' data type.
     *
     * @return String with data type.
     */
    public String getNumberType() {
        return numberType;
    }


}
