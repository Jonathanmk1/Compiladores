package Proyecto_analizador_sintatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class anz extends javax.swing.JPanel {

    public anz() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jtf_mostrar = new javax.swing.JTextField();
        btnpro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(580, 682));
        setMinimumSize(new java.awt.Dimension(580, 682));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnpro.setText("Procesar");
        btnpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproActionPerformed(evt);
            }
        });

        jLabel1.setText("INGRESE UNA CADENA: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jtf_mostrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(btnpro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)))
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnpro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproActionPerformed

        String input = jTextArea1.getText().trim();
        if (!input.isEmpty()) {
            String resultado = procesarCadena(input);
            jtf_mostrar.setText(resultado);
        } else {
            jtf_mostrar.setText("Ingrese una cadena válida.");
        }
    }//GEN-LAST:event_btnproActionPerformed
    private String procesarCadena(String input) {
        final int FILAS = 21;
        final int COLUMNAS = 17;
        String[] encabezado = {" ", "class", "{", "}", ";", "a", "b", "c", "int", "string", "$", "P", "C", "M", "V", "I", "T"};
        String[][] matriz = new String[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = " ";
            }
        }

        String[][] datos = {
            {"1", "1", "d3"},
            {"1", "11", "1"},
            {"1", "12", "2"},
            {"2", "10", "Acepta"},
            {"3", "10", "r1"},
            {"4", "5", "d6"},
            {"4", "6", "d7"},
            {"4", "7", "d8"},
            {"4", "13", "4"},
            {"4", "15", "5"},
            {"5", "10", "r2"},
            {"6", "2", "d9"},
            {"7", "2", "r6"},
            {"8", "2", "r7"},
            {"9", "2", "r8"},
            {"10", "8", "d12"},
            {"10", "9", "d13"},
            {"10", "14", "10"},
            {"10", "16", "11"},
            {"11", "3", "d14"},
            {"12", "5", "d16"},
            {"12", "6", "d17"},
            {"12", "7", "d18"},
            {"12", "15", "15"},
            {"13", "5", "r9"},
            {"13", "6", "r9"},
            {"13", "7", "r9"},
            {"14", "5", "r10"},
            {"14", "6", "r10"},
            {"14", "7", "r10"},
            {"15", "10", "r3"},
            {"16", "4", "d19"},
            {"17", "4", "r6"},
            {"18", "4", "r7"},
            {"19", "4", "r8"},
            {"20", "3", "r5"}
        };

        for (String[] dato : datos) {
            int fila = Integer.parseInt(dato[0]);
            int columna = Integer.parseInt(dato[1]);
            if (columna >= 0 && columna < COLUMNAS) {
                matriz[fila][columna] = dato[2];
            } else {
                return "Error: Columna fuera de rango.";
            }
        }
        String[][] producciones = {
            {"P", "C"}, // Regla 1
            {"C", "class M"}, // Regla 2
            {"M", "I { V }"}, // Regla 3
            {"V", ""}, // Regla 4 
            {"V", "T I ;"}, // Regla 5
            {"I", "a"}, // Regla 6
            {"I", "b"}, // Regla 7
            {"I", "c"}, // Regla 8
            {"T", "int"}, // Regla 9
            {"T", "string"} // Regla 10
        };

        Scanner s = new Scanner(input);
        Stack<Integer> pila = new Stack<>();
        pila.push(0);
        //nos va a servir pa almacen el resultado del analisis
        StringBuilder resultado = new StringBuilder();//permite realizar cambios en la cadena sin crear un nuevo objeto

        if (!input.equals("exit")) {
            input += "$";

            StringTokenizer tk = new StringTokenizer(input, " {};$", true);
            //almac tk
            List<String> tokens = new ArrayList<>();
            
            while (tk.hasMoreTokens()) {
                String token = tk.nextToken();
                if (!token.trim().isEmpty()) {
                    tokens.add(token);
                }
            }

            boolean aceptado = false;
            //recorrera la lista de tokens.
            int index = 0;

            while (index < tokens.size()) {
                String simboloTerminal = tokens.get(index);
                int columna = -1;
                for (int j = 1; j < encabezado.length; j++) {
                    if (encabezado[j].equals(simboloTerminal)) {
                        columna = j;
                        break;
                    }
                }
                //verifica si el símbolo  acual existe 
                if (columna != -1) {
                    //Obtención de la acción
                    int estadoActual = pila.peek(); //lee el tope de la pila y determuna quese hace
                    String accion = matriz[estadoActual + 1][columna];
                    if (!accion.equals(" ")) {
                        resultado.append("Acción: ").append(accion).append("\n");

                        if (accion.startsWith("d")) {
                            int nuevoEstado = Integer.parseInt(accion.substring(1));
                            pila.push(nuevoEstado);
                            // add instancia
                            resultado.append("Se desplazó al estado: ").append(nuevoEstado).append("\n");
                            resultado.append("Movimiento de la pila: ").append(pila).append("\n");
                            index++; //Avanzamos al nuevo estado

                        } else if (accion.startsWith("r")) {
                            int regla = Integer.parseInt(accion.substring(1));
                            //obtiene el número de regla de producción
                            String[] produccion = producciones[regla - 1];
                            String noTerminal = produccion[0];
                            String produccionDerecha = produccion[1];
                            
                            //
                            if (!produccionDerecha.isEmpty()) {
                                //dividir en símbolos individuales
                                String[] simbolosDerecha = produccionDerecha.split(" ");
                                for (int i = 0; i < simbolosDerecha.length; i++) {
                                    pila.pop();
                                }
                            }

                            int estadoDespuesReduccion = pila.peek();
                            //Se busca el nuevo estado después de la reducción
                            int columnaNoTerminal = -1;
                            for (int j = 1; j < encabezado.length; j++) {
                                if (encabezado[j].equals(noTerminal)) {
                                    columnaNoTerminal = j;
                                    break;
                                }
                            }
                            //verificar si el estdo nuevo es valido
                            if (columnaNoTerminal != -1) {
                                String nuevoEstadoStr = matriz[estadoDespuesReduccion + 1][columnaNoTerminal];
                                if (!nuevoEstadoStr.equals(" ")) {
                                    int nuevoEstado = Integer.parseInt(nuevoEstadoStr);
                                    //add el nuevo estado val
                                    pila.push(nuevoEstado);

                                    resultado.append("Reducción con la regla: ").append(regla).append(". Se ingresó el no terminal ").append(noTerminal).append(" y se desplazó al estado: ").append(nuevoEstado).append("\n");
                                    resultado.append("Movimiento de la pila: ").append(pila).append("\n");
                                } else {
                                    return "Error: No se encontro transición para el no terminal " + noTerminal;
                                }
                            } else {
                                return "Error: No se encontro el no terminal correspondiente para la reducción.";
                            }
                        } else if (accion.equals("Acepta")) {
                            resultado.append("Cadena aceptada.\n");
                            aceptado = true;
                            break;
                        }
                    } else {
                        return "Error: Error sintactico.";
                    }
                } else {
                    return "Error: Símbolo terminal no encontrado en el encabezado.";
                }
            }

            if (!aceptado) {
                resultado.append("Cadena no aceptada.\n");
            }
        }
        return resultado.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtf_mostrar;
    // End of variables declaration//GEN-END:variables
}
