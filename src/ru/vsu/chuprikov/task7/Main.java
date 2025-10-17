package ru.vsu.chuprikov.task7;

import java.util.Locale;
import java.util.Scanner;

import static ru.vsu.chuprikov.utils.ConsoleUtils.*;

public class Main {
    public static void main(String[] args) {
        testArrays();
        int[] array = readArrayFromConsole();
        printArray(solution(array));
    }

    public static void testArrays() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 1, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] array10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        printArray(solution(array));
        printArray(solution(array2));
        printArray(solution(array3));
        printArray(solution(array4));
        printArray(solution(array5));
        printArray(solution(array6));
        printArray(solution(array7));
        printArray(solution(array8));
        printArray(solution(array9));
        printArray(solution(array10));
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d; ", array[i]);
        }
        System.out.printf("%d}\n", array[array.length - 1]);
    }

    public static int[] readArrayFromConsole() {
        Scanner in = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int n = getPositiveInt("Введите длину массива: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getInt(String.format("Введите %d-й элемент массива: ", i));
        }
        return array;
    }

    public static int[] solution(int[] array) {
        int position = 0, currentPosition = 0;
        int count = 1, currentCount = 1;
        for (int i = 1; i < array.length; i++) {
            if (!arrayContains(copyOfRange(array, currentPosition, i), array[i])) {
                currentCount++;
            }
            else {
                if (currentCount >= count) {
                    position = currentPosition;
                    count = currentCount;
                }
                currentPosition = getIndexOfElement(copyOfRange(array, currentPosition, i), array[i]) + 1;
                currentCount = i - currentPosition + 1;
            }
        }
        if (currentCount >= count) {
            position = currentPosition;
            count = currentCount;
        }
        return new int[] {position, count};
    }

    public static boolean arrayContains(int[] array, int search) {
        for (int element : array) {
            if (element == search) {
                return true;
            }
        }
        return false;
    }

    public static int getIndexOfElement(int[] array, int search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                return i;
            }
        }
        return -1;
    }

    public static int[] copyOfRange(int[] array, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[from + i];
        }
        return result;
    }
}
