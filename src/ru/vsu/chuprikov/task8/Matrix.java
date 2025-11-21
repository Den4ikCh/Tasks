package ru.vsu.chuprikov.task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Matrix {
    static String path = System.getProperty("user.dir") + "\\src\\ru\\vsu\\chuprikov\\task8\\";

    public static int[][] readMatrixFromFile(String filename) throws FileNotFoundException {
        int[][] matrix = {};
        File file = new File(path + filename);

        if (!file.exists()) {
            throw new FileNotFoundException(filename + " not found");
        }

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, String filename) throws FileNotFoundException {
        File file = new File(path + filename);

        if (!file.exists()) {
            throw new FileNotFoundException(filename + " not found");
        }

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isMatrixSorted(int[][] matrix) {
        int row = 0, column = 0;
        int rowNext = 0, columnNext = 0;
        if (matrix.length != 1) {
            rowNext++;
        } else if (matrix[0].length != 1){
            columnNext++;
        }
        boolean isGrowing = matrix[rowNext][columnNext] > matrix[row][column];
        if (matrix[rowNext][columnNext] == matrix[row][column]) {
            return false;
        }
        boolean isUp = true;
        while (row != matrix.length - 1 || column != matrix[0].length - 1) {
            if ((matrix[rowNext][columnNext] > matrix[row][column]) != isGrowing) {
                return false;
            }
            row = rowNext;
            column = columnNext;
            if (isUp) {
                if (row == 0) {
                    columnNext++;
                    isUp = false;
                } else if (column + 1 == matrix[0].length) {
                    rowNext++;
                    isUp = false;
                }
                else {
                    rowNext--;
                    columnNext++;
                }
            }
            else {
                if (row + 1 == matrix.length) {
                    columnNext++;
                    isUp = true;
                } else if (column == 0) {
                    rowNext++;
                    isUp = true;
                }
                else {
                    rowNext++;
                    columnNext--;
                }
            }
        }
        return true;
    }
}
