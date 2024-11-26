package org.example.calculator;

import org.example.calculator.model.CalculatorModel;
import org.example.calculator.tokens.Token;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public final class CalculatorController {
    @FXML
    private TextField textField;
    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button pointButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button addButton;
    @FXML
    private Button substractButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button resultButton;

    private final CalculatorModel model = new CalculatorModel();

    private final void initButtons() {
        zeroButton.setOnAction(e -> model.processInput(Token.Zero.ZERO));
        oneButton.setOnAction(e -> model.processInput(Token.NaturalDigit.ONE));
        twoButton.setOnAction(e -> model.processInput(Token.NaturalDigit.TWO));
        threeButton.setOnAction(e -> model.processInput(Token.NaturalDigit.THREE));
        fourButton.setOnAction(e -> model.processInput(Token.NaturalDigit.FOUR));
        fiveButton.setOnAction(e -> model.processInput(Token.NaturalDigit.FIVE));
        sixButton.setOnAction(e -> model.processInput(Token.NaturalDigit.SIX));
        sevenButton.setOnAction(e -> model.processInput(Token.NaturalDigit.SEVEN));
        eightButton.setOnAction(e -> model.processInput(Token.NaturalDigit.EIGHT));
        nineButton.setOnAction(e -> model.processInput(Token.NaturalDigit.NINE));
        pointButton.setOnAction(e -> model.processInput(Token.Point.POINT));
        clearButton.setOnAction(e -> model.processInput(Token.Clear.CLEAR));
        addButton.setOnAction(e -> model.processInput(Token.Operation.ADD));
        substractButton.setOnAction(e -> model.processInput(Token.Operation.SUBSTRACT));
        multiplyButton.setOnAction(e -> model.processInput(Token.Operation.MULTIPLY));
        divideButton.setOnAction(e -> model.processInput(Token.Operation.DIVIDE));
        resultButton.setOnAction(e -> model.processInput(Token.Result.RESULT));
    }

    @FXML
    public final void initialize() {
        initButtons();
        textField.textProperty().bind(model.getExpression());
    }
}
