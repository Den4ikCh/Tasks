package ru.vsu.chuprikov.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    static String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task9\\";

    public static List<Integer> createNewList(List<Integer> list) {
        List<Integer> count = new ArrayList<>();
        for (Integer number : list) {
            count.add(countOf(list, number));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (count.get(j) < count.get(j + 1)) {
                    Collections.swap(count, j, j + 1);
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        int indexFrom = 0;
        int indexTo = 0;
        for (int i = 1; i < list.size(); i++) {
            if (count.get(i) == count.get(i - 1)) {
                indexTo++;
            }
            else {
                if (count.get(i - 1) != indexTo - indexFrom + 1) {
                    sort(list, indexFrom, indexTo);
                }
                indexFrom = i;
                indexTo = i;
            }
        }
        if (count.get(list.size() - 1) != indexTo - indexFrom + 1) {
            sort(list, indexFrom, indexTo);
        }
        return list;
    }

    public static int countOf(List<Integer> list, int value) {
        int count = 0;
        for (Integer number : list) {
            if (number == value) {
                count++;
            }
        }
        return count;
    }

    public static void sort(List<Integer> list, int index1, int index2) {
        for (int i = 0; i < index2 - index1; i++) {
            for (int j = index1; j < index2 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    public static List<Integer> readListFromFile(String fileName) throws FileNotFoundException {
        List<Integer> list = new ArrayList<>();
        File file = new File(path + fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " not found");
        }

        try (FileReader fileReader = new FileReader(file)) {
            String number = "";
            char[] array = new char[(int) file.length()];
            fileReader.read(array);
            for (char c : array) {
                if (c >= '0' && c <= '9') {
                    number += c;
                } else if (c == '-') {
                    number = "-";
                } else if (number != "") {
                    list.add(Integer.parseInt(number));
                    number = "";
                }
            }
            list.add(Integer.parseInt(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void printList(String fileName, List<Integer> list) throws FileNotFoundException {
        File file = new File(path + fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " not found");
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}