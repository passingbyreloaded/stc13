package ru.innopolis.stc13.junit;

public class HelperImpl implements Helper {

    @Override
    public Integer someHelperMethod(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        System.out.println(a + "; " + b);
    }
}
