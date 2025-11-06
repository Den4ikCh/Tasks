package ru.vsu.chuprikov.task10;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        try {
            List<Triangle> triangles = TriangleListUtils.readTrianglesFromFile(inputArgs.inputFile);
            List<List<Triangle>> result = TriangleListUtils.getSimilarTriangles(triangles);
            TriangleListUtils.printTriangles(result, inputArgs.outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
