package com.area730.Simple.SpiderFly;

import com.area730.Line;
import com.area730.Point;

import java.io.IOException;

import static com.area730.Simple.Print.*;

/**
 * Created by Andrew on 28.09.2015.
 */

public class Main {

    //parametrs of the parallelogram
    private static int dx = 20;
    private static int ly = 10;
    private static int hz = 8;

    // Point A, B
    private static Point A = new Point(2, 0, 4);
    private static Point B = new Point(2, ly, 4);

    private static float resLength;

    Point cross1;
    Point cross2;

    int pathNumber;

    Point d_cross1;
    Point d_cross2;

    Point u_cross1;
    Point u_cross2;

    Point s1_cross1;
    Point s1_cross2;

    Point s2_cross1;
    Point s2_cross2;

    public static void main(String[] args) throws NullPointerException
    {
        Main x = new Main();

        resLength = x.findLength(A, B);

        print(" ");
        print("Shortest way: " + resLength);

        x.printCrossPoints();
    }

    private void printCrossPoints()
    {

        print("PathType: " + pathNumber);
        print(" ");

        if(pathNumber == 1)
        {
            print("The shortest way is through the down side");
            print("Cross Point 1 : A0 (" + this.d_cross1.getXf() + ", 0, 0)");
            print("Cross Point 2 : B0 (" + this.d_cross2.getXf() +", " + ly + ", 0)");
        }

        else if (pathNumber == 2)
        {
            print("The shortest way is through the up side");
            print("Cross Point 1 : A0 (" + this.u_cross1.getXf() + ", 0, " + hz + ")");
            print("Cross Point 2 : B0 (" + this.u_cross2.getXf() +", " + ly + ", " + hz + ")");
        }

        else if (pathNumber == 3)
        {
            print("The shortest way is through the front side");
            print("Cross Point 1 : A0 (" + dx + ", 0, " + s1_cross1.getZf() + ")");
            print("Cross Point 2 : B0 (" + dx +", " + ly + ", " + s1_cross2.getZf() + ")");
        }

        else if (pathNumber == 4)
        {
            print("The shortest way is through the back side");
            print("Cross Point 1 : A0 (0, 0, " +  this.s2_cross1.getZf()+ ")");
            print("Cross Point 2 : B0 (0, " + ly + ", " + this.s2_cross2.getZf() + ")");
        }
        else
        {
            print(pathNumber + " = 0");
        }
    }

    private float findLength(Point a, Point b)
    {
        float finPath = 0;

        int checkPolA = checkPoligon(a);
        int checkPolB = checkPoligon(b);

        if(checkPolA == 0)
        {
            print("Point A is not not situated on sides of the parallelogram");
        }

        else if(checkPolB == 0)
        {
            print("Point B is not not situated on sides of the parallelogram");
        }

        else if((checkPolA == 1) && (checkPolB == 2))
        {
            finPath = findLength12(a, b);
        }

        else if((checkPolA == 2) && (checkPolB == 1))
        {
            finPath = findLength12(b, a);
        }

        print("point A in on the side " + checkPolA);
        print("point B in on the side " + checkPolB);

        return finPath;
    }

    private int checkPoligon(Point testPoint)
    {
        //serial number of a polygon
        int polNumber = 0;

        if((testPoint.getX() <= dx && testPoint.getX() >= 0) && testPoint.getY() == 0 && (testPoint.getZ() <= hz && testPoint.getZ() >= 0))
        {
            polNumber = 1;
        }

        else if((testPoint.getX() >= 0 && testPoint.getX() <= dx) && testPoint.getY() == ly &&(testPoint.getZ() >=0 && testPoint.getZ() <= hz))
        {
            polNumber = 2;
        }

        return polNumber;
    }

    private float findLength12(Point a, Point b)
    {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;

        int num1 = 0;
        int num2 = 0;


        float qf_path1_down = downPath(a, b);
        float qf_path2_up = upPath(a, b);
        float qf_path3_side1 = sidePath1(a, b);
        float qf_path4_side2 = sidePath2(a, b);

        float hf_path1;
        float hf_path2;

        float finalPath;

        if(qf_path1_down <= qf_path2_up)
        {
            hf_path1 = qf_path1_down;
            num1 = n1;
        }
        else{
            hf_path1 = qf_path2_up;
            num1 = n2;
        }

        if(qf_path3_side1 <= qf_path4_side2)
        {
            hf_path2 = qf_path3_side1;
            num2 = n3;
        }
        else{
            hf_path2 = qf_path4_side2;
            num2 = n4;
        }

        if(hf_path1 <= hf_path2)
        {
            finalPath = hf_path1;
            pathNumber = num1;
        }

        else
        {
            finalPath = hf_path2;
            pathNumber = num2;
        }

        return finalPath;
    }

    private float downPath(Point a, Point b )
    {
        float path = 0;


        Point c1xy;
        Point c2xy;

        Point a1 = new Point(a.getX(), -a.getZ());
        Point b1 = new Point(b.getX(), ly + b.getZ());

        Point cross1_a = new Point(0, 0);
        Point cross1_b = new Point(dx, 0);

        Point cross2_a = new Point(0, ly);
        Point cross2_b = new Point(dx, ly);

        Line ab = new Line(a1, b1);
        Line cross1 = new Line(cross1_a, cross1_b);
        Line cross2 = new Line(cross2_a, cross2_b);


        //print("ab : a = " + ab.getA() + ", b = " + ab.getB() + ", c = " + ab.getC() );
        //print("cross1 : a = " + cross1.getA() + ", b = " + cross1.getB() + ", c = " + cross1.getC() );
        //print("cross2 : a = " + cross2.getA() + ", b = " + cross2.getB() + ", c = " + cross2.getC() );
        //print(" ");

        c1xy = findCross(ab, cross1);
        c2xy = findCross(ab, cross2);

        //print("Point1: " + c1xy.getXf() + ", " + c1xy.getYf());
        //print("Point2: " + c2xy.getXf() + ", " + c2xy.getYf());

        d_cross1 = new Point(c1xy.getXf(), 0, 0);
        d_cross2 = new Point(c2xy.getXf(), ly, 0);


        path = (float) Math.sqrt(Math.pow(a.getZ() + ly + b.getZ(), 2) + Math.pow(a.getX() - b.getX(), 2));



        return path;
    }

    private float upPath(Point a, Point b )
    {
        float path = 0;

        Point c1xy;
        Point c2xy;

        Point a1 = new Point(a.getX(), -(hz - a.getZ()));
        Point b1 = new Point(b.getX(), ly + (hz - b.getZ()));

        Point cross1_a = new Point(0, 0);
        Point cross1_b = new Point(dx, 0);

        Point cross2_a = new Point(0, ly);
        Point cross2_b = new Point(dx, ly);

        Line ab = new Line(a1, b1);
        Line cross1 = new Line(cross1_a, cross1_b);
        Line cross2 = new Line(cross2_a, cross2_b);

        c1xy = findCross(ab, cross1);
        c2xy = findCross(ab, cross2);

        u_cross1 = new Point(c1xy.getXf(), 0, hz);
        u_cross2 = new Point(c2xy.getXf(), ly, hz);

        path = (float) Math.sqrt(Math.pow((hz - a.getZ()) + ly + (hz - b.getZ()), 2) + Math.pow(a.getX() - b.getX(), 2));


        return path;
    }

    private float sidePath1(Point a, Point b )
    {
        float path = 0;

        Point c1xy;
        Point c2xy;

        Point a1 = new Point(a.getX(),  a.getZ());
        Point b1 = new Point(dx + ly + (dx - b.getX()), b.getZ());

        Point cross1_a = new Point(dx, 0);
        Point cross1_b = new Point(dx, hz);

        Point cross2_a = new Point(dx + ly, 0);
        Point cross2_b = new Point(dx + ly, hz);

        Line ab = new Line(a1, b1);
        Line cross1 = new Line(cross1_a, cross1_b);
        Line cross2 = new Line(cross2_a, cross2_b);

        c1xy = findCross(ab, cross1);
        c2xy = findCross(ab, cross2);

        s1_cross1 = new Point(dx, 0, c1xy.getYf());
        s1_cross2 = new Point(dx, ly, c2xy.getYf());

        path = (float) Math.sqrt(Math.pow((dx - a.getX()) + ly + (dx - b.getX()), 2) + Math.pow(a.getZ() - b.getZ(), 2));

        return path;
    }

    private float sidePath2(Point a, Point b )
    {
        float path = 0;

        Point c1xy;
        Point c2xy;

        Point a1 = new Point(a.getX(),  a.getZ());
        Point b1 = new Point(-ly - b.getX(), b.getZ());

        Point cross1_a = new Point(0, 0);
        Point cross1_b = new Point(0, hz);

        Point cross2_a = new Point(-ly, 0);
        Point cross2_b = new Point(-ly, hz);

        Line ab = new Line(a1, b1);
        Line cross1 = new Line(cross1_a, cross1_b);
        Line cross2 = new Line(cross2_a, cross2_b);

        c1xy = findCross(ab, cross1);
        c2xy = findCross(ab, cross2);

        s2_cross1 = new Point(0, 0, c1xy.getYf());
        s2_cross2 = new Point(0, ly, c2xy.getYf());

        path = (float) Math.sqrt(Math.pow(a.getX() + ly + b.getX(), 2) + Math.pow(a.getZ() - b.getZ(), 2));

        return path;
    }

    private Point findCross(Line l1, Line l2)
    {
        /*
        print(l1.getA());
        print(l1.getB());
        print(l1.getC());

        print(l2.getA());
        print(l2.getB());
        print(l2.getC());
        */

        float y = (float)(l1.getA() * l2.getC() - l2.getA() * l1.getC()) / (l2.getA() * l1.getB() - l1.getA() * l2.getB());
        float x = (float)  -(l1.getB() * y + l1.getC()) / l1.getA();

        return new Point(x, y);
    }
}
