package ru.innopolis.stc13.classloaderwithproxy;

public class EuropeanHuman implements Human {
    @Override
    public void eat(String food, int count) {
        System.out.println("i havent eaten " + count + " " + food);
    }

    @Override
    public void sleep(int time) {
        System.out.println("i havent slept for " + time);
    }

    @Override
    public String talk() {
        return "i cant talk";
    }
}
