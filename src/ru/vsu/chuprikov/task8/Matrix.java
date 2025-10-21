package ru.vsu.chuprikov.task8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Matrix {
    public static int[][] readMatrixFromFile(String filename) {
        int[][] matrix = {};
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8\\";
        File file = new File(path + filename);
        try (FileReader fileReader = new FileReader(file)) {
            char[] array = new char[(int) file.length()];
            fileReader.read(array);
            int column = 1;
            int row = 1;
            boolean found = false;
            for (char c : array) {
                if (c == '\n') {
                    row++;
                    found = true;
                } else if (c == ' ' && !found) {
                    column++;
                }
            }
            matrix = new int[row][column];
            int index = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    String number = "";
                    boolean isPositive = true;
                    while (array[index] < '0' || array[index] > '9') {
                        if (array[index] == '-') {
                            isPositive = false;
                        }
                        index++;
                    }
                    while (index < array.length && array[index] >= '0' && array[index] <= '9') {
                        number += array[index];
                        index++;
                    }
                    if (!isPositive) {
                        number = "-";
                    }
                    matrix[i][j] = Integer.parseInt(number);
                    index++;
                }
            }
        }
        catch (Exception e) { }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, String filename) {
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8\\";
        File file = new File(path + filename);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    fileWriter.write(String.valueOf(matrix[row][column]));
                    if (column != matrix[0].length - 1) {
                        fileWriter.write(' ');
                    } else if (row != matrix.length - 1) {
                        fileWriter.write('\n');
                    }
                }
            }
        }
        catch (Exception e) { }
    }

    public static boolean isMatrixSorted(int[][] matrix) {
        int row = 0, column = 0;
        int[] array = new int[matrix.length * matrix[0].length];
        array[0] = matrix[0][0];
        if (matrix.length > 1) {
            row++;
        } else if (matrix[0].length > 1) {
            column++;
        }
        int index = 1;
        boolean isUp = true;
        while (row != matrix.length - 1 || column != matrix[0].length - 1) {
            array[index] = matrix[row][column];
            index++;
            if (isUp) {
                if (row == 0) {
                    column++;
                    isUp = false;
                } else if (column + 1 == matrix[0].length) {
                    row++;
                    isUp = false;
                }
                else {
                    row--;
                    column++;
                }
            }
            else {
                if (row + 1 == matrix.length) {
                    column++;
                    isUp = true;
                } else if (column == 0) {
                    row++;
                    isUp = true;
                }
                else {
                    row++;
                    column--;
                }
            }
        }
        if (index != array.length) {
            array[index] = matrix[row][column];
        }
        return isArraySorted(array);
    }

    public static boolean isArraySorted(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean isGrowing = array[1] > array[0];
        if (array[1] == array[0]) {
            return false;
        }
        for (int i = 2; i < array.length; i++) {
            if ((array[i] > array[i - 1]) != isGrowing || array[i] == array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
