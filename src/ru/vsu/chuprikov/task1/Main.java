package ru.vsu.chuprikov.task1;

import ru.vsu.chuprikov.utils.ConsoleUtils;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        double radius1 = ConsoleUtils.getPositiveDouble("Введите радиус меньшей окружности: ");
        double radius2 = ConsoleUtils.getPositiveDouble("Введите радиус средней окружности: ");
        double radius3 = ConsoleUtils.getPositiveDouble("Введите радиус большей окружности: ");
        System.out.printf("Площадь закрашенной области равна %.5f квадратных единиц.", squareCalculation(radius1, radius2, radius3));
    }
    
    public static double squareCalculation(double radius1, double radius2, double radius3) {
        double square1 = squareOfCircle(radius1) / 4; //четверть меньшего круга
        double square2 = (squareOfCircle(radius2) - squareOfCircle(radius1)) * 3 / 8; //фигура, ограниченная средним и малым кругом
        double square3 = (squareOfCircle(radius3) - squareOfCircle(radius2)) / 2; //фигура, ограниченная большим и средним кругом
        double square4 = (Math.pow(radius3 * 2, 2) - squareOfCircle(radius3)) * 5 / 8; //уголки
        return square1 + square2 + square3 + square4;
    }

    public static double squareOfCircle(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }
}