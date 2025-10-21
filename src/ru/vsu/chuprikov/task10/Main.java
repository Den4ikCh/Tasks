package ru.vsu.chuprikov.task10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(new PointDouble(0, 0), new PointDouble(3, 0), new PointDouble(0, 4));
        Triangle triangle2 = new Triangle(new PointDouble(1, 1), new PointDouble(4, 1), new PointDouble(1, 5));
        Triangle triangle3 = new Triangle(new PointDouble(0, 0), new PointDouble(0, 8), new PointDouble(6, 0));
        Triangle triangle4 = new Triangle(new PointDouble(0, 0), new PointDouble(2, 2), new PointDouble(4, 0));
        Triangle triangle5 = new Triangle(new PointDouble(0, 0), new PointDouble(-10, 10), new PointDouble(0, 20));
        Triangle triangle6 = new Triangle(new PointDouble(0, 0), new PointDouble(0, -5), new PointDouble(2.5, -2.5));
        Triangle triangle7 = new Triangle(new PointDouble(0, 0), new PointDouble(3, 4), new PointDouble(5, 6));
        List<Triangle> list = new ArrayList(List.of(triangle1, triangle2, triangle3, triangle4, triangle5, triangle6, triangle7));
        List<List<Triangle>> result = getSimilarTriangles(list);
        for (List<Triangle> triangles : result) {
            System.out.print("{");
            for (Triangle triangle : triangles) {
                System.out.printf("%s, ", triangle);
            }
            System.out.println("}");
        }
    }

    public static List<List<Triangle>> getSimilarTriangles(List<Triangle> list) {
        List<List<Triangle>> result = new ArrayList<>();
        while (list.size() > 0) {
            List<Triangle> temp = new ArrayList<>();
            temp.add(list.remove(0));
            for (int i = 0; i < list.size(); i++) {
                if (temp.getFirst().isSimilarToTriangle(list.get(i))) {
                    temp.add(list.remove(i));
                    i--;
                }
            }
            result.add(temp);
        }
        return result;
    }
}
