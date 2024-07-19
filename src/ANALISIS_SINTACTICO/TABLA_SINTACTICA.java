package ANALISIS_SINTACTICO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class TABLA_SINTACTICA {
    private JTextArea inputArea;

    public TABLA_SINTACTICA(String codeAreaText) {
        GLC grammar = new GLC();
        parser parser = new parser(grammar);

        JFrame frame = new JFrame("Parser de Gramática");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        inputArea = new JTextArea(5, 20);
        inputArea.setText(codeAreaText); // Establecer el texto recibido
        JTextArea outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        JButton parseButton = new JButton("Analizar");
        JButton closeButton = new JButton("Regresar");

        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputArea.getText();
                outputArea.setText(""); // Limpiar el área de salida antes de cada análisis
                parser.parse(input, outputArea);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Prueba a = new Prueba();
            }
        });

        JTable syntacticTable = new JTable();
        DefaultTableModel syntacticTableModel = new DefaultTableModel(new Object[]{" ", "class", "{", "}", ";", "a", "b", "c", "int", "string", "$", "P", "C", "M", "V", "I", "T"}, 0);
        syntacticTable.setModel(syntacticTableModel);
        JScrollPane syntacticTableScrollPane = new JScrollPane(syntacticTable);
        syntacticTableScrollPane.setPreferredSize(new Dimension(750, 420));
        syntacticTableModel.addRow(new Object[]{0, "d3", "", "", "", "", "", "", "", "", "", "1", "2", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{1, "", "", "", "", "", "", "", "", "", "Acepta", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{2, "", "", "", "", "", "", "", "", "R1", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{3, "", "", "", "", "d6", "d7", "d8", "", "", "", "", "", "4", "", "5", ""});
        syntacticTableModel.addRow(new Object[]{4, "", "", "", "", "", "", "", "", "R2", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{5, "", "d9", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{6, "", "R6", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{7, "", "R7", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{8, "", "R8", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{9, "", "", "", "", "", "", "", "d14", "d15", "", "", "", "", "10", "", "13"});
        syntacticTableModel.addRow(new Object[]{10, "", "", "", "", "", "", "", "", "", "R3", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{11, "", "", "", "", "", "", "", "", "", "R3", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{12, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{13, "", "", "", "", "d18", "d19", "d20", "", "", "", "", "", "", "", "16", ""});
        syntacticTableModel.addRow(new Object[]{14, "", "", "", "", "R9", "R9", "R9", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{15, "", "", "", "", "R10", "R10", "R10", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{16, "", "", "", "d17", "", "", "", "", "", "", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{17, "", "", "", "", "", "", "", "", "", "R5", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{18, "", "", "", "", "", "", "", "", "", "R6", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{19, "", "", "", "", "", "", "", "", "", "R7", "", "", "", "", "", ""});
        syntacticTableModel.addRow(new Object[]{20, "", "", "", "", "", "", "", "", "", "R8", "", "", "", "", "", ""});



        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(inputArea);
        panel.add(outputArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(parseButton);
        buttonPanel.add(closeButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(syntacticTableScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Prueba proFi = new Prueba();
        String codeAreaText = proFi.getCodeAreaText();
        new TABLA_SINTACTICA(codeAreaText);
    }
}


