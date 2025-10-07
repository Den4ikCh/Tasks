package ru.vsu.chuprikov.task3;

public class Parabola {
    protected double a;
    protected double b;
    protected double c;

    public Parabola() {
        a = 1;
    }

    public Parabola(double x0, double y0, double a) {
        this.a = a;
        b = x0 * (-2) * a;
        c = y0 - Math.pow(x0, 2) * a - b * x0;
    }

    public boolean isPointInParabola(double x, double y) {
        return y > Math.pow(x, 2) * a + x * b + c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws NumberFormatException {
        if (a == 0) {
            throw new NumberFormatException("Старший коэффициент параболы не может быть равен нулю");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
