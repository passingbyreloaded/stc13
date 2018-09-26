package ru.innopolis.stc13.start;

public class Main {

    Main m = new Main();
    Class clazz1 = Animal.class;
    Class clazz2 = m.getClass();

    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats[i] = new Cat("Barsik" + i, 4);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
