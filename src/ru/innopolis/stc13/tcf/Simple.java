package ru.innopolis.stc13.tcf;

import ru.innopolis.stc13.exceptions.Calculator;

public class Simple {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(6, 3));
    }
}
