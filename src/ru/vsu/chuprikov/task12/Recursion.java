package ru.vsu.chuprikov.task12;

public class Recursion {
    private static char[][] symbols;

    public static char[][] drawSierpinskiTriangle(int level) throws Exception {
        if (level < 1) {
            throw new Exception("Уровень рекурсии должен быть натуральным числом.");
        }
        symbols = new char[(int) Math.pow(2, level)][(int) Math.pow(2, level + 1)];
        for (int x = 0; x < symbols.length; x++) {
            for (int y = 0; y < symbols[0].length; y++) {
                symbols[x][y] = ' ';
            }
        }
        printTriangle(0, 0, level);
        return symbols;
    }

    public static void printTriangle(int x, int y, int level) {
        if (level == 1) {
            symbols[x + 1][y] = '/';
            symbols[x + 1][y + 1] = '_';
            symbols[x + 1][y + 2] = '_';
            symbols[x + 1][y + 3] = '\\';
            symbols[x][y + 1] = '/';
            symbols[x][y + 2] = '\\';
            return;
        }
        printTriangle(x, (int) Math.pow(2, level - 1) + y, level - 1);
        printTriangle((int) Math.pow(2, level - 1) + x, (int) Math.pow(2, level) + y, level - 1);
        printTriangle((int) Math.pow(2, level - 1) + x, y, level - 1);
    }
}
