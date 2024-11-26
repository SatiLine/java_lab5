package org.example.wordshifter;

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

    private final WordShifterModel model = new WordShifterModel();

    @FXML
    public final void initialize() {
        topTextField.disableProperty().bind(model.getShiftToSecond());
        topTextField.textProperty().bindBidirectional(model.getFirstWord());
        bottomTextField.textProperty().bindBidirectional(model.getSecondWord());
        bottomTextField.disableProperty().bind(model.getShiftToSecond().not());
        model.getShiftToSecond().addListener((object, oldValue, newValue) -> {
            shiftButton.setText((newValue) ? "↑" : "↓");
        });
        shiftButton.setOnAction(e -> model.shiftWords());
    }

}
