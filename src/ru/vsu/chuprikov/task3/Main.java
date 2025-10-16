package ru.vsu.chuprikov.task3;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import java.util.Locale;

public class Main {
     public static final Line IMAGINARY_LINE = new Line(3);
     public static final Line LINE = new Line(4, 6);
     public static final Circle CIRCLE = new Circle(-2, 3, 2);
     public static final Rectangle RECTANGLE = new Rectangle(new PointDouble(-3, 0), 8, 10);

     public static void main(String[] args) {
          printColorForPoint(-5, 3);
          printColorForPoint(3, -3);
          printColorForPoint(5, 2);
          printColorForPoint(-0.5, 2.5);
          printColorForPoint(-2, 0.5);
          printColorForPoint(-2, 3);
          printColorForPoint(-3.5, 3);
          printColorForPoint(-1, 7);

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
          }
          return SimpleColor.ORANGE;
     }

     public static void printColorForPoint(double x, double y) {
          Locale.setDefault(Locale.US);

          System.out.printf("(%.1f, %.1f) -> %s\n", x, y, getColor(x, y));
     }
}