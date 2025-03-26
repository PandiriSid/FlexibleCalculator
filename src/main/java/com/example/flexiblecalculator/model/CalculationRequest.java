package com.example.flexiblecalculator.model;
import java.util.*;
public class CalculationRequest {
    private double initialValue;
    private List<CalculationStep> steps;

    public void setInitialValue(double initialValue){
        this.initialValue = initialValue;
    }
    public double getInitialValue(){
        return this.initialValue;
    }
    public void setSteps(List<CalculationStep> steps){
        this.steps = steps;
    }
    public List<CalculationStep> getSteps(){
        return this.steps;
    }
}
