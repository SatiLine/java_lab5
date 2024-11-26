package org.example.mainmenu;

import javafx.application.Platform;
import org.example.wordshifter.WordShifter;
import org.example.widgetsmanipulator.WidgetsManipulator;
import org.example.calculator.Calculator;
import org.example.restaurantmenu.RestaurantMenu;
import org.example.textflag.TextFlag;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public final class MainMenuController {
    @FXML
    private Button taskOneButton;
    @FXML
    private Button taskTwoButton;
    @FXML
    private Button taskThreeButton;
    @FXML
    private Button taskFourButton;
    @FXML
    private Button taskFiveButton;
    @FXML
    private Button exitButton;

    private final WordShifter wordShifter = new WordShifter();
    private final WidgetsManipulator widgetsManipulator = new WidgetsManipulator();
    private final RestaurantMenu restaurantMenu = new RestaurantMenu();
    private final Calculator calculator = new Calculator();
    private final TextFlag textFlag = new TextFlag();

    @FXML
    public final void initialize() {
        taskOneButton.setOnAction(e -> wordShifter.run());
        taskTwoButton.setOnAction(e -> widgetsManipulator.run());
        taskThreeButton.setOnAction(e -> restaurantMenu.run());
        taskFourButton.setOnAction(e -> calculator.run());
        taskFiveButton.setOnAction(e -> textFlag.run());
        exitButton.setOnAction(e -> Platform.exit());
    }
}
