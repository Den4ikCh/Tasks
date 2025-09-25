package ru.vsu.chuprikov.task4;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        long k;
        while (true) {
            if (in.hasNextLong()) {
                k = in.nextLong();
                if (k < 1) {
                    System.out.println("Данное число не является положительным, попробуйте ещё раз: ");
                    continue;
                }
                break;
            }
            else {
                System.out.print("Неверный формат числа, попробуйте ещё раз: ");
                in.nextLine();
            }
        }
        in.close();
        System.out.println(getCurrentNumber(k));
        if (k < 1e5) {
            System.out.println(testOnString((int)k));
        }
    }

    public static byte getCurrentNumber(long k) {
        byte i = 1;
        while (k > 9 * Math.pow(10, i - 1) * i) {
            k -= 9 * (long)Math.pow(10, i - 1) * i;
            i++;
        }
        k--;
        long x = k / i;
        k %= i;
        long currentNumber = (long)Math.pow(10, i - 1) + x;
        return getNumberAtPosition(currentNumber, (byte)(i - k - 1));
    }

    public static byte getNumberAtPosition(long number, byte position) {
        return (byte)((number % Math.pow(10, position + 1)) / Math.pow(10, position));
    }

    public static char testOnString(int k) {
        String numbers = "";
        int n = 1;
        while (numbers.length() < k) {
            numbers += n++;
        }
        return numbers.charAt(k - 1);
    }
}