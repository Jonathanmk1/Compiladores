
package ANALISIS_SINTACTICO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Prueba extends JFrame implements ActionListener {
    private JTextArea codeArea;
    private JTable tokenTable;
    private DefaultTableModel tableModel;

    // Palabras reservadas en Java
    private HashSet<String> reservedWords = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", 
            "char", "class", "const", "continue", "default", "do", "double", "else", 
            "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", 
            "import", "instanceof", "int", "interface", "long", "native", "new", "null", 
            "package", "private", "protected", "public", "return", "short", "static", "strictfp", 
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", 
            "volatile", "while", "Pantalla", "pant"
    ));
    public Prueba() {
        super("Analizador Léxico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Oculta la barra de título y los bordes de la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Establece el estado de la ventana a pantalla completa
        setLayout(new BorderLayout());

        // Crear JTextArea para el código
        codeArea = new JTextArea();
        JScrollPane codeScrollPane = new JScrollPane(codeArea);
        codeScrollPane.setPreferredSize(new Dimension(300, 300));

        // Crear JTable para mostrar los tokens
        tokenTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"ID Tokens", "Tokens", "Lexemas", "Línea"}, 0);
        tokenTable.setModel(tableModel);
        JScrollPane tokenScrollPane = new JScrollPane(tokenTable);
        tokenScrollPane.setPreferredSize(new Dimension(300, 300));

        // Crear botón para analizar el código
        JButton analyzeButton = new JButton("Analizar");
        analyzeButton.addActionListener(this);

        // Crear botón para borrar el código
        JButton clearButton = new JButton("Borrar Código");
        clearButton.addActionListener(this);

        // Crear botón para el análisis sintáctico
        JButton syntacticAnalysisButton = new JButton("Análisis Sintáctico");
        syntacticAnalysisButton.addActionListener(this);

        // Crear botón para cerrar el programa
        JButton closeButton = new JButton("Cerrar Programa");
        closeButton.addActionListener(this);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(analyzeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(syntacticAnalysisButton);
        buttonPanel.add(closeButton);

        // Agregar componentes al JFrame
        add(codeScrollPane, BorderLayout.NORTH);
        add(tokenScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Analizar")) {
            analyzeCode();
        } else if (e.getActionCommand().equals("Borrar Código")) {
            codeArea.setText("");
            tableModel.setRowCount(0);
        } else if (e.getActionCommand().equals("Cerrar Programa")) {
            dispose(); // Cierra la ventana
            System.exit(0); // Termina la aplicación
        } else if (e.getActionCommand().equals("Análisis Sintáctico")) {
            dispose();
            TABLA_SINTACTICA a = new TABLA_SINTACTICA(codeArea.getText()); // Pasar el texto a Prin
        }
    }

    private void analyzeCode() {
        // Limpiar la tabla
        tableModel.setRowCount(0);

        // Obtener el código de la JTextArea
        String inputString = codeArea.getText();

        // Crear un StringTokenizer con los delimitadores que queremos considerar
        StringTokenizer tokenizer = new StringTokenizer(inputString, " \t\n\r\f()+-*/;\"<>=", true);

        // Contador de líneas
        int lineNumber = 1;

        // Iterar sobre los tokens
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            // Identificar el tipo de token y agregarlo a la tabla
            if (reservedWords.contains(token)) {
                tableModel.addRow(new Object[]{1, "Palabra reservada", token, lineNumber});
            } else if (Character.isLetter(token.charAt(0)) || token.charAt(0) == '_') {
                tableModel.addRow(new Object[]{2, "Identificador", token, lineNumber});
            } else if (Character.isDigit(token.charAt(0))) {
                tableModel.addRow(new Object[]{3, "Número", token, lineNumber});
            } else if (token.equals("(")) {
                tableModel.addRow(new Object[]{5, "Paréntesis inicial", token, lineNumber});
            } else if (token.equals(")")) {
                tableModel.addRow(new Object[]{6, "Paréntesis final", token, lineNumber});
            } else if (token.equals(";")) {
                tableModel.addRow(new Object[]{7, "Punto y coma", token, lineNumber});
            } else if (token.equals("+") || token.equals("-") || token.equals("m") || token.equals("d")) {
                tableModel.addRow(new Object[]{8, "Operador aritmético", token, lineNumber});
            } else if (token.equals("\"")) {
                tableModel.addRow(new Object[]{9, "Comillas", token, lineNumber});
            } else if (token.equals("<") || token.equals(">") || token.equals("<=") || token.equals(">=") || token.equals("==") || token.equals("!=")) {
                tableModel.addRow(new Object[]{11, "Operador relacional", token, lineNumber});
            } else if (token.equals(" ")) {
                tableModel.addRow(new Object[]{12, "Espacio", token, lineNumber});
            } else if (token.equals("//")) {
                // Ignorar el comentario de una línea
                tokenizer.nextToken("\n");
            } else if (token.equals("/*")) {
                // Ignorar el comentario de varias líneas
                while (tokenizer.hasMoreTokens()) {
                    String nextToken = tokenizer.nextToken();
                    if (nextToken.equals("*/") || nextToken.equals(" */")) {
                        break;
                    }
                }
            } else {
                tableModel.addRow(new Object[]{4, "Símbolo", token, lineNumber});
            }

            // Incrementar el contador de líneas si el token es un salto de línea
            if (token.equals("\n")) {
                lineNumber++;
            }
        }
    }

    // Método para obtener el texto del codeArea
    public String getCodeAreaText() {
        return codeArea.getText();
    }

    public static void main(String[] args) {
        new Prueba();
    }
}
