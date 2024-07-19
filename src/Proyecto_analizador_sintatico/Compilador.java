package Proyecto_analizador_sintatico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compilador extends JFrame {
    private JTextArea jtextarea;     // Area de texto para la entrada del usuario
    private JTable jTable1;          // Tabla para mostrar los tokens del analizador léxico
    private JTextArea outputArea;    // Area de texto para mostrar el resultado del analizador sintáctico
    private JButton btnProcesar;     // Botón para iniciar el proceso
    private JButton btnBorrar;       // Botón para borrar la entrada y resultados
    private JTabbedPane tabbedPane;  // Pestañas para cambiar entre léxico y sintáctico

    public Compilador() {
        setTitle("Compilador - Analizador Léxico y Sintáctico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Área de texto para la entrada del usuario
        jtextarea = new JTextArea(10, 50);
        JScrollPane inputScrollPane = new JScrollPane(jtextarea);

        // Tabla para mostrar los tokens del analizador léxico
        jTable1 = new JTable(new DefaultTableModel(new Object[]{"ID", "Tipo", "Valor", "Línea"}, 0));
        JScrollPane tableScrollPane = new JScrollPane(jTable1);

        // Área de texto para mostrar el resultado del analizador sintáctico
        outputArea = new JTextArea(10, 50);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        // Panel de pestañas para cambiar entre los resultados del analizador léxico y el sintáctico
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Análisis Léxico", tableScrollPane);
        tabbedPane.addTab("Análisis Sintáctico", outputScrollPane);

        // Botones para procesar y borrar
        btnProcesar = new JButton("Procesar");
        btnBorrar = new JButton("Borrar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnProcesar);
        buttonPanel.add(btnBorrar);

        mainPanel.add(inputScrollPane, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Acción del botón "Procesar"
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarTexto();
            }
        });

        // Acción del botón "Borrar"
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtextarea.setText("");
                ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
                outputArea.setText("");
            }
        });
    }

    private void procesarTexto() {
        String texto = jtextarea.getText();
        
        // Primero, procesar el análisis léxico
        ArrayList<Token> tokens = Pruebas.lex(texto);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Token token : tokens) {
            Object[] rowData = new Object[4];
            rowData[0] = token.getId();
            rowData[1] = token.getTipo();
            rowData[2] = token.getValor();
            int offset = jtextarea.getText().indexOf(token.getValor());
            int linea = 1;
            try {
                linea = jtextarea.getLineOfOffset(offset) + 1;
            } catch (BadLocationException ex) {
                Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowData[3] = linea;
            model.addRow(rowData);
        }

        // Después, procesar el análisis sintáctico
        procesarCadena(texto);
    }

    private static final String[][] matriz = {
        {" ", "class", "{", "}", ";", "a", "b", "c", "$", "int", "string", "P", "C", "M", "V", "I", "T"},
        {"0", "d3", "", "", "", "", "", "", "", "", "", "1", "2", "", "", "", ""},
        {"1", "", "", "", "", "", "", "", "acepta", "", "", "", "", "", "", "", ""},
        {"2", "", "", "", "", "", "", "", "r1", "", "", "", "", "", "", "", ""},
        {"3", "", "", "", "", "d6", "d7", "d8", "", "", "", "", "", "", "4", "", "5", ""},
        {"4", "", "", "", "", "", "", "", "r2", "", "", "", "", "", "", "", ""},
        {"5", "", "d9", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"6", "", "r6", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"7", "", "r7", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"8", "", "r8", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"9", "", "", "r4", "", "", "", "", "", "d12", "d12", "", "", "", "10", "", "11"},
        {"10", "", "", "d19", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"11", "", "", "", "", "", "d17", "", "", "", "", "", "", "", "", "15", ""},
        {"12", "", "", "", "", "d16", "r9", "d18", "", "", "", "", "", "", "", "15", ""},
        {"13", "", "", "", "", "r10", "r10", "r10", "", "", "", "", "", "", "", "", ""},
        {"14", "", "", "", "", "r11", "r11", "r11", "", "", "", "", "", "", "", "", ""},
        {"15", "", "", "", "d19", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"16", "", "", "", "r6", "", "", "", "r6", "", "", "", "", "", "", "", ""},
        {"17", "", "", "", "r7", "r5", "r5", "r5", "", "", "", "", "", "", "", "", ""},
        {"18", "", "", "", "r8", "", "", "", "r8", "", "", "", "", "", "", "", ""},
        {"19", "", "", "r5", "", "", "", "", "r3", "", "", "", "", "", "", "", ""},
        {"20", "", "", "d19", "", "", "", "", "r5", "", "", "", "", "", "", "", ""}
    };

    private static final String[] reglas = {
        "", // Regla 0 no usada
        "P -> C", // Regla 1
        "C -> class M", // Regla 2
        "M -> I { V }", // Regla 3
        "V -> ε", // Regla 4
        "V -> T I ;", // Regla 5
        "I -> a", // Regla 6
        "I -> b", // Regla 7
        "I -> c", // Regla 8
        "T -> int", // Regla 9
        "T -> string" // Regla 10
    };

    private static int pos_colm_en_mat(String simb_dado) {
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(simb_dado)) {
                return i;
            }
        }
        return -1;
    }

    private void procesarCadena(String input) {
        Stack<Integer> pila = new Stack<>();
        pila.push(0); // Estado inicial
        input += " $"; // Agregamos el símbolo de fin de cadena

        // Dividimos la cadena en tokens usando cualquier espacio en blanco como delimitador
        String[] tokens = input.split("\\s+");

        int index = 0;

        // Lista para mantener el rastreo de los estados procesados
        StringBuilder estadoActual = new StringBuilder("$ 0");

        StringBuilder output = new StringBuilder();
        output.append(String.format("%-40s %-40s %-40s\n", "Estado Actual", "Pila", "Accion"));

        while (true) {
            int estadoActualNum = pila.peek();
            String tokenActual = tokens[index];
            int colIndex = pos_colm_en_mat(tokenActual);

            if (colIndex == -1) {
                output.append(String.format("%-50s %-50s %-50s\n", estadoActual, String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)), "símbolo no encontrado "));
                break;
            }

            String accion = matriz[estadoActualNum + 1][colIndex];

            output.append(String.format("%-50s %-50s %-50s\n", estadoActual, String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)), accion));

            if (accion == null || accion.isEmpty()) {
                output.append(String.format("%-50s %-50s %-50s\n", estadoActual, String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)), "Error: no hay acción definida"));
                break;
            }

            if (accion.startsWith("d")) { // Desplazar (shift)
                int nuevoEstado = Integer.parseInt(accion.substring(1));
                pila.push(colIndex); // símbolo
                pila.push(nuevoEstado); // nuevo estado

                // Actualizar el estado procesado para mostrar el estado actual acumulado
                estadoActual.append(" ").append(tokenActual).append(" ").append(nuevoEstado);
                index++;
            } else if (accion.startsWith("r")) { // Reducir (reduce)
                int numRegla = Integer.parseInt(accion.substring(1));
                String regla = reglas[numRegla];
                String[] partesRegla = regla.split(" -> ");
                String lhs = partesRegla[0];
                String rhs = partesRegla[1];
                String[] rhsSimbolos = rhs.equals("ε") ? new String[0] : rhs.split(" ");

                // Sacar de la pila 2 veces el número de símbolos en el lado derecho
                for (int i = 0; i < rhsSimbolos.length * 2; i++) {
                    pila.pop();
                }

                int estadoAnterior = pila.peek();
                int lhsColIndex = pos_colm_en_mat(lhs);
                String gotoAccion = matriz[estadoAnterior + 1][lhsColIndex];

                if (gotoAccion == null || gotoAccion.isEmpty()) {
                    output.append(String.format("%-50s %-50s %-50s\n", estadoActual, lhs, "Error: no hay acción de goto definida"));
                    break;
                }

                int gotoEstado = Integer.parseInt(gotoAccion);
                pila.push(lhsColIndex); // símbolo
                pila.push(gotoEstado); // nuevo estado

                // Actualizar el estado procesado para mostrar el estado actual acumulado
                // Actualiza el estado actual quitando los últimos rhsSimbolos*2 caracteres y agregando el nuevo estado y símbolo
                int lengthToTrim = (rhsSimbolos.length * 2) * 2 + rhsSimbolos.length; // numero de elementos a quitar
                estadoActual.setLength(estadoActual.length() - lengthToTrim);
                estadoActual.append(" ").append(lhs).append(" ").append(gotoEstado);

            } else if (accion.equals("acepta")) {
                output.append(String.format("%-50s %-50s %-50s\n", estadoActual, String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)), "Cadena aceptada"));
                break;
            } else {
                output.append(String.format("%-50s %-50s %-50s\n", estadoActual, String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)), "Error: acción no reconocida"));
                break;
            }
        }

        outputArea.setText(output.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Compilador().setVisible(true);
            }
        });
    }
}
