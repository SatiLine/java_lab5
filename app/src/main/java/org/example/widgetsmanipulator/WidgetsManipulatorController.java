package org.example.widgetsmanipulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

public final class WidgetsManipulatorController {
    @FXML
    private CheckBox firstCheckBox;
    @FXML
    private CheckBox secondCheckBox;
    @FXML
    private CheckBox thirdCheckBox;
    @FXML
    private Button button;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label label;

    private final WidgetsManipulatorModel model = new WidgetsManipulatorModel();

    @FXML
    public final void initialize() {
        model.getFirstCheckBoxSelected().bind(firstCheckBox.selectedProperty());
        model.getSecondCheckBoxSelected().bind(secondCheckBox.selectedProperty());
        model.getThirdCheckBoxSelected().bind(thirdCheckBox.selectedProperty());
        button.visibleProperty().bind(model.getFirstCheckBoxSelected());
        comboBox.visibleProperty().bind(model.getSecondCheckBoxSelected());
        label.visibleProperty().bind(model.getThirdCheckBoxSelected());
    }
}
