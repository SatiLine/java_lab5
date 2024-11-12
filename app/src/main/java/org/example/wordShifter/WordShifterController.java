package org.example.WordShifter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public final class WordShifterController {
    @FXML
    private TextField topTextField;
    @FXML
    private TextField bottomTextField;
    @FXML
    private Button shiftButton;

    @FXML
    public final void initialize() {
        shiftButton.setText("↓");
        shiftButton.setOnAction(e -> shift());
    }

    private Boolean shiftToBottom = true;

    private final void shift() {
        if(shiftToBottom) shiftBottom();
        else shiftTop();
        shiftToBottom = !shiftToBottom;
    }

    private final void shiftBottom() {
        bottomTextField.setText(topTextField.getText());
        shiftButton.setText("↑");
        topTextField.clear();
    }

    private final void shiftTop() {
        topTextField.setText(bottomTextField.getText());
        shiftButton.setText("↓");
        bottomTextField.clear();
    }
}
