package ru.innopolis.stc13.exceptions;

public class Main {

    public static void main(String[] args) {
        double res = 0;
        try {
            res = divider(6, 3);
        } catch (MyArithmeticException e) {
            res = specialCaseFor3(6, 3);
        } finally {
            System.out.println(res);
        }
    }

    static double divider(int a, int b) throws MyArithmeticException {
        if (b % 3 == 0) {
            throw new MyArithmeticException("3");
        } else {
            if (b != 0) {
                return a / b;
            } else {
                return 0;
            }
        }
    }

    static double specialCaseFor3(int a, int b) {
        System.out.println("Some special logic");
        return a / b / 2;
    }
}
