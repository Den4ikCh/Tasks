package ru.vsu.chuprikov.task3;

public class Parabola {
    public double a;
    public double b;
    public double c;
    public boolean isVertical;

    public Parabola(double x0, double y0, double a) {
        this(x0, y0, a, true);
    }

    public Parabola(double x0, double y0, double a, boolean isVertical) {
        this.isVertical = isVertical;
        if (isVertical) {
            this.a = a;
            b = x0 * (-2) * a;
            c = y0 - Math.pow(x0, 2) * a - b * x0;
        }
        else {
            this.a = a;
            b = y0 * (-2) * a;
            c = x0 - Math.pow(y0, 2) * a - b * y0;
        }
    }

    public boolean isPointInParabola(double x, double y) {
        if (isVertical) {
            return y > Math.pow(x, 2) * a + x * b + c;
        }
        return x > Math.pow(y, 2) * a + y * b + c;
    }
}
