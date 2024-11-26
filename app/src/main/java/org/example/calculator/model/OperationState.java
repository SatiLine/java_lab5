package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import org.example.calculator.tokens.Token.*;

public class OperationState implements CalculatorState, Token.Visitor<CalculatorState, CalculatorModel> {
    @Override
    public final CalculatorState processInput(final CalculatorModel calculator, final Token token) {
        return token.accept(calculator, this);
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Zero token) {
        calculator.rightOperand.setValue(token.toString());
        return new RightOperandState(new DecimalState());
    }

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final NaturalDigit token) {
        calculator.rightOperand.setValue(token.toString());
        return new RightOperandState(new IntegerState());
    } 

    @Override
    public final CalculatorState visit(final CalculatorModel calculator, final Point token) {
        calculator.rightOperand.setValue(Zero.ZERO.toString());
        calculator.rightOperand.setValue(token.toString());
        return new RightOperandState(new DecimalState());
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
        return new InitialState();
    }

}