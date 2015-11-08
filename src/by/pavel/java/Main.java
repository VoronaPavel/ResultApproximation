package by.pavel.java;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Addition(new Number(3), new Subtraction(new Number(2), new Number(1))).value);
    }
}
