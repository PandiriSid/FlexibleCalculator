package com.example.flexiblecalculator;
import com.example.flexiblecalculator.model.CalculationStep;
import com.example.flexiblecalculator.model.Operation;
import com.example.flexiblecalculator.service.CalculatorService;
import com.example.flexiblecalculator.strategy.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService(
                List.of(
                        new AddOperation(),
                        new SubtractOperation(),
                        new MultiplyOperation(),
                        new DivideOperation()
                )
        );
    }

    @Test
    void testAddition() throws Exception {
        double result = calculatorService.calculate(Operation.ADD, 5, 3);
        assertEquals(8, result);
    }

    @Test
    void testSubtraction() throws Exception {
        double result = calculatorService.calculate(Operation.SUBTRACT, 10, 4);
        assertEquals(6, result);
    }

    @Test
    void testMultiplication() throws Exception {
        double result = calculatorService.calculate(Operation.MULTIPLY, 4, 2.5);
        assertEquals(10.0, result);
    }

    @Test
    void testDivision() throws Exception {
        double result = calculatorService.calculate(Operation.DIVIDE, 10, 2);
        assertEquals(5.0, result);
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculatorService.calculate(Operation.DIVIDE, 5, 0));
    }

//    @Test
//    void testUnsupportedOperation() {
//        assertThrows(RuntimeException.class, () ->
//                calculatorService.calculate(null, 5, 5));
//    }

    @Test
    void testChainedOperations() throws Exception {
        List<CalculationStep> steps = List.of(
                new CalculationStep() {{
                    setOperation(Operation.ADD);
                    setValue(3);
                }},
                new CalculationStep() {{
                    setOperation(Operation.MULTIPLY);
                    setValue(2);
                }}
        );

        double result = calculatorService.calculateChain(5, steps);
        assertEquals(16.0, result);
    }
}
