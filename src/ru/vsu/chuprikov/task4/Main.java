package ru.vsu.chuprikov.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
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
        long CurrentNumber = (long)Math.pow(10, i - 1) + x;
        return getNumberAtPosition(CurrentNumber, (byte)(i - k - 1));
    }

    public static byte getNumberAtPosition(long Number, byte Position) {
        return (byte)((Number % Math.pow(10, Position + 1)) / Math.pow(10, Position));
    }

    public static char testOnString(int k) {
        String Numbers = "";
        int n = 1;
        while (Numbers.length() < k) {
            Numbers += n++;
        }
        return Numbers.charAt(k - 1);
    }
}