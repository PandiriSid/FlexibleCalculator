package com.example.flexiblecalculator.strategy.impl;

import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements OperationStrategy {

    @Override
    public Operation getOperation() {
        return Operation.DIVIDE;
    }

    @Override
    public double apply(double a, double b) {
        if(b==0){
            throw new ArithmeticException("Division by Zero");
        }
        return a/b;
    }
}
