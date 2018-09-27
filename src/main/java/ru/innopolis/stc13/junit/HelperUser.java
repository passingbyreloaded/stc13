package ru.innopolis.stc13.junit;

public class HelperUser {

    private Helper helper;

    public HelperUser(Helper helper) {
        this.helper = helper;
    }

    public Integer helperUserMethod(Integer a, Integer b) {
        return helper.someHelperMethod(((a + 10) - b), b * 12);
    }
}
