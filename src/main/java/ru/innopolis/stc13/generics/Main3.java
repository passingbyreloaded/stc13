package ru.innopolis.stc13.generics;

import java.util.ArrayList;
import java.util.Collection;

public class Main3 {
    public static void main(String[] args) {
        addAll(new ArrayList<String>(), new ArrayList<String>());
        addAll(new ArrayList<Object>(), new ArrayList<Object>());
        addAll(new ArrayList<String>(), new ArrayList<Object>());
    }

    static <M, N extends M> void addAll(Collection<N> collection, Collection<M> collection2) {
        for (M i : collection) {
            collection2.add(i);
        }
    }
}
