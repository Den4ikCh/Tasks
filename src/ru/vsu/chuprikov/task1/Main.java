package ru.vsu.chuprikov.task1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner in = new Scanner(System.in);
        System.out.print("Введите радиус меньшей окружности: ");
        double radius1 = in.nextDouble();
        System.out.print("Введите радиус средней окружности: ");
        double radius2 = in.nextDouble();
        System.out.print("Введите радиус большей окружности: ");
        double radius3 = in.nextDouble();
        in.close();
        System.out.printf("Площадь закрашенной области равна %.5f квадратных единиц.", squareCalculation(radius1, radius2, radius3));
    }
    
    public static double squareCalculation(double radius1, double radius2, double radius3) {
        double square1 = (Math.PI * Math.pow(radius1, 2)) / 4; //четверть меньшего круга
        double square2 = (Math.PI * Math.pow(radius2, 2) - Math.PI * Math.pow(radius1, 2)) * 3 / 8; //фигура, ограниченная средним и малым кругом
        double square3 = (Math.PI * Math.pow(radius3, 2) - Math.PI * Math.pow(radius2, 2)) / 2; //фигура, ограниченная большим и средним кругом
        double square4 = (Math.pow(radius3 * 2, 2) - Math.PI * Math.pow(radius3, 2)) * 5 / 8; //уголки
        double result = square1 + square2 + square3 + square4;
        return result;
    }
}