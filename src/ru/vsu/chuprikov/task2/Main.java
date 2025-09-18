package ru.vsu.chuprikov.task2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = getInfo();
        String result = relativePositionOfCircles(circles[0], circles[1]);
        displayInfo(result);
    }

    public static String relativePositionOfCircles(Circle circle1, Circle circle2) {
        if (circle1.equals(circle2)) {
            return "Окружности совпадают.";
        }
        double distanceBetweenCenters = getDistanceBetweenCenters(circle1, circle2);
        double summOfRadiuses = circle1.r + circle2.r;
        double maxRadius = Math.max(circle1.r, circle2.r);
        double minRadius = Math.min(circle1.r, circle2.r);
        if (summOfRadiuses < distanceBetweenCenters) {
            return "Окружности не пересекаются.";
        }
        else if (summOfRadiuses == distanceBetweenCenters) {
            return "Окружности касаются внешним образом.";
        }
        else if (maxRadius - minRadius < distanceBetweenCenters) {
            return "Окружности пересекаются в 2 точках.";
        }
        else if (maxRadius - minRadius == distanceBetweenCenters) {
            return "Окружности касаются внутренним образом.";
        }
        return "Окружности не пересекаются, одна находится внутри другой.";
    }

    public static Circle[] getInfo() {
        Locale.setDefault(Locale.US);

        Scanner in = new Scanner(System.in);
        System.out.print("Введите координаты центра первой окружности в формате x, y: ");
        double x1, x2, y1, y2, r1, r2;
        while (true) {
            try {
                String tmp = in.nextLine();
                String[] coordinates = tmp.split(", ");
                if (coordinates.length != 2) {
                    throw new Exception();
                }
                x1 = Double.parseDouble(coordinates[0]);
                y1 = Double.parseDouble(coordinates[1]);
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
                 if (r1 <= 0) {
                     throw new Exception("Окружность должна иметь положительный радиус: ");
                 }
                 break;
            }
            catch (Exception e) {
                if (e.getMessage() == null) {
                    System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                }
                else {
                    System.out.print(e.getMessage());
                }
                in.nextLine();
            }
        }
        in.nextLine();
        System.out.print("Введите координаты центра второй окружности в формате x, y: ");
        while (true) {
            try {
                String tmp = in.nextLine();
                String[] coordinates = tmp.split(", ");
                if (coordinates.length != 2) {
                    throw new Exception();
                }
                x2 = Double.parseDouble(coordinates[0]);
                y2 = Double.parseDouble(coordinates[1]);
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
                if (r2 <= 0) {
                    throw new Exception("Окружность должна иметь положительный радиус: ");
                }
                break;
            }
            catch (Exception e) {
                if (e.getMessage() == null) {
                    System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                }
                else {
                    System.out.print(e.getMessage());
                }
                in.nextLine();
            }
        }
        in.close();
        Circle firstCircle = new Circle(x1, y1, r1);
        Circle secondCircle = new Circle(x2, y2, r2);
        return new Circle[] {firstCircle, secondCircle};
    }

    public static double getDistanceBetweenCenters(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.x0 - circle2.x0, 2) + Math.pow(circle1.y0 - circle2.y0, 2));
    }

    public static void displayInfo(String info) {
        Locale.setDefault(Locale.US);

        System.out.println(info);
    }
}
