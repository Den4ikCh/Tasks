package ru.vsu.chuprikov.task5;

public class ArithmeticProgression {
    int a1;
    int d;

    public ArithmeticProgression(int a1, int d) {
        this.a1 = a1;
        this.d = d;
    }

    public double getSum(int n) {
        return (a1 * 2 + d * (n - 1)) * n / 2f;
    }

    public int getElementAtNumber(int n) {
        return a1 + d * (n - 1);
    }
}
