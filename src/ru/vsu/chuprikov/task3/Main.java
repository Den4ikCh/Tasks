package ru.vsu.chuprikov.task3;

import java.awt.Point;
import java.util.Scanner;

public class Main {
     public static final Parabola parabola = new Parabola(2, 2, 1, false);
     public static final Line line1 = new Line(2.5, 8.5);
     public static final Line line2 = new Line(-2);

     public static void main(String[] args) {
          Point p1 = new Point(-2, 3);
          Point p2 = new Point(0, -3);
          Point p3 = new Point(-5, -3);
          Point p4 = new Point(6, 2);
          printColorForPoint(p1.x, p1.y);
          printColorForPoint(p2.x, p2.y);
          printColorForPoint(p3.x, p3.y);
          printColorForPoint(p4.x, p4.y);

          System.out.print("Input x: ");
          Scanner in = new Scanner(System.in);
          double x = in.nextDouble();
          System.out.print("Input y: ");
          double y = in.nextDouble();
          in.close();
          if (-10 <= x && x <= 10 && -10 <= y && y <= 10) {
               printColorForPoint(x, y);
          }
          else {
               System.out.print("Точка находится за пределами картинки.");
          }
     }

     public static SimpleColor getColor(double x, double y) {
          if (parabola.isPointInParabola(x, y))
          {
               return SimpleColor.ORANGE;
          }
          if (line2.isPointAboveLine(x, y))
          {
               return SimpleColor.GRAY;
          }
          else if (line1.isPointAboveLine(x, y)) {
               return SimpleColor.GREEN;
          }
          else {
               return SimpleColor.YELLOW;
          }
     }

     public static void printColorForPoint(double x, double y) {
          System.out.printf("(%.1f, %.1f) -> %s\n", x, y, getColor(x, y));
     }
}