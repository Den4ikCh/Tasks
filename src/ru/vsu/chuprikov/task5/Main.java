package ru.vsu.chuprikov.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Что вы хотите нарисовать?\n1. Параллелограмм;\n2. Горы.\nВведите цифру: ");
        int choice;
        while (true) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Введите 1 либо 2: ");
                    continue;
                }
                break;
            }
            else {
                System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        switch (choice) {
            case 1: {
                int s = getInfoAboutParallelogram();
                paintParallelogram(s);
                break;
            }
            case 2: {
                int s = getInfoAboutMountains();
                paintMountains(s);
                break;
            }
            default:
                System.out.println("Ошибка.");
        }
    }

    public static int getInfoAboutParallelogram() {
        int s;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину стороны параллелограмма: ");
        while (true) {
            if (in.hasNextInt()) {
                s = in.nextInt();
                if (s < 3) {
                    System.out.print("Число меньше 3, необходимо ввести число >=3: ");
                    continue;
                }
                break;
            }
            else {
                System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        return s;
    }

    public static int getInfoAboutMountains() {
        int s;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите высоту средней горы: ");
        while (true) {
            if (in.hasNextInt()) {
                s = in.nextInt();
                if (s < 1) {
                    System.out.print("Необходимо натуральное число: ");
                    continue;
                }
                break;
            }
            else {
                System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        return s;
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
