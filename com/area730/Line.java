package com.area730;

/**
 * Created by Andrew on 29.09.2015.
 */
public class Line {

    private int a;
    private int b;
    private int c;

    public Line(Point a1, Point b1)
    {
        a = a1.getY() - b1.getY();
        b = a1.getX() - b1.getX();
        c = (-a) * a1.getX() - b * a1.getY();

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
