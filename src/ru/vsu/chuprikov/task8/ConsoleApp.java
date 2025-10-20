package ru.vsu.chuprikov.task8;

import java.io.*;
import static ru.vsu.chuprikov.task8.Matrix.*;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = parseCmdArgs(args);
        int[][] matrix = readMatrixFromFile(inputArgs.inputFile);
        printResult(matrix, inputArgs.outputFile);
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
}
