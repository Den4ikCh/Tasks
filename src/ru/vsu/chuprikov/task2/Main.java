package ru.vsu.chuprikov.task2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle[] Circles = getInfo();
        String Result = relativePositionOfCircles(Circles[0], Circles[1]);
        displayInfo(Result);
    }

    public static String relativePositionOfCircles(Circle Circle1, Circle Circle2) {
        if (Circle1.equals(Circle2)) {
            return "Окружности совпадают.";
        }
        double DistanceBetweenCenters = getDistanceBetweenCenters(Circle1, Circle2);
        double SummOfRadiuses = Circle1.r + Circle2.r;
        double MaxRadius = Math.max(Circle1.r, Circle2.r);
        double MinRadius = Math.min(Circle1.r, Circle2.r);
        if (SummOfRadiuses < DistanceBetweenCenters) {
            return "Окружности не пересекаются.";
        }
        else if (SummOfRadiuses == DistanceBetweenCenters) {
            return "Окружности касаются внешним образом.";
        }
        else if (MaxRadius - MinRadius < DistanceBetweenCenters) {
            return "Окружности пересекаются в 2 точках.";
        }
        else if (MaxRadius - MinRadius == DistanceBetweenCenters) {
            return "Окружности касаются внутренним образом.";
        }
        return "Окружности не пересекаются, одна находится внутри другой.";
    }

    public static Circle[] getInfo() {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Введите координаты центра первой окружности в формате x, y: ");
        double x1, x2, y1, y2, r1, r2;
        while (true) {
            try {
                String tmp = in.nextLine();
                String[] Coordinates = tmp.split(", ");
                if (Coordinates.length != 2) {
                    throw new Exception();
                }
                x1 = Double.parseDouble(Coordinates[0]);
                y1 = Double.parseDouble(Coordinates[1]);
                break;
            }
            catch (Exception e) {
                System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
            }
        }
        System.out.print("Введите радиус первой окружности: ");
        while (true) {
            try {
                 r1 = in.nextDouble();
                 break;
            }
            catch (Exception e) {
                System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        System.out.print("Введите координаты центра второй окружности в формате x, y: ");
        while (true) {
            try {
                String tmp = in.nextLine();
                String[] Coordinates = tmp.split(", ");
                if (Coordinates.length != 2) {
                    throw new Exception();
                }
                x2 = Double.parseDouble(Coordinates[0]);
                y2 = Double.parseDouble(Coordinates[1]);
                break;
            }
            catch (Exception e) {
                System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
            }
        }
        System.out.print("Введите радиус второй окружности: ");
        while (true) {
            try {
                r2 = in.nextDouble();
                break;
            }
            catch (Exception e) {
                System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        in.close();
        Circle FirstCircle = new Circle(x1, y1, r1);
        Circle SecondCircle = new Circle(x2, y2, r2);
        return new Circle[] {FirstCircle, SecondCircle};
    }

    public static double getDistanceBetweenCenters(Circle Circle1, Circle Circle2) {
        return Math.sqrt(Math.pow(Circle1.x0 - Circle2.x0, 2) + Math.pow(Circle1.y0 - Circle2.y0, 2));
    }

    public static void displayInfo(String info) {
        System.out.println(info);
    }
}
