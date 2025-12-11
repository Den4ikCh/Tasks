package ru.vsu.chuprikov.task12;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        try {
            int levelOfRecursion = FileUtils.readNumberFromFile(inputArgs.inputFile);
            char[][] symbols = Recursion.drawSierpinskiTriangle(levelOfRecursion);
            FileUtils.printTriangleInFile(symbols, inputArgs.outputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
