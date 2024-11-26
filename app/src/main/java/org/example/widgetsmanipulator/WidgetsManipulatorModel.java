package org.example.widgetsmanipulator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import lombok.Getter;

public final class WidgetsManipulatorModel {
    @Getter
    private final BooleanProperty firstCheckBoxSelected = new SimpleBooleanProperty(false);
    @Getter
    private final BooleanProperty secondCheckBoxSelected = new SimpleBooleanProperty(false);
    @Getter
    private final BooleanProperty thirdCheckBoxSelected = new SimpleBooleanProperty(false);
}
