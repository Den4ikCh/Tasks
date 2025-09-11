package ru.vsu.chuprikov.task1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Введите радиус меньшей окружности: ");
        double r1 = in.nextDouble();
        System.out.print("Введите радиус средней окружности: ");
        double r2 = in.nextDouble();
        System.out.print("Введите радиус большей окружности: ");
        double r3 = in.nextDouble();
        in.close();
        System.out.printf("Площадь закрашенной области равна %.5f квадратных единиц.", squareCalculation(r1, r2, r3));
    }

    public static double squareCalculation(double r1, double r2, double r3) {
        double s1 = (Math.PI * Math.pow(r1, 2)) / 4; //четверть меньшего круга
        double s2 = (Math.PI * Math.pow(r2, 2) - Math.PI * Math.pow(r1, 2)) * 3 / 8; //фигура, ограниченная средним и малым кругом
        double s3 = (Math.PI * Math.pow(r3, 2) - Math.PI * Math.pow(r2, 2)) / 2; //фигура, ограниченная большим и средним кругом
        double s4 = (Math.pow(r3 * 2, 2) - Math.PI * Math.pow(r3, 2)) * 5 / 8; //уголки
        double res = s1 + s2 + s3 + s4;
        return res;
    }
}