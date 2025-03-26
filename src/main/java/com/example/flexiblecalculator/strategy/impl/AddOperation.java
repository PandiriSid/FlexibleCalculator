package com.example.flexiblecalculator.strategy.impl;

import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class AddOperation implements OperationStrategy {

    @Override
    public Operation getOperation() {
        return Operation.ADD;
    }

    @Override
    public double apply(double a, double b) {
        return a+b;
    }
}
