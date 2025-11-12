package ru.vsu.chuprikov.task10;

public class TriangleFormatException extends Exception {
    public TriangleFormatException() {
        super("Неверный формат треугольника.");
    }

    public TriangleFormatException(String message) {
        super("Неверный формат треугольника: " + message);
    }
}
