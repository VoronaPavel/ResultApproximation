package by.pavel.java;

public class Subtraction extends Expression {

    public Subtraction(Expression left, Expression right) {
        super(left.value - right.value, left.representation + " - " + right.representation);
    }
}
