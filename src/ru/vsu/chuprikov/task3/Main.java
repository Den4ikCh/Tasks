package ru.vsu.chuprikov.task3;

import java.lang.classfile.TypeAnnotation;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
          Scanner in = new Scanner(System.in);

          double x = in.nextDouble();
          double y = in.nextDouble();

          in.close();

          System.out.println(GetColor(x, y));
     }

     public static SimpleColor GetColor(double x, double y) {
          //Здесь продолжать писать по варианту
          Parabola parabola = new Parabola(2, 2, 1, false);
          if (parabola.isPointInParabola(x, y)) {
               return SimpleColor.ORANGE;
          }
          return SimpleColor.GRAY;
     }

     public enum SimpleColor {
          BLACK,
          WHITE,
          GRAY,
          RED,
          ORANGE,
          YELLOW,
          GREEN,
          BLUE;
     }
}
