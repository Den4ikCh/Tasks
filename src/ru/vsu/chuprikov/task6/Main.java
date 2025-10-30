package ru.vsu.chuprikov.task6;

import ru.vsu.chuprikov.utils.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        double x = ConsoleUtils.getDouble("Введите x: ");
        int n = ConsoleUtils.getPositiveInt("Введите n: ");
        double e = ConsoleUtils.getPositiveDouble("Введите e: ");
        while (e >= 1) {
            System.out.println("Необходимо ввести положительное число, меньшее 1.");
            e = ConsoleUtils.getPositiveDouble("Введите e: ");
        }
        Sequence sequence = new Sequence(n, x, e);
        sequence.solution();
        System.out.printf("Сумма первых %d слагаемых равна %.5f.\n", n, sequence.getSumOfN());
        System.out.printf("Сумма слагаемых, больших e = %.2f равна %.5f.\n", e, sequence.getSumOfTernsMoreThanE());
        System.out.printf("Сумма слагаемых, больших e / 10 = %.3f равна %.5f.\n", e / 10, sequence.getSumOfTernsMoreThanE10());
        System.out.printf("Значение, посчитанное с помощью Math: %.5f.\n", Math.pow(Math.E, -x));
    }
}
