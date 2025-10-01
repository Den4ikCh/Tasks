package ru.vsu.chuprikov.task5;

import java.lang.classfile.Attribute;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int s;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину стороны параллелограмма: ");
        while (true) {
            if (in.hasNextInt()) {
                s = in.nextInt();
                if (s < 3) {
                    System.out.println("Число меньше 3, необходимо ввести число >=3: ");
                    continue;
                }
                break;
            }
            else {
                System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
//        paintParallelogram(s);
        paintMountains(s);
    }

    public static void paintParallelogram(int s) {
        char inside = '#';
        char outside = '*';
        for (int i = 0; i < s; i++) {
            System.out.print(outside);
        }
        System.out.println();

        for (int i = 1; i < s - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            if ((i != 1) && (i != s - 2)) {
                System.out.print(outside);
                System.out.print(inside);
                for (int j = 0; j < s - 4; j++) {
                    System.out.print(' ');
                }
                System.out.print(inside);
                System.out.print(outside);
            }
            else {
                System.out.print(outside);
                for (int j = 0; j < s - 2; j++) {
                    System.out.print(inside);
                }
                System.out.print(outside);
            }
            System.out.println();
        }

        for (int i = 0; i < s - 1; i++) {
            System.out.print(' ');
        }
        for (int i = 0; i < s; i++) {
            System.out.print(outside);
        }
    }

    public static void paintMountains(int s) {
        ArithmeticProgression progression = new ArithmeticProgression(0, 2);
        for (int layer = 0; layer < s; layer++) {
            int count = s - layer - 1;
            for (int i = 0; i < progression.getSum(count + 1) + count; i++) {
                System.out.print(' ');
            }
            layer++;
            for (int i = 1; i < layer; i++) {
                paintLayerOfMountain(i);
                for (int j = 0; j < progression.getElementAtNumber(count + 1); j++) {
                    System.out.print(' ');
                }
            }
            for (int i = layer; i > 0; i--) {
                paintLayerOfMountain(i);
                for (int j = 0; j < progression.getElementAtNumber(count + 1); j++) {
                    System.out.print(' ');
                }
            }
            layer--;
            System.out.println();
        }
    }

    public static void paintLayerOfMountain(int s) {
        char first = '/';
        char second = '\\';
        for (int i = 0; i < s; i++) {
            System.out.print(first);
        }
        for (int i = 0; i < s; i++) {
            System.out.print(second);
        }
    }
}
