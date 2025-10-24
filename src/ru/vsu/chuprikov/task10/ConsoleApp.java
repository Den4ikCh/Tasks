package ru.vsu.chuprikov.task10;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        List<Triangle> triangles = TriangleListUtils.readTrianglesFromFile("input05.txt");
        List<List<Triangle>> result = TriangleListUtils.getSimilarTriangles(triangles);
        for (List<Triangle> triangle : result) {
            System.out.print('{');
            triangle.forEach(System.out::print);
            System.out.println('}');
        }
    }
}
