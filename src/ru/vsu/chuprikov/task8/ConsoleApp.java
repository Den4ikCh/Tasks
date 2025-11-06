package ru.vsu.chuprikov.task8;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;

import java.io.*;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        try {
            int[][] matrix = Matrix.readMatrixFromFile(inputArgs.inputFile);
            printResult(matrix, inputArgs.outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printResult(int[][] matrix, String filename) throws FileNotFoundException {
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8\\";
        File file = new File(path + filename);

        if (!file.exists()) {
            throw new FileNotFoundException(filename + " not found");
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            boolean result = Matrix.isMatrixSorted(matrix);
            if (result) {
                fileWriter.write("Элементы матрицы образуют упорядоченную последовательность.");
            } else {
                fileWriter.write("Элементы матрицы не образуют упорядоченную последовательность.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
