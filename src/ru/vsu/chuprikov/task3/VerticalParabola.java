package ru.vsu.chuprikov.task3;

public class VerticalParabola extends Parabola {
    public VerticalParabola(double x0, double y0, double a) {
        this.a = a;
        b = y0 * (-2) * a;
        c = x0 - Math.pow(y0, 2) * a - b * y0;
    }

    @Override
    public boolean isPointInParabola(double x, double y) {
        return x > Math.pow(y, 2) * a + y * b + c;
    }
}
