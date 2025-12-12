package ru.vsu.chuprikov.task11;

import ru.vsu.chuprikov.task10.Triangle;
import ru.vsu.chuprikov.task10.TriangleFormatException;
import ru.vsu.chuprikov.task10.TriangleListUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WindowApp extends JFrame {
    private String path = System.getProperty("user.dir") + "\\src\\ru\\vsu\\chuprikov\\task11\\";
    private JTextArea inputArea;
    private JTextArea resultArea;
    private JButton loadFromFile;
    private JButton saveToFile;
    private JButton printResult;

    public WindowApp() {
        setTitle("Перевод числа в строку");
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
        printResult = new JButton("Перевести в строку");
        controlPanel.add(loadFromFile);
        controlPanel.add(saveToFile);
        controlPanel.add(printResult);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Введите текст:"));
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
                int number = FileUtils.readNumberFromFile(fileChooser.getSelectedFile().getName());
                inputArea.setText(String.valueOf(number));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ошибка загрузки файла: " + e.getMessage());
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
                int number = Integer.parseInt(inputArea.getText());
                FileUtils.writeStringToFile(fileChooser.getSelectedFile().getName(), String.valueOf(number));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ошибка сохранения файла: " + e.getMessage());
            }
        }
    }

    private void printResult() {
        try {
            String result = StringUtils.getStringRepresentation(Integer.parseInt(inputArea.getText()));
            resultArea.setText(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Введите число от 0 до 1.000.000.000 без пробелов и других символов.");
        }
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