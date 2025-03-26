package com.example.flexiblecalculator.strategy.impl;

import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements OperationStrategy {

    public Operation getOperation(){
        return Operation.MULTIPLY;
    }
    public double apply(double a, double b){
        return a*b;
    }
}
