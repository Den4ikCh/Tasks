package ru.vsu.chuprikov.task10;

import ru.vsu.chuprikov.utils.ConsoleUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TriangleListUtils {
    static String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task10\\";

    public static List<List<Triangle>> getSimilarTriangles(List<Triangle> list) {
        List<List<Triangle>> result = new ArrayList<>();
        while (list.size() > 0) {
            List<Triangle> temp = new ArrayList<>();
            temp.add(list.remove(0));
            for (int i = 0; i < list.size(); i++) {
                if (temp.get(0).isSimilarToTriangle(list.get(i))) {
                    temp.add(list.remove(i));
                    i--;
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void printTriangles(List<List<Triangle>> list, String fileName) {
        File file = new File(path + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(String.format("%d-й набор подобных треугольников: ", i + 1));
                for (int j = 0; j < list.get(i).size(); j++) {
                    fileWriter.write(list.get(i).get(j).toString());
                    if (j != list.get(i).size() - 1) {
                        fileWriter.write(", ");
                    } else {
                        fileWriter.write(".\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTrianglesToFile(List<Triangle> list, String fileName) {
        File file = new File(path + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i).getPointA().toString() + ' ');
                fileWriter.write(list.get(i).getPointB().toString() + ' ');
                fileWriter.write(list.get(i).getPointC().toString());
                if (i != list.size() - 1) {
                    fileWriter.write('\n');
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Triangle> readTrianglesFromFile(String fileName) throws TriangleFormatException {
        File file = new File(path + fileName);
        List<Triangle> triangles = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            char[] array = new char[(int) file.length()];
            fileReader.read(array);
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
        } catch (TriangleFormatException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return triangles;
    }

    public static Triangle readTriangleFromString(String input) throws TriangleFormatException {
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
