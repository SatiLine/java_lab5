package org.example.calculator.model;

import org.example.calculator.tokens.Token;
import java.math.BigDecimal;
import lombok.Getter;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class CalculatorModel {
    private CalculatorState currentState = new InitialState();
    @Getter
    final StringProperty leftOperand = new SimpleStringProperty("0");
    @Getter
    final ObjectProperty<Token.Operation> operation = new SimpleObjectProperty<>(Token.Operation.NO_OPERATION);
    @Getter
    final StringProperty rightOperand = new SimpleStringProperty("");
    @Getter
    private final StringProperty expression = new SimpleStringProperty("0");

    public CalculatorModel() {
        leftOperand.addListener((ob, oldList, newList) -> {
            expression.setValue(updateExpression());
        });
        operation.addListener((ob, oldList, newList) -> {
            expression.setValue(updateExpression());
        });
        rightOperand.addListener((ob, oldList, newList) -> {
            expression.setValue(updateExpression());
        });
    }

    final void clear() {
        leftOperand.setValue("0");
        operation.setValue(Token.Operation.NO_OPERATION);
        rightOperand.setValue("");
    }

    final void setOperation(final Token.Operation op) {
        operation.setValue(op);
    }

    final void appendToLeftOperand(final String value) {
        leftOperand.setValue(leftOperand.getValue() + value);
    }

    final void appendToRightOperand(final String value) {
        rightOperand.setValue(rightOperand.getValue() + value);
    }

    final void Operand(final String value) {
        rightOperand.setValue(rightOperand.getValue() + value);
    }

    final BigDecimal eval(BigDecimal leftOp, Token.Operation operator, BigDecimal rightOp) throws ArithmeticException {
        return switch (operator) {
            case ADD -> leftOp.add(rightOp);
            case SUBSTRACT -> leftOp.subtract(rightOp);
            case MULTIPLY -> leftOp.multiply(rightOp);
            case DIVIDE -> leftOp.divide(rightOp);
            case NO_OPERATION -> throw new ArithmeticException();
        };
    }

    final String solve() {
        String result = "";
        try {
            BigDecimal leftOp = new BigDecimal(leftOperand.getValue());
            BigDecimal rightOp = new BigDecimal(rightOperand.getValue());
            result = eval(leftOp, operation.getValue(), rightOp).toString();
        }
        catch(Exception e) {
            System.out.print(e);
            result = "Error.";
        }
        clear();
        return result;
    }

    public final String updateExpression() {
        return leftOperand.getValue() + " " + operation.getValue() + " " + rightOperand.getValue();
    }

    public final void processInput(final Token inputToken) {
        currentState = currentState.processInput(this, inputToken);
    }
}
