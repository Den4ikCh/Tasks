package ru.vsu.chuprikov.task3;

public class Circle {
    double _r;
    double _x0;
    double _y0;

    public Circle(double x0, double y0, double r) {
        _r = r;
        _x0 = x0;
        _y0 = y0;
    }

    public boolean isPointInside(double x, double y) {
        return Math.pow((x - _x0), 2) + Math.pow((y - _y0), 2) < Math.pow(_r, 2);
    }
}
