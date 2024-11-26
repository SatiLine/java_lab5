package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import org.example.calculator.tokens.Token.*;

public final class InitialState implements CalculatorState, Token.Visitor<CalculatorState, CalculatorModel> {
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
        calculator.getLeftOperand().setValue(token.toString());
        return new LeftOperandState(new IntegerState());
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Point token) {
        calculator.getLeftOperand().setValue(Zero.ZERO.toString() + token.toString());
        return new LeftOperandState(new DecimalState());
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
        calculator.clear();
        return this;
    }

}
