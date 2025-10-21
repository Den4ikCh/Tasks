package ru.vsu.chuprikov.task8;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;

import java.io.*;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        int[][] matrix = Matrix.readMatrixFromFile(inputArgs.inputFile);
        printResult(matrix, inputArgs.outputFile);
    }

    public static void printResult(int[][] matrix, String filename) {
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8\\";
        File file = new File(path + filename);
        try (FileWriter fileWriter = new FileWriter(file)) {
            boolean result = Matrix.isMatrixSorted(matrix);
            if (result) {
                fileWriter.write("Элементы матрицы образуют упорядоченную последовательность.");
            } else {
                fileWriter.write("Элементы матрицы не образуют упорядоченную последовательность.");
            }
        }
        catch (Exception e) { }
    }
}
