package com.ozerian.lib.calculator.util;

import java.util.ArrayList;

/**
 * Class for parsing input string to double type value.
 */
public class Parser {

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
}
