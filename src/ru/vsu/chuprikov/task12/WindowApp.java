package ru.vsu.chuprikov.task12;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WindowApp extends JFrame {
    private String path = System.getProperty("user.dir") + "\\src\\ru\\vsu\\chuprikov\\task12\\";
    private JTextArea resultArea;
    private JTextField levelField;
    private JButton loadFromFile;
    private JButton saveToFile;
    private JButton printResult;

    public WindowApp() {
        setTitle("Треугольник Серпинского");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel controlPanel = new JPanel(new FlowLayout());
        levelField = new JTextField("1", 2);
        loadFromFile = new JButton("Загрузить пример");
        saveToFile = new JButton("Сохранить треугольник");
        printResult = new JButton("Сгенерировать треугольник");
        controlPanel.add(levelField);
        controlPanel.add(loadFromFile);
        controlPanel.add(saveToFile);
        controlPanel.add(printResult);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Результат:"));
        resultArea = new JTextArea(8, 50);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultPanel.add(resultScroll, BorderLayout.CENTER);

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
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
                levelField.setText(String.valueOf(number));
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
                FileUtils.printTriangleInFile(Recursion.drawSierpinskiTriangle(Integer.parseInt(levelField.getText())), fileChooser.getSelectedFile().getName());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ошибка сохранения файла: " + e.getMessage());
            }
        }
    }

    private void printResult() {
        try {
            if (Integer.parseInt(levelField.getText()) > 12) {
                int response = JOptionPane.showConfirmDialog(
                        this,
                        "Очень большое число, вы уверены, работа программы займёт много времени?",
                        "Подтверждение",
                        JOptionPane.YES_NO_OPTION
                );
                if (response != JOptionPane.OK_OPTION) {
                    return;
                }
            }
            StringBuilder result = new StringBuilder();
            char[][] symbols = Recursion.drawSierpinskiTriangle(Integer.parseInt(levelField.getText()));
            for (int x = 0; x < symbols.length; x++) {
                for (int y = 0; y < symbols[0].length; y++) {
                    result.append(symbols[x][y]);
                }
                result.append('\n');
            }
            resultArea.setText(result.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Введите натуральное число.");
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
