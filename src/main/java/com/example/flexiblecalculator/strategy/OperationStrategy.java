package com.example.flexiblecalculator.strategy;

import com.example.flexiblecalculator.model.Operation;

public interface OperationStrategy {
    Operation getOperation();
    double apply(double a, double b);
}
