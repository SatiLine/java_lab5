package org.example.wordshifter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;

public final class WordShifterModel {
    @Getter
    private final BooleanProperty shiftToSecond = new SimpleBooleanProperty(false);
    @Getter
    private final StringProperty firstWord = new SimpleStringProperty("");
    @Getter
    private final StringProperty secondWord = new SimpleStringProperty("");

    public final void shiftWords() {
        shiftToSecond.setValue(!shiftToSecond.getValue());
        final String temp = firstWord.getValue();
        firstWord.setValue(secondWord.getValue());
        secondWord.setValue(temp);
    }
}
