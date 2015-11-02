package com.area730;

/**
 * Created by Andrew on 22.09.2015.
 */
public class Lab2 {

    public static void main(String[] args)
    {
        double vecLengthAB;
        double vecLengthBC;

        float shortDist;

        Point A = new Point(-37, 3);
        Point B = new Point(-29, 11);
        Point C = new Point(-30, 35);
        Point D = new Point(-38, -5);


        shortDist = findShortDist(A, B, C, D);



        System.out.println();

        System.out.println("The shortest way is " + shortDist);

    }

    private static float findShortDist(Point a, Point b, Point c, Point d)
    {
        float result = 0;
        float check1;
        float check2;


        Vector AB = new Vector(a, b);
        Vector AC = new Vector(a, c);
        Vector AD = new Vector(a, d);

        Vector CD = new Vector(c, d);
        Vector CA = new Vector(c, a);
        Vector CB = new Vector(c, b);
        Vector DB = new Vector(d, b);

        check1 = check1(AB, AC, AD);
        check2 = check1(CD, CA, CB);

        if(check1 <= 0 && check2 <= 0)
        {
            float length1;
            float length2;

            length1 = (float) (AC.getVecLength() + CB.getVecLength());
            length2 = (float) (AD.getVecLength() + DB.getVecLength());

            if(length1 <= length2)
            {
                System.out.println("Found a shortest way through crossing vectors. It's " + length1);
                result = length1;
            }

            else
            {
                System.out.println("Found a shortest way through crossing vectors. It's " + length2);
                result = length2;
            }

        }

        else
        {
            System.out.println("Found a shortest way through non-crossing vectors. It's " + (float)AB.getVecLength());
            result = (float)AB.getVecLength();
        }

        return result;
    }

    private static float check1(Vector ab, Vector ac, Vector ad)
    {
        float res;
        res = (cross(ab, ac) * cross(ab, ad));

        return res;
    }



    private static float cross(Vector a, Vector b)
    {
        float res;
        res = a.getX() * b.getY() - b.getX() * a.getY();

        return res;
    }




}
