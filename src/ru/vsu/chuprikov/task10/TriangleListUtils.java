package ru.vsu.chuprikov.task10;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TriangleListUtils {
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

    public static List<Triangle> readTrianglesFromFile(String fileName) {
        String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task10\\";
        File file = new File(path + fileName);
        List<Triangle> triangles = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            char[] array = new char[(int) file.length()];
            reader.read(array);
            int indexFrom = 0;
            int indexTo = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '\n') {
                    indexTo = i;
                    String line = new String(array, indexFrom, indexTo - indexFrom);
                    triangles.add(readTriangleFromString(line));
                    indexFrom = indexTo + 1;
                }
            }
            triangles.add(readTriangleFromString(new String(array, indexFrom, array.length - indexFrom)));
        }
        catch (Exception e) { }
        return triangles;
    }

    public static Triangle readTriangleFromString(String input) {
        int indexFrom = 0;
        int indexTo = 0;
        PointDouble[] points = new PointDouble[3] ;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                indexTo = i + 1;
                points[index++] = readPointFromString(input.substring(indexFrom, indexTo));
                indexFrom = indexTo;
            }
        }
        return new Triangle(points[0], points[1], points[2]);
    }

    public static PointDouble readPointFromString(String input) {
        String[] coordinates = input.substring(input.indexOf('(') + 1, input.indexOf(')')).split("; ");
        return new PointDouble(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
    }
}
