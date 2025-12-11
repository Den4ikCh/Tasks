package ru.vsu.chuprikov.task11;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        try {
            String result = StringUtils.getStringRepresentation(FileUtils.readNumberFromFile(inputArgs.inputFile));
            FileUtils.writeStringToFile(inputArgs.outputFile, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
