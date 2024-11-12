package org.example.widgetsManipulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

public final class WidgetsManipulatorController {
    @FXML
    private CheckBox topCheckBox;
    @FXML
    private CheckBox centerCheckBox;
    @FXML
    private CheckBox bottomCheckBox;
    @FXML
    private Button button;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label label;

    @FXML
    public final void initialize() {
        topCheckBox.setOnAction(e -> button.setVisible(topCheckBox.isSelected()));
        centerCheckBox.setOnAction(e -> comboBox.setVisible(centerCheckBox.isSelected()));
        bottomCheckBox.setOnAction(e -> label.setVisible(bottomCheckBox.isSelected()));
    }
}
