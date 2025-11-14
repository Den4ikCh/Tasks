package ru.vsu.chuprikov.task10;

public class TriangleFormatException extends Exception {
    private Triangle triangle;

    public TriangleFormatException(Triangle triangle) {
        super(String.format("Неверный формат треугольника %s.", triangle.toString()));
        this.triangle = triangle;
    }

    public TriangleFormatException(Triangle triangle, String message) {
        super(String.format("Неверный формат треугольника %s: %s.", triangle.toString(), message));
        this.triangle = triangle;
    }

    public Triangle getTriangle() {
        return triangle;
    }
}
