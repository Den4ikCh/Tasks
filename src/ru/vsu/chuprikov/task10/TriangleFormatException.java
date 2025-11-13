package ru.vsu.chuprikov.task10;

public class TriangleFormatException extends Exception {
    private Triangle triangle;

    public TriangleFormatException() {
        super("Неверный формат треугольника.");
    }

    public TriangleFormatException(Triangle triangle) {
        super(String.format("Неверный формат треугольника %s.", triangle.toString()));
        this.triangle = triangle;
    }

    public TriangleFormatException(String message) {
        super("Неверный формат треугольника: " + message);
    }

    public Triangle getTriangle() {
        return triangle;
    }
}
