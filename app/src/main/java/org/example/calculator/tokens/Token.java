package org.example.calculator.tokens;

import lombok.RequiredArgsConstructor;

public interface Token {
    interface Visitor<T, R> {
        T visit(final R context, final Zero token);
        T visit(final R context, final NaturalDigit token);
        T visit(final R context, final Point token);
        T visit(final R context, final Operation token);
        T visit(final R context, final Result token);
        T visit(final R context, final Clear token);
    }
    public abstract <T, R> T accept(final R calculator, final Visitor<T, R> visitor);

    @RequiredArgsConstructor
    public static enum Zero implements Token {
        ZERO("0");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

    @RequiredArgsConstructor
    public static enum NaturalDigit implements Token {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

    @RequiredArgsConstructor
    public static enum Point implements Token {
        POINT(".");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

    @RequiredArgsConstructor
    public static enum Operation implements Token {
        ADD("+"),
        SUBSTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        NO_OPERATION("");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

    @RequiredArgsConstructor
    public static enum Result implements Token {
        RESULT("=");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

    @RequiredArgsConstructor
    public static enum Clear implements Token {
        CLEAR("C");

        @Override
        public <T, R> T accept(final R context, final Visitor<T, R> visitor) {
            return visitor.visit(context, this);
        }

        @Override
        public String toString() {
            return literal;
        }

        private final String literal;
    }

}
