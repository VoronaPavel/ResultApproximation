package by.pavel.java;

public abstract class Expression {

    protected final int value;
    protected final String representation;

    protected Expression(int value, String representation) {
        this.value = value;
        this.representation = representation;
    }

    @Override public String toString() {
        return representation;
    }
}
