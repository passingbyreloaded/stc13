package ru.innopolis.stc13.objects;

import java.io.Serializable;

public class Point implements Serializable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
