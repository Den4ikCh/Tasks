package ru.vsu.chuprikov.task6;

public class Sequence {
    private int n;
    private double x;
    private double e;

    private double sumOfN = 0;
    private double sumOfTernsMoreThanE = 0;
    private double sumOfTernsMoreThanE10 = 0;

    public Sequence(int n, double x, double e) {
        this.n = n;
        this.x = x;
        this.e = e;
        solution();
    }

    private void solution() {
        double current = 1;
        for (int i = 1; i <= n || Math.abs(current) > e / 10; i++) {
            if (i <= n) {
                sumOfN += current;
            }
            if (Math.abs(current) > e) {
                sumOfTernsMoreThanE += current;
            }
            if (Math.abs(current) > e / 10) {
                sumOfTernsMoreThanE10 += current;
            }
            current = getNext(i, current, x);
        }
    }

    private static double getNext(int n, double previous, double x) {
        return -previous * x / n;
    }

    public double getSumOfN() {
        return sumOfN;
    }

    public double getSumOfTernsMoreThanE() {
        return sumOfTernsMoreThanE;
    }

    public double getSumOfTernsMoreThanE10() {
        return sumOfTernsMoreThanE10;
    }
}
