package com.milley.effective.enumandannotation;

public enum Operation1 {
    PLUS, MINUS, TIMES, DIVIDE;

    // Do the arithemtic operation represented by this constant
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
