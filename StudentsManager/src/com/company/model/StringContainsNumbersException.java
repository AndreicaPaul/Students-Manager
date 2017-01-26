package com.company.model;

/**
 * Created by Paul on 26-Jan-17.
 */
public class StringContainsNumbersException extends Exception {
    //Parameterless Constructor
    public StringContainsNumbersException() {}

    //Constructor that accepts a message
    public StringContainsNumbersException(String message)
    {
        super(message);
    }
}
