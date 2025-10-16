package ru.vsu.chuprikov.task6;

import static ru.vsu.chuprikov.utils.ConsoleUtils.*;

public class Main {
    public static void main(String[] args) {
        double x = getDouble("Введите x: ");
        int n = getPositiveInt("Введите n: ");
        double e = getPositiveDouble("Введите e: ");
        System.out.printf("Сумма первых %d слагаемых равна %.5f.\n", n, getSumOfN(n, x));
        System.out.printf("Сумма слагаемых, больших e = %.1f равна %.5f.\n", e, getSumOfTermsMoreThan(x, e));
        System.out.printf("Сумма слагаемых, больших e / 10 = %.1f равна %.5f.\n", e / 10, getSumOfTermsMoreThan(x, e / 10));
        System.out.printf("Значение, посчитанное с помощью Math: %.5f.\n", Math.pow(Math.E, -x));
    }

    public static double getSumOfN(int n, double x) {
        double result = 1;
        double current = 1;
        for (int i = 1; i < n; i++) {
            current = getNext(i, current, x);
            result += current;
        }
        return result;
    }

    public static double getSumOfTermsMoreThan(double x, double e)
    {
        double result = 0;
        double current = 1;
        int i = 1;
        while (Math.abs(current) > e) {
            result += current;
            current = getNext(i++, current, x);
        }
        return result;
    }

    public static double getNext(int n, double previous, double x) {
        return previous * (-x) / n;
    }
}
