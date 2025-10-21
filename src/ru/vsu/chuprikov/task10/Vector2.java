package ru.vsu.chuprikov.task10;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(PointDouble startPoint, PointDouble endPoint) {
        this.x = endPoint.getX() - startPoint.getX();
        this.y = endPoint.getY() - startPoint.getY();
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Vector2 getMinus() {
        return new Vector2(-x, -y);
    }

    public static double angleBetween(Vector2 first, Vector2 second) {
        if (first.length() == 0 || second.length() == 0) {
            return 0;
        }
        double scalarMultiply = first.x * second.x + first.y * second.y;
        return Math.acos(scalarMultiply / (first.length() * second.length())) / Math.PI * 180;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
