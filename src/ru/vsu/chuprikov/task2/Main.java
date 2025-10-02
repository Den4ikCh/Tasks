package ru.vsu.chuprikov.task2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = getInfoAboutCircle(1);
        Circle circle2 = getInfoAboutCircle(2);
        displayInfo(relativePositionOfCircles(circle1, circle2));
    }

    public static String relativePositionOfCircles(Circle circle1, Circle circle2) {
        if (circle1.equals(circle2)) {
            return "Окружности совпадают.";
        }
        double distanceBetweenCenters = getDistanceBetweenCenters(circle1, circle2);
        double sumOfRadiuses = circle1.r + circle2.r;
        double maxRadius = Math.max(circle1.r, circle2.r);
        double minRadius = Math.min(circle1.r, circle2.r);

        if (sumOfRadiuses < distanceBetweenCenters) {
            return "Окружности не пересекаются.";
        } else if (doubleEquals(sumOfRadiuses, distanceBetweenCenters)) {
            return "Окружности касаются внешним образом.";
        } else if (maxRadius - minRadius < distanceBetweenCenters) {
            return "Окружности пересекаются в 2 точках.";
        } else if (doubleEquals(maxRadius - minRadius, distanceBetweenCenters)) {
            return "Окружности касаются внутренним образом.";
        }
        return "Окружности не пересекаются, одна находится внутри другой.";
    }

    public static Circle getInfoAboutCircle(int index) {
        System.out.printf("Введите координаты центра %d-й окружности:\n", index);
        double x = getDouble("Введите x координату: ");
        double y = getDouble("Введите y координату: ");
        System.out.printf("Введите радиус %d-й окружности.\n", index);
        double r = getDouble("Введите радиус: ");
        return new Circle(x, y, r);
    }

    public static double getDouble(String request) {
        Locale.setDefault(Locale.US);

        double result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextDouble()) {
                result = in.nextDouble();
                if (result < 0) {
                    System.out.println("Введено отрицательное число.");
                    in.nextLine();
                } else {
                    break;
                }
            } else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static double getDistanceBetweenCenters(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.x0 - circle2.x0, 2) + Math.pow(circle1.y0 - circle2.y0, 2));
    }

    public static void displayInfo(String info) {
        Locale.setDefault(Locale.US);

        System.out.println(info);
    }

    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
