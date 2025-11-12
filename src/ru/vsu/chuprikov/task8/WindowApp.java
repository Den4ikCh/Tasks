package ru.vsu.chuprikov.task8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;


public class WindowApp extends JFrame {
    private String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task8";
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField rowsField;
    private JTextField colsField;

    public WindowApp() {
        setTitle("Проверка упорядоченности матрицы");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        rowsField = new JTextField("3", 3);
        colsField = new JTextField("3", 3);

        JButton createTableBtn = new JButton("Задать размер таблицы");
        JButton loadBtn = new JButton("Загрузить из файла");
        JButton saveBtn = new JButton("Сохранить в файл");
        JButton checkBtn = new JButton("Проверить матрицу");

        controlPanel.add(new JLabel("Строки:"));
        controlPanel.add(rowsField);
        controlPanel.add(new JLabel("Столбцы:"));
        controlPanel.add(colsField);
        controlPanel.add(createTableBtn);
        controlPanel.add(loadBtn);
        controlPanel.add(saveBtn);
        controlPanel.add(checkBtn);

        tableModel = new DefaultTableModel(3, 3) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Integer.class;
            }
        };
        table = new JTable(tableModel);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableModel.setValueAt(0, i, j);
            }
        }
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        createTableBtn.addActionListener(e -> createTable());
        loadBtn.addActionListener(e -> loadFromFile());
        saveBtn.addActionListener(e -> saveToFile());
        checkBtn.addActionListener(e -> checkOrdering());
    }

    private void createTable() {
        try {
            int rows = Integer.parseInt(rowsField.getText());
            int cols = Integer.parseInt(colsField.getText());
            if (rows <= 0 || cols <= 0) {
                throw new Exception();
            }

            tableModel.setRowCount(rows);
            tableModel.setColumnCount(cols);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    tableModel.setValueAt(0, i, j);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Введите натуральное число");
        }
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
                int[][] array = Matrix.readMatrixFromFile(fileChooser.getSelectedFile().getName());
                displayArrayInTable(array);
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
                int[][] array = readArrayFromTable();
                Matrix.printMatrix(array, fileChooser.getSelectedFile().getName());
                JOptionPane.showMessageDialog(this, "Файл успешно сохранен");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка сохранения файла: " + ex.getMessage());
            }
        }
    }

    private void checkOrdering() {
        try {
            int[][] array = readArrayFromTable();
            boolean result = Matrix.isMatrixSorted(array);
            String message = "Элементы матрицы не образуют упорядоченную последовательность.";
            if (result) {
                message = "Элементы матрицы образуют упорядоченную последовательность.";
            }
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Все элементы должны быть целыми числами");
        }
    }

    private int[][] readArrayFromTable() {
        int rows = tableModel.getRowCount();
        int cols = tableModel.getColumnCount();
        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = Integer.parseInt(tableModel.getValueAt(i, j).toString());
                array[i][j] = value;
            }
        }

        return array;
    }

    private void displayArrayInTable(int[][] array) {
        tableModel.setRowCount(array.length);
        tableModel.setColumnCount(array.length > 0 ? array[0].length : 0);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                tableModel.setValueAt(array[i][j], i, j);
            }
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