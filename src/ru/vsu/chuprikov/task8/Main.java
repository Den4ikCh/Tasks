package ru.vsu.chuprikov.task8;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputArgs inputArgs = parseCmdArgs(args);
        int[][] matrix = readMatrixFromFile(inputArgs.inputFile);
        printResult(matrix, inputArgs.outputFile);
    }

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
                    while (array[index] < '0' || array[index] > '9') {
                        index++;
                    }
                    while (index < array.length && array[index] >= '0' && array[index] <= '9') {
                        number += array[index];
                        index++;
                    }
                    matrix[i][j] = Integer.parseInt(number);
                    index++;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matrix;
    }

    public static void printResult(int[][] matrix, String filename) {
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8\\";
        File file = new File(path + filename);
        try (FileWriter fileWriter = new FileWriter(file)) {
            boolean result = isMatrixSorted(matrix);
            if (result) {
                fileWriter.write("Элементы матрицы образуют упорядоченную последовательность.");
            } else {
                fileWriter.write("Элементы матрицы не образуют упорядоченную последовательность.");
            }
        }
        catch (Exception e) { }
    }

    public static InputArgs parseCmdArgs(String[] args) {
        String input = null;
        String output = null;
        for (String arg : args) {
            switch (arg) {
                case "-i":
                case "--input-file=":
                    input = "";
                    break;
                case "-o":
                case "--output-file=":
                    output = "";
                    break;
                default:
                    if (input == "") {
                        input = arg;
                    } else if (output == "") {
                        output = arg;
                    }
            }
        }
        return new InputArgs(input, output);
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
