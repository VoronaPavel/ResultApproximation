package by.pavel.java;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println(new Addition(new Number(3), new Subtraction(new Number(2), new Number(1))));
    }
}
