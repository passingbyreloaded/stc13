package ru.innopolis.stc13.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String country = "...";
        TaxCalculator taxCalculator = null;
        switch (country) {
            case "Russia":
                taxCalculator = summ -> summ * 0.13;
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.forEach(System.out::println);

        System.out.println("message from t1");
        new Thread(() -> System.out.println("message from t2")).start();
    }
}
