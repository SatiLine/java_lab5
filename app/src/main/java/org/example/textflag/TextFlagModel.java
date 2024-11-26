package org.example.textflag;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;

public class TextFlagModel {
    @RequiredArgsConstructor
    public enum Color {
        RED("Красный"),
        GREEN("Зелёный"),
        BLUE("Синий"),
        WHITE("Белый"),
        BLACK("Чёрный"),
        NULL_COLOR("NULL");

        private final String displayName;

        @Override
        public final String toString() {
            return displayName;
        }

        private static final Map<String, Color> LOOKUP_MAP = Arrays.stream(values())
                .filter(color -> color != Color.NULL_COLOR)
                .collect(Collectors.toMap(color -> color.toString(), color -> color));

        public static final Color getColorByString(final String colorString) {
            return LOOKUP_MAP.getOrDefault(colorString, NULL_COLOR);
        }
    }

    @Getter
    private final ObjectProperty<Color> firstStripeColor = new SimpleObjectProperty<>(Color.RED);
    @Getter
    private final ObjectProperty<Color> secondStripeColor = new SimpleObjectProperty<>(Color.RED);
    @Getter
    private final ObjectProperty<Color> thirdStripeColor = new SimpleObjectProperty<>(Color.RED);

    public final String drawFlag() {
        return firstStripeColor.getValue() + ", " + secondStripeColor.getValue() + ", " + thirdStripeColor.getValue();
    }
}
