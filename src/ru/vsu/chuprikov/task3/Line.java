package ru.vsu.chuprikov.task3;

public class Line {
    double k;
    double b;

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

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
