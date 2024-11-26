package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import org.example.calculator.tokens.Token.*;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class RightOperandState implements CalculatorState, Token.Visitor<CalculatorState, CalculatorModel> {
    private final CalculatorState state;

    @Override
    public final CalculatorState processInput(final CalculatorModel calculator, final Token token) {
        return token.accept(calculator, this);
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Zero token) {
        calculator.appendToRightOperand(token.toString());
        return new RightOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final NaturalDigit token) {
        calculator.appendToRightOperand(token.toString());
        return new RightOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Point token) {
        calculator.appendToRightOperand(token.toString());
        return new RightOperandState(state.processInput(calculator, token));
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Operation token) {
        calculator.setOperation(token);
        return this;
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Result token) {
        calculator.getLeftOperand().setValue(calculator.solve());
        return new InitialState();
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Clear token) {
        return state.processInput(calculator, token);
    }

}