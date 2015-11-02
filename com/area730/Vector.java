package com.area730;

/**
 * Created by Andrew on 22.09.2015.
 */
public class Vector {

    private int x;
    private int y;

    private double vecLength;



    Vector(Point a, Point b)
    {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();

        setLength(x, y);


    }



    private void setLength(int x, int y)
    {
        vecLength = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getVecLength() {
        return vecLength;
    }


}

