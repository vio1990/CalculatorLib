package com.ozerian.lib.calculator.interfaces;

import java.util.ArrayList;

public interface DataType<T> {

    public <T> ArrayList<T> tryParse(ArrayList<String> operands);
}
