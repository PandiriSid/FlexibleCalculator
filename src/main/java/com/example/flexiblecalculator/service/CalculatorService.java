package com.example.flexiblecalculator.service;

import com.example.flexiblecalculator.model.CalculationStep;
import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.naming.OperationNotSupportedException;

@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    private final Map<Operation, OperationStrategy> strategyMap = new HashMap<>();

    public CalculatorService(List<OperationStrategy> strategies){
        for(OperationStrategy strategy: strategies){
            strategyMap.put(strategy.getOperation(), strategy);
        }
        logger.info("calculator initilized with {} strategies", strategies.size());
    }
    public double calculate(Operation operation, double a, double b)throws Exception{
        logger.info("Calculatinog: {} {} {}", a, operation, b);
        OperationStrategy strategy = strategyMap.get(operation);
        if(strategy==null){
            throw new OperationNotSupportedException("Unsupported: "+operation);
        }
        double result = strategy.apply(a,b);
        logger.info("Result: {}",result);
        return result;
    }
    public double calculateChain(double initialValue, List<CalculationStep> steps)throws Exception{
        logger.info("Chaining from initial Value: {}",initialValue);
        double result = initialValue;
        for(CalculationStep step: steps){
            logger.debug("Step: {} {}",step.getOperation(),step.getValue());
            result = calculate(step.getOperation(), result, step.getValue());
        }
        return result;
    }
}
