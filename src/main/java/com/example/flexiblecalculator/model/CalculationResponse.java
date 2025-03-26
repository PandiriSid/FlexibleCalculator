package com.example.flexiblecalculator.model;

public class CalculationResponse {
    private double result;
    public CalculationResponse(double result){
        this.result = result;
    }
    public double getResult(){
        return result;
    }
}
