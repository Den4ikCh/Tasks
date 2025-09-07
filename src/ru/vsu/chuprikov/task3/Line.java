package ru.vsu.chuprikov.task3;

public class Line {
    public double k;
    public double b;

    public Line(double b) {
        this(0, b);
    }

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public boolean isPointAboveLine(double x, double y) {
        return y > k * x + b;
    }
}
