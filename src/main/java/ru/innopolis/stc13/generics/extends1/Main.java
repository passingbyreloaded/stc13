package ru.innopolis.stc13.generics.extends1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MyStore<Long, Animal> myStore = new MyStore<>();
        Map<Long, Cat> catMap = new HashMap<>();
        catMap.put(1L, new Cat("Kitty"));
        catMap.put(2L, new Cat("Tom"));
        catMap.put(3L, new Cat("Jasper"));

        myStore.putAll(catMap);
    }
}
