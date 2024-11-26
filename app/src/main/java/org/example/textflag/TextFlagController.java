package org.example.textflag;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public final class TextFlagController {
    @FXML private RadioButton redRadioButton1;
    @FXML private RadioButton greenRadioButton1;
    @FXML private RadioButton blueRadioButton1;
    @FXML private RadioButton whiteRadioButton1;
    @FXML private RadioButton blackRadioButton1;

    @FXML private RadioButton redRadioButton2;
    @FXML private RadioButton greenRadioButton2;
    @FXML private RadioButton blueRadioButton2;
    @FXML private RadioButton whiteRadioButton2;
    @FXML private RadioButton blackRadioButton2;

    @FXML private RadioButton redRadioButton3;
    @FXML private RadioButton greenRadioButton3;
    @FXML private RadioButton blueRadioButton3;
    @FXML private RadioButton whiteRadioButton3;
    @FXML private RadioButton blackRadioButton3;

    @FXML private ToggleGroup firstGroup;
    @FXML private ToggleGroup secondGroup;
    @FXML private ToggleGroup thirdGroup;

    @FXML private Button drawButton;

    private final TextFlagModel model = new TextFlagModel();

    private final void initRadioButtons() {
        redRadioButton1.setUserData(TextFlagModel.Color.RED);
        greenRadioButton1.setUserData(TextFlagModel.Color.GREEN);
        blueRadioButton1.setUserData(TextFlagModel.Color.BLUE);
        whiteRadioButton1.setUserData(TextFlagModel.Color.WHITE);
        blackRadioButton1.setUserData(TextFlagModel.Color.BLACK);

        redRadioButton2.setUserData(TextFlagModel.Color.RED);
        greenRadioButton2.setUserData(TextFlagModel.Color.GREEN);
        blueRadioButton2.setUserData(TextFlagModel.Color.BLUE);
        whiteRadioButton2.setUserData(TextFlagModel.Color.WHITE);
        blackRadioButton2.setUserData(TextFlagModel.Color.BLACK);

        redRadioButton3.setUserData(TextFlagModel.Color.RED);
        greenRadioButton3.setUserData(TextFlagModel.Color.GREEN);
        blueRadioButton3.setUserData(TextFlagModel.Color.BLUE);
        whiteRadioButton3.setUserData(TextFlagModel.Color.WHITE);
        blackRadioButton3.setUserData(TextFlagModel.Color.BLACK);
    }

    private final void draw() {
        Alert resultFlag = new Alert(AlertType.INFORMATION);
        resultFlag.setTitle("Flag");
        resultFlag.setHeaderText(null);
        resultFlag.setContentText(model.drawFlag());
        resultFlag.showAndWait();
    }

    @FXML
    public final void initialize() {
        initRadioButtons();
        firstGroup.selectedToggleProperty().addListener((ob, oldToggle, newToggle) -> {
            model.getFirstStripeColor().setValue(TextFlagModel.Color.getColorByString(newToggle.getUserData().toString()));
        });
        secondGroup.selectedToggleProperty().addListener((ob, oldToggle, newToggle) -> {
            model.getSecondStripeColor().setValue(TextFlagModel.Color.getColorByString(newToggle.getUserData().toString()));
        });
        thirdGroup.selectedToggleProperty().addListener((ob, oldToggle, newToggle) -> {
            model.getThirdStripeColor().setValue(TextFlagModel.Color.getColorByString(newToggle.getUserData().toString()));
        });
        drawButton.setOnAction(e -> draw());
    }


}
