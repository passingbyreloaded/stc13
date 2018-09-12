package ru.innopolis.stc13.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> l = new ArrayList<>();
        l.add(12);
        l.add(13);
        dump(l);

        List<Integer> l2 = new ArrayList<>();
        l2.add(14);
        l2.add(15);
        dump(l2);
    }

    static void dump(Collection<?> c) {
        for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
            Object o = i.next();
            System.out.println(o);
        }
    }
}
