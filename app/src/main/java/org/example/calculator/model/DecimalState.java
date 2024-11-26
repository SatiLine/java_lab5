package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import org.example.calculator.tokens.Token.*;

public final class DecimalState implements CalculatorState, Token.Visitor<CalculatorState, CalculatorModel> {
    @Override
    public final CalculatorState processInput(final CalculatorModel calculator, final Token token) {
        return token.accept(calculator, this);
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Zero token) {
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final NaturalDigit token) {
        return new DecimalState();
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Point token) {
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Operation token) {
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Result token) {
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Clear token) {
        calculator.clear();
        return new InitialState();
    }

}