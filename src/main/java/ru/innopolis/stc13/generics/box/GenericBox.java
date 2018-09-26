package ru.innopolis.stc13.generics.box;

public class GenericBox<T> {

    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        while (true) ;
    }
}
