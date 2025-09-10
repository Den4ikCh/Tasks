package ru.vsu.chuprikov.task3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
     public static final Line ImaginaryLine = new Line(3);
     public static final Line line = new Line(4, 6);
     public static final Circle circle = new Circle(-2, 3, 2);
     public static final Rectangle rectangle = new Rectangle(new PointDouble(-3, 0), new PointDouble(7, 8));

     public static void main(String[] args) {
          PointDouble[] Points = new PointDouble[8];
          Points[0] = new PointDouble(-5, 3);
          Points[1] = new PointDouble(3, -3);
          Points[2] = new PointDouble(5, 2);
          Points[3] = new PointDouble(-0.5, 2.5);
          Points[4] = new PointDouble(-2, 0.5);
          Points[5] = new PointDouble(-2, 3);
          Points[6] = new PointDouble(-3.5, 3);
          Points[7] = new PointDouble(-1, 7);
          for (PointDouble Point : Points) {
               printColorForPoint(Point.x, Point.y);
          }

          System.out.print("Input x: ");
          Scanner in = new Scanner(System.in);
          in.useLocale(Locale.US);
          double x;
          while (true) {
               try {
                    x = in.nextDouble();
                    break;
               }
               catch (Exception e) {
                    System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                    in.nextLine();
               }
          }
          System.out.print("Input y: ");
          double y;
          while (true) {
               try {
                    y = in.nextDouble();
                    break;
               }
               catch (Exception e) {
                    System.out.print("Вы неверно ввели данные, попробуйте ещё раз: ");
                    in.nextLine();
               }
          }
          in.close();
          if (-10 <= x && x <= 10 && -10 <= y && y <= 10) {
               printColorForPoint(x, y);
          }
          else {
               System.out.print("Точка находится за пределами картинки.");
          }
     }

     public static SimpleColor getColor(double x, double y) {
          if (!line.isPointAboveLine(x, y)) {
               if (!rectangle.isPointInside(x, y) || circle.isPointInside(x, y)) {
                    return SimpleColor.BLUE;
               }
               return SimpleColor.ORANGE;
          }
          else if (!rectangle.isPointInside(x, y)) {
               return SimpleColor.WHITE;
          }
          else if (circle.isPointInside(x, y) || ImaginaryLine.isPointAboveLine(x, y)) {
               return SimpleColor.GREEN;
          }
          else {
               return SimpleColor.ORANGE;
          }
     }

     public static void printColorForPoint(double x, double y) {
          System.out.printf("(%.1f, %.1f) -> %s\n", x, y, getColor(x, y));
     }
}