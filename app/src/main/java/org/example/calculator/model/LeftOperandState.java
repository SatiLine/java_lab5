package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import org.example.calculator.tokens.Token.*;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class LeftOperandState implements CalculatorState, Token.Visitor<CalculatorState, CalculatorModel> {
    private final CalculatorState state;

    @Override
    public final CalculatorState processInput(final CalculatorModel calculator, final Token token) {
        return token.accept(calculator, this);
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Zero token) {
        calculator.appendToLeftOperand(token.toString());
        return new LeftOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final NaturalDigit token) {
        calculator.appendToLeftOperand(token.toString());
        return new LeftOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Point token) {
        calculator.appendToLeftOperand(token.toString());
        return new LeftOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Operation token) {
        calculator.setOperation(token);
        return new OperationState();
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Result token) {
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Clear token) {
        return state.processInput(calculator, token);
    }

}