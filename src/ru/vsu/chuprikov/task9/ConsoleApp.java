package ru.vsu.chuprikov.task9;

import ru.vsu.chuprikov.utils.ConsoleUtils;
import ru.vsu.chuprikov.utils.InputArgs;
import java.util.List;

class ConsoleApp {
    public static void main(String[] args) {
        InputArgs inputArgs = ConsoleUtils.parseCmdArgs(args);
        List<Integer> list = ListUtils.readListFromFile(inputArgs.inputFile);
        List<Integer> result = ListUtils.createNewList(list);
        ListUtils.printList(inputArgs.outputFile, result);
    }
}
