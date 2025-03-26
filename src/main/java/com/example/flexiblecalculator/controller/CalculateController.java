package com.example.flexiblecalculator.controller;

import com.example.flexiblecalculator.model.CalculationRequest;
import com.example.flexiblecalculator.model.CalculationResponse;
import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculateController {

    private static final Logger logger = LoggerFactory.getLogger(CalculateController.class);
    private final CalculatorService calculatorService;

    public CalculateController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    @GetMapping("/basic")
    public ResponseEntity<Double> basicCal(@RequestParam Operation op, @RequestParam double a, @RequestParam double b)throws Exception{
        logger.info("/basic called with {} {} {}", a, op, b);
        return ResponseEntity.ok(calculatorService.calculate(op, a, b));
    }

    @PostMapping("/chain")
    public ResponseEntity<CalculationResponse> chainCalc(@RequestBody CalculationRequest request)throws Exception{
        logger.info("/chain called with initialValue: {}",request.getInitialValue());
        double result = calculatorService.calculateChain(request.getInitialValue(),request.getSteps());
        return ResponseEntity.ok(new CalculationResponse(result));
    }
}
