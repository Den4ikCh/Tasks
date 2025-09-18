package ru.vsu.chuprikov.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int s;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину стороны параллелограмма: ");
        while (true) {
            try {
                s = in.nextInt();
                if (s < 3) {
                    throw new Exception("Число меньше 3, необходимо ввести число >=3: ");
                }
                break;
            }
            catch (Exception e) {
                if (e.getMessage() == null) {
                    System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                }
                else {
                    System.out.print(e.getMessage());
                }
                in.nextLine();
            }
        }
        paintParallelogram(s);
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
}
