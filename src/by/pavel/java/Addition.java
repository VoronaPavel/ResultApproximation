package by.pavel.java;

public class Addition extends Expression {

    public Addition(Expression left, Expression right) {
        super(left.value + right.value, left.representation + " + " + right.representation);
    }
}
