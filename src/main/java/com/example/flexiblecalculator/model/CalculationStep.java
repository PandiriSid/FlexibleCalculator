package com.example.flexiblecalculator.model;

public class CalculationStep {
    private double value;
    private Operation operation;
    public void setOperation(Operation operation){
        this.operation = operation;
    }
    public Operation getOperation(){
        return operation;
    }
    public void setValue(double value){
        this.value = value;
    }
    public double getValue(){
        return value;
    }
}
