package by.pavel.java;

public class Number extends Expression {

    public Number(int value) {
        super(value, String.valueOf(value));
    }
}
