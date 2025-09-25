package ru.vsu.chuprikov.task2;

public class Circle {
    double x0;
    double y0;
    double r;

    public Circle(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            return Main.doubleEquals(x0, ((Circle) obj).x0) && Main.doubleEquals(y0, ((Circle) obj).y0) && Main.doubleEquals(r, ((Circle) obj).r);
        }
        return false;
    }
}
