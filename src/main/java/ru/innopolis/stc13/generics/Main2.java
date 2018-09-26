package ru.innopolis.stc13.generics;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<Line> l = new ArrayList<>();
        l.add(new Line());
        l.add(new Polygon());
        draw(l);
        List<Polygon> l2 = new ArrayList<>();
        l2.add(new Polygon());
        draw(l2);
    }

    private static void draw(List<? extends Line> l) {
        for (Line line : l) {
            line.draw();
        }
    }
}
