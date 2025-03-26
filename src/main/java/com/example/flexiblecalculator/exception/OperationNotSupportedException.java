package com.example.flexiblecalculator.exception;

public class OperationNotSupportedException extends RuntimeException{
    public OperationNotSupportedException(String message){
        super(message);
    }
}