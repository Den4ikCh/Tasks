package ru.vsu.chuprikov.task10;

public class Triangle {
    private PointDouble pointA;
    private PointDouble pointB;
    private PointDouble pointC;
    private double a;
    private double b;
    private double c;
    private double angleA;
    private double angleB;
    private double angleC;

    public Triangle(PointDouble pointA, PointDouble pointB, PointDouble pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;

        Vector2 AB = new Vector2(pointA, pointB);
        Vector2 BC = new Vector2(pointB, pointC);
        Vector2 AC = new Vector2(pointA, pointC);

        a = BC.length();
        b = AC.length();
        c = AB.length();

        angleA = Vector2.angleBetween(AB, AC);
        angleB = Vector2.angleBetween(AB.getMinus(), BC);
        angleC = Vector2.angleBetween(AC.getMinus(), BC.getMinus());
    }

    public boolean isSimilarToTriangle(Triangle triangle) {
        double[] angles = {angleA, angleB, angleC};
        double[] angles1 = {triangle.angleA, triangle.angleB, triangle.angleC};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.abs(angles[i] - angles1[j]) < 1e-6) {
                    count++;
                    if (count == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public PointDouble getPointA() {
        return pointA;
    }

    public PointDouble getPointB() {
        return pointB;
    }

    public PointDouble getPointC() {
        return pointC;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    @Override
    public String toString() {
        return "{" + pointA + ", " + pointB + ", " + pointC + "}";
    }
}