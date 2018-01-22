package com.shukriev.exceptions;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class OrderValidationException extends Exception {

    public OrderValidationException(String exceptionDescription) {
        super("Order validation failed: " + exceptionDescription);
    }
}
