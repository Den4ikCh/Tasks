package ru.vsu.chuprikov.task3;

public class Circle {
    private double r;
    private double x0;
    private double y0;

    public Circle(double x0, double y0, double r) {
        this.r = r;
        this.x0 = x0;
        this.y0 = y0;
    }

    public boolean isPointInside(double x, double y) {
        return Math.pow((x - x0), 2) + Math.pow((y - y0), 2) < Math.pow(r, 2);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) throws NumberFormatException {
        if (r <= 0) {
            throw new NumberFormatException("Радиус должен быть положительным числом");
        }
        this.r = r;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }
}
