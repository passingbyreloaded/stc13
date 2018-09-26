package ru.innopolis.stc13.generics.box;

public class IntegerBox {

    private Integer value;

    public IntegerBox(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
