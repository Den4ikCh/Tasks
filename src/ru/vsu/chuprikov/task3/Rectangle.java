package ru.vsu.chuprikov.task3;

public class Rectangle {
    private PointDouble leftBottomPoint;
    private double height;
    private double width;

    public Rectangle(PointDouble leftBottomPoint, double height, double width) {
        this.leftBottomPoint = leftBottomPoint;
        this.height = height;
        this.width = width;
    }

    public boolean isPointInside(double x, double y) {
        return leftBottomPoint.getX() < x && x < leftBottomPoint.getX() + width && leftBottomPoint.getY() < y && y < leftBottomPoint.getY() + height;
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

    public PointDouble getLeftBottomPoint() {
        return leftBottomPoint;
    }

    public void setLeftBottomPoint(PointDouble leftBottomPoint) {
        this.leftBottomPoint = leftBottomPoint;
    }
}
