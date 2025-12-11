package ru.vsu.chuprikov.task12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    static String path = System.getProperty("user.dir") + "\\src\\ru\\vsu\\chuprikov\\task12\\";

    public static void printTriangleInFile(char[][] symbols, String fileName) {
        File file = new File(path + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int x = 0; x < symbols.length; x++) {
                for (int y = 0; y < symbols[0].length; y++) {
                    fileWriter.write(symbols[x][y]);
                }
                fileWriter.write('\n');
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int readNumberFromFile(String fileName) throws NumberFormatException {
        File file = new File(path + fileName);
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            String string = new String(buffer);
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new NumberFormatException();
    }
}
