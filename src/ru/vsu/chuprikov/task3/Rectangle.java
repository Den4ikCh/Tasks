package ru.vsu.chuprikov.task3;

public class Rectangle {
    private double x0;
    private double x1;
    private double y0;
    private double y1;
    private double height;
    private double width;

    public Rectangle(PointDouble p0, PointDouble p1) {
        this.x0 = Math.min(p0.getX(), p1.getX());
        this.x1 = Math.max(p0.getX(), p1.getX());
        this.y0 = Math.min(p0.getY(), p1.getY());
        this.y1 = Math.max(p0.getY(), p1.getY());
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
