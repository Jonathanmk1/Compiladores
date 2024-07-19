package Proyecto_analizador_sintatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Proceso extends javax.swing.JPanel {

    public Proceso() {
        initComponents();
        Presentacion();
    }

    private void Presentacion() {
        // Configuración del layout del panel
        setLayout(new BorderLayout());

        // Crear y configurar el área de texto para entrada
        inputArea = new JTextArea(3, 50);
        inputArea.setBorder(BorderFactory.createTitledBorder("Ingrese una cadena:"));
        JScrollPane inputScroll = new JScrollPane(inputArea);

        // Crear y configurar el área de texto para salida
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Resultado:"));
        JScrollPane outputScroll = new JScrollPane(outputArea);

        // Crear el botón para procesar
        processButton = new JButton("Procesar");

        // Agregar la acción al botón
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputArea.getText().trim();
                if (!input.isEmpty()) {
                    procesarCadena(input);
                } else {
                    JOptionPane.showMessageDialog(Proceso.this, "Por favor ingrese una cadena.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir componentes al panel
        add(inputScroll, BorderLayout.NORTH);
        add(outputScroll, BorderLayout.CENTER);
        add(processButton, BorderLayout.SOUTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private static final String[][] matriz = {
        {" ", "class", "{", "}", ";", "a", "b", "c", "$", "int", "string", "P", "C", "M", "V", "I", "T"},
        {"0", "d3", "", "", "", "", "", "", "", "", "", "1", "2", "", "", "", ""},
        {"1", "", "", "", "", "", "", "", "acepta", "", "", "", "", "", "", "", ""},
        {"2", "", "", "", "", "", "", "", "r1", "", "", "", "", "", "", "", ""},
        {"3", "", "", "", "", "d6", "d7", "d8", "", "", "", "", "", "4", "", "5", ""},
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

                // Corregir la manipulación de `estadoActual` para quitar símbolos completos
                // Calcular cuántos caracteres eliminar basados en el número de símbolos, no caracteres
                int symbolsToRemove = rhsSimbolos.length * 2; // número de elementos a quitar (símbolo y estado para cada uno)
                String[] estadoActualTokens = estadoActual.toString().split(" ");

                // Crear un nuevo StringBuilder excluyendo los últimos tokens que corresponden a rhsSimbolos
                StringBuilder nuevoEstadoActual = new StringBuilder();
                for (int i = 0; i < estadoActualTokens.length - symbolsToRemove; i++) {
                    nuevoEstadoActual.append(estadoActualTokens[i]).append(" ");
                }

                // Quitar el espacio adicional al final y añadir el nuevo símbolo y estado
                nuevoEstadoActual.setLength(nuevoEstadoActual.length() - 1);
                nuevoEstadoActual.append(" ").append(lhs).append(" ").append(gotoEstado);

                // Actualizar estadoActual con el nuevo valor corregido
                estadoActual = nuevoEstadoActual;

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

//    // main para pruebas rápidas del GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("Procesamiento de Cadenas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(new Proceso());
        frame.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton processButton;
}
