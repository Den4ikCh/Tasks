package ru.vsu.chuprikov.task9;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WindowApp extends JFrame {
    private String path = System.getProperty("user.dir") + "\\src\\ru\\vsu\\chuprikov\\task9\\";
    private JTextArea inputArea;
    private JTextArea resultArea;
    private JButton loadFromFile;
    private JButton saveToFile;
    private JButton printResult;

    public WindowApp() {
        setTitle("Сортировка листа по встречаемости элементов");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel controlPanel = new JPanel(new FlowLayout());
        loadFromFile = new JButton("Загрузить пример");
        saveToFile = new JButton("Сохранить");
        printResult = new JButton("Проверить лист");
        controlPanel.add(loadFromFile);
        controlPanel.add(saveToFile);
        controlPanel.add(printResult);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Введите числа через пробел:"));
        inputArea = new JTextArea(5, 50);
        inputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputPanel.add(inputScroll, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Результат:"));
        resultArea = new JTextArea(8, 50);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultPanel.add(resultScroll, BorderLayout.CENTER);

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        add(mainPanel);

        loadFromFile.addActionListener(e -> loadFromFile());
        saveToFile.addActionListener(e -> saveToFile());
        printResult.addActionListener(e -> printResult());
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser(path);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Текстовые файлы (*.txt)";
            }
        });

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                List<Integer> list = ListUtils.readListFromFile(fileChooser.getSelectedFile().getName());
                inputArea.setText(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка загрузки файла: " + ex.getMessage());
            }
        }
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser(path);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Текстовые файлы (*.txt)";
            }
        });

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                List<Integer> list = readListFromWindow();
                ListUtils.printList(fileChooser.getSelectedFile().getName(), list);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка сохранения файла: " + ex.getMessage());
            }
        }
    }

    private void printResult() {
        try {
            List<Integer> result = ListUtils.createNewList(readListFromWindow());
            resultArea.setText(result.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Неверный формат, введите только целые числа, через один пробел");
        }
    }

    private List<Integer> readListFromWindow() throws NumberFormatException {
        String input = inputArea.getText();
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowApp().setVisible(true);
            }
        });
    }
}