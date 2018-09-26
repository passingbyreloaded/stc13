package ru.innopolis.stc13.exceptions;

public class Calculator {

    public double divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            return 1;
        }
    }
}
