package com.area730;

/**
 * Created by Andrew on 22.09.2015.
 */
public class Point {

    private int x;
    private int y;
    private int z;

    private float xf;
    private float yf;
    private float zf;

    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y)
    {
        this.xf = x;
        this.yf = y;
    }

    public Point(float x,float y, float z)
    {
        this.xf = x;
        this.yf = y;
        this.zf = z;
    }

    public Point(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public float getXf() {
        return xf;
    }

    public float getYf() {
        return yf;
    }

    public float getZf() {
        return zf;
    }
}
