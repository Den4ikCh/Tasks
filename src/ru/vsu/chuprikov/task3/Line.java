package ru.vsu.chuprikov.task3;

public class Line {
    double _k = 1;
    double _b = 0;

    public Line(double k, double b) {
        _k = k;
        _b = b;
    }

    public boolean isPointAboveLine(double x, double y) {
        return y > _k * x + _b;
    }
}
