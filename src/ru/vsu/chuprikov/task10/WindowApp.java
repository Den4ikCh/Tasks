package ru.vsu.chuprikov.task10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WindowApp extends JFrame {
    private String path = "C:\\Scripts\\Java\\Tasks\\src\\ru\\vsu\\chuprikov\\task10";
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextArea resultArea;
    private JButton loadFromFile;
    private JButton saveToFile;
    private JButton printResult;
    private JButton addRowButton;

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
        addRowButton = new JButton("Добавить треугольник");
        loadFromFile = new JButton("Загрузить пример");
        saveToFile = new JButton("Сохранить");
        printResult = new JButton("Найти подобные");
        controlPanel.add(addRowButton);
        controlPanel.add(loadFromFile);
        controlPanel.add(saveToFile);
        controlPanel.add(printResult);

        createTable();
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Результат:"));
        resultArea = new JTextArea(8, 100);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultPanel.add(resultScroll, BorderLayout.CENTER);

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        add(mainPanel);

        loadFromFile.addActionListener(e -> loadFromFile());
        saveToFile.addActionListener(e -> saveToFile());
        printResult.addActionListener(e -> printResult());
        addRowButton.addActionListener(e -> addNewRow());
    }

    private void createTable() {
        String[] columnNames = {"A x", "A y", "B x", "B y", "C x", "C y"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Double.class;
            }
        };

        table = new JTable(tableModel);
        table.setRowHeight(25);
        addNewRow();
    }

    private void addNewRow() {
        tableModel.addRow(new Object[]{0, 0, 0, 0, 0, 0});
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
                List<Triangle> list = TriangleListUtils.readTrianglesFromFile(fileChooser.getSelectedFile().getName());
                setTrianglesToTable(list);
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
                List<Triangle> list = readTrianglesFromTable();
                TriangleListUtils.saveTrianglesToFile(list, fileChooser.getSelectedFile().getName());
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка сохранения файла: " + ex.getMessage());
            }
        }
    }

    private void printResult() {
        try {
            List<Triangle> list = readTrianglesFromTable();
            List<List<Triangle>> result = TriangleListUtils.getSimilarTriangles(list);
            String resultText = "";
            for (int i = 0; i < result.size(); i++) {
                resultText += String.format("%d-й набор подобных треугольников: ", i + 1);
                for (int j = 0; j < result.get(i).size(); j++) {
                    resultText += result.get(i).get(j).toString();
                    if (j != result.get(i).size() - 1) {
                        resultText += ", ";
                    } else {
                        resultText += ".\n";
                    }
                }
            }
            resultArea.setText(resultText);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + ".");
        }
    }

    private List<Triangle> readTrianglesFromTable() throws TriangleFormatException {
        List<Triangle> list = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            PointDouble[] points = new PointDouble[3];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                Double value = Double.parseDouble(tableModel.getValueAt(i, j).toString());
                if (j % 2 == 0) {
                    points[j / 2] = new PointDouble(value, 0);
                } else {
                    points[j / 2].setY(value);
                }
            }
            list.add(new Triangle(points[0], points[1], points[2]));
        }
        return list;
    }

    private void setTrianglesToTable(List<Triangle> triangles) {
        tableModel.setRowCount(triangles.size());
        for (int i = 0; i < triangles.size(); i++) {
            int j = 0;
            PointDouble[] points = {triangles.get(i).getPointA(), triangles.get(i).getPointB(), triangles.get(i).getPointC()};
            for (PointDouble point : points) {
                tableModel.setValueAt(point.getX(), i, j++);
                tableModel.setValueAt(point.getY(), i, j++);
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
