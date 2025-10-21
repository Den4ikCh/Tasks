package ru.vsu.chuprikov.task7;

import ru.vsu.chuprikov.utils.ConsoleUtils;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        testArrays();
        int[] array = readArrayFromConsole();
        printArray(solution(array));
    }

    public static void testArrays() {
        int[] array = {3, 3, 4, 8, 8, 10, 7, 4, 10, 7, 7, 4, 3, 3, 8, 9, 1};                    //Пример из PDF-файла
        int[] array2 = {10, 5, 5, 3};                                                           //Пример из PDF-файла
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; //Полностью возрастающая последовательность
        int[] array4 = {20, 19, 18, 17, 15, 14, 14, 13, 12, 9, 9, 9, 8, 7, 6, 4, 4, 3, 2, 1};   //Полностью убывающая последовательность
        int[] array5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};             //Яма на всю последовательность
        int[] array6 = {1, 3, 5, 7, 9, 8, 6, 4, 2, 1, 3, 5, 7, 0, -100, -1000};                 //Две горы
        int[] array7 = {5, 4, 3, 2, 1, 2, 3, 4, 5, 4, 3, 2, 1};                                 //W-образная последовательность
        int[] array8 = {-10, -9, 0, 10, 9, 6, 6, 7, 8, 9, 9, 8, 0, -1, -4, -3, 0, 5, 10, 2};    //Три горы
        int[] array9 = {1, 2, 1, 2, 1, 2, 1, 2, 1};                                             //Чередующаяся последовательность
        int[] array10 = {1, 1, 2, 3, 4, 5, 6, 7, 7, 5, 3, 2, -5, -10};                          //Гора на всю последовательность
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
        int n = ConsoleUtils.getPositiveInt("Введите длину массива: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ConsoleUtils.getInt(String.format("Введите %d-й элемент массива: ", i));
        }
        return array;
    }

    public static int[] solution(int[] array) {
        int position = 0, currentPosition = 0;
        int count = 1;
        int indexFrom = 1;
        while (array[indexFrom] == array[indexFrom - 1] && indexFrom < array.length - 1) {
            indexFrom++;
        }
        int currentCount = indexFrom;
        boolean isDown = array[indexFrom] < array[indexFrom - 1];
        for (int i = indexFrom; i < array.length; i++) {
            if (isDown || array[i] >= array[i - 1]) {
                currentCount++;
                if (isDown && array[i] > array[i - 1]) {
                    isDown = false;
                }
            } else {
                if (currentCount > count) {
                    count = currentCount;
                    position = currentPosition;
                }
                currentPosition = i - 1;
                currentCount = 2;
                isDown = array[i] <= array[i - 1];
            }
        }
        if (currentCount > count) {
            count = currentCount;
            position = currentPosition;
        }
        return copyOfRange(array, position, position + count);
    }

    public static int[] copyOfRange(int[] array, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[from + i];
        }
        return result;
    }
}
