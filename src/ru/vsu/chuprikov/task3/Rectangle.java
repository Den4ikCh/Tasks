package ru.vsu.chuprikov.task3;

import java.awt.Point;

public class Rectangle {
    double x0;
    double x1;
    double y0;
    double y1;

    public Rectangle(Point p0, Point p1) {
        this.x0 = Math.min(p0.x, p1.x);
        this.x1 = Math.max(p0.x, p1.x);
        this.y0 = Math.min(p0.y, p1.y);
        this.y1 = Math.max(p0.y, p1.y);
    }

    public boolean isPointInside(double x, double y) {
        return x0 < x && x < x1 && y0 < y && y < y1;
    }
}
