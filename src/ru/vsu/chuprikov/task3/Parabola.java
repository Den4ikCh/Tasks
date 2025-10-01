package ru.vsu.chuprikov.task3;

public class Parabola {
    public double a;
    public double b;
    public double c;

    public Parabola() {
    }

    public Parabola(double x0, double y0, double a) {
        this.a = a;
        b = x0 * (-2) * a;
        c = y0 - Math.pow(x0, 2) * a - b * x0;
    }

    public boolean isPointInParabola(double x, double y) {
        return y > Math.pow(x, 2) * a + x * b + c;
    }
}
