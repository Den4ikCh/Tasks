package ru.vsu.chuprikov.utils;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleUtils {
    public static double getDouble(String request) {
        Locale.setDefault(Locale.US);

        double result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextDouble()) {
                result = in.nextDouble();
                break;
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static double getPositiveDouble(String request) {
        Locale.setDefault(Locale.US);

        double result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextDouble()) {
                result = in.nextDouble();
                if (result <= 0) {
                    System.out.println("Введённое число не является положительным.");
                    in.nextLine();
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static int getInt(String request) {
        Locale.setDefault(Locale.US);

        int result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextInt()) {
                result = in.nextInt();
                break;
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static int getIntMoreThan(String request, int n) {
        Locale.setDefault(Locale.US);

        int result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (result <= n) {
                    System.out.printf("Необходимо ввести число >%d.\n", n);
                    in.nextLine();
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static int getPositiveInt(String request) {
        Locale.setDefault(Locale.US);

        int result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (result <= 0) {
                    System.out.println("Введённое число не является положительным.");
                    in.nextLine();
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }

    public static long getPositiveLong(String request) {
        Locale.setDefault(Locale.US);

        long result;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(request);
            if (in.hasNextLong()) {
                result = in.nextLong();
                if (result <= 0) {
                    System.out.println("Введённое число не является положительным.");
                    in.nextLine();
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Вы неверно ввели данные, попробуйте ещё раз.");
                in.nextLine();
            }
        }
        return result;
    }
}
