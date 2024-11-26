package org.example.calculator.model;

import org.example.calculator.tokens.Token;

public interface CalculatorState {
    public abstract CalculatorState processInput(final CalculatorModel calculator, final Token token);
}
