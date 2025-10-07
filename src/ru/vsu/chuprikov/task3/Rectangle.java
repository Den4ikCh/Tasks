package ru.vsu.chuprikov.task3;

public class Rectangle {
    double x0;
    double x1;
    double y0;
    double y1;
    double height;
    double width;

    public Rectangle(PointDouble p0, PointDouble p1) {
        this.x0 = Math.min(p0.x, p1.x);
        this.x1 = Math.max(p0.x, p1.x);
        this.y0 = Math.min(p0.y, p1.y);
        this.y1 = Math.max(p0.y, p1.y);
        height = this.y1 - this.y0;
        width = this.x1 - this.x0;
    }

    public boolean isPointInside(double x, double y) {
        return x0 < x && x < x1 && y0 < y && y < y1;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
