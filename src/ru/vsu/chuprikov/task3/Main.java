package ru.vsu.chuprikov.task3;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import java.util.Locale;

public class Main {
     public static final Line IMAGINARY_LINE = new Line(3);
     public static final Line LINE = new Line(4, 6);
     public static final Circle CIRCLE = new Circle(-2, 3, 2);
     public static final Rectangle RECTANGLE = new Rectangle(new PointDouble(-3, 0), new PointDouble(7, 8));

     public static void main(String[] args) {
          PointDouble[] points = new PointDouble[8];
          points[0] = new PointDouble(-5, 3);
          points[1] = new PointDouble(3, -3);
          points[2] = new PointDouble(5, 2);
          points[3] = new PointDouble(-0.5, 2.5);
          points[4] = new PointDouble(-2, 0.5);
          points[5] = new PointDouble(-2, 3);
          points[6] = new PointDouble(-3.5, 3);
          points[7] = new PointDouble(-1, 7);
          for (PointDouble point : points) {
               printColorForPoint(point.x, point.y);
          }

          double x = ConsoleUtils.getDouble("Введите x: ");
          while (Math.abs(x) > 10) {
               System.out.println("Введите число от -10 до 10.");
               x = ConsoleUtils.getDouble("Введите x: ");
          }

          double y = ConsoleUtils.getDouble("Введите y: ");
          while (Math.abs(y) > 10) {
               System.out.println("Введите число от -10 до 10.");
               y = ConsoleUtils.getDouble("Введите y: ");
          }

          printColorForPoint(x, y);
     }

     public static SimpleColor getColor(double x, double y) {
          if (!LINE.isPointAboveLine(x, y)) {
               if (!RECTANGLE.isPointInside(x, y) || CIRCLE.isPointInside(x, y)) {
                    return SimpleColor.BLUE;
               }
               return SimpleColor.ORANGE;
          } else if (!RECTANGLE.isPointInside(x, y)) {
               return SimpleColor.WHITE;
          } else if (CIRCLE.isPointInside(x, y) || IMAGINARY_LINE.isPointAboveLine(x, y)) {
               return SimpleColor.GREEN;
          } else {
               return SimpleColor.ORANGE;
          }
     }

     public static void printColorForPoint(double x, double y) {
          Locale.setDefault(Locale.US);

          System.out.printf("(%.1f, %.1f) -> %s\n", x, y, getColor(x, y));
     }
}