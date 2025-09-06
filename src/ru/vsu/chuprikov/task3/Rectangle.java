package ru.vsu.chuprikov.task3;

public class Rectangle {
    double _x0;
    double _x1;
    double _y0;
    double _y1;

    public Rectangle(double x0, double y0, double x1, double y1) {
        _x0 = Math.min(x0, x1);
        _x1 = Math.max(x0, x1);
        _y0 = Math.min(y0, y1);
        _y1 = Math.max(y0, y1);
    }

    public boolean isPointInside (double x, double y) {
        return _x0 < x && x < _x1 && _y0 < y && y < _y1;
    }
}
