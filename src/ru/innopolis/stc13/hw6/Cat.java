package ru.innopolis.stc13.hw6;

public class Cat {
    public boolean fat;
    private int age;
    private String name;

    public Cat() {
    }

    public Cat(int age, String name, boolean fat) {
        this.age = age;
        this.name = name;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                '}';
    }
}
