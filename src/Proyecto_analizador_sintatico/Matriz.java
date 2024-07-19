package Proyecto_analizador_sintatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Matriz {

    public static void main(String[] args) {
        final int FILAS = 21;
        final int COLUMNAS = 17;
        String[] encabezado = {" ", "class", "{", "}", ";", "a", "b", "c", "int", "string", "$", "P", "C", "M", "V", "I", "T"};
        String[][] matriz = new String[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = " ";
            }
        }

        // Llenó el encabezado de las columnas
        for (int j = 1; j < encabezado.length; j++) {
            matriz[0][j] = encabezado[j];
        }
        // Llenó el encabezado de las filas
        for (int i = 1; i < FILAS; i++) {
            matriz[i][0] = Integer.toString(i - 1);
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
                System.out.println("Error: Columna fuera de rango.");
            }
        }

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // Definó mi gramatica 
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

        Scanner s = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();
        pila.push(0);

        System.out.println("Ingrese una cadena de símbolos terminales (sin espacios) o 'exit' para salir:");
        String input = s.nextLine().trim();

        if (!input.equals("exit")) {
            input += "$";

            // Utilizó StringTokenizer para dividir la cadena en tokens y le sea mas facil relacionarlos con la tabla
            StringTokenizer tokenizer = new StringTokenizer(input, " {};$", true);

            List<String> tokens = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (!token.trim().isEmpty()) {
                    tokens.add(token);
                }
            }

            boolean aceptado = false;
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

                if (columna != -1) {
                    int estadoActual = pila.peek();
                    String accion = matriz[estadoActual + 1][columna];
                    if (!accion.equals(" ")) {
                        System.out.println("Acción: " + accion);

                        if (accion.startsWith("d")) {
                            int nuevoEstado = Integer.parseInt(accion.substring(1));
                            pila.push(nuevoEstado);
                            System.out.println("Se desplazó al estado: " + nuevoEstado);
                            System.out.println("Movimiento de la pila: " + pila + "\n");
                            index++; //Avanzamos al nuevo estado

                        } else if (accion.startsWith("r")) {
                            int regla = Integer.parseInt(accion.substring(1));
                            String[] produccion = producciones[regla - 1];
                            String noTerminal = produccion[0];
                            String produccionDerecha = produccion[1];

                            if (!produccionDerecha.isEmpty()) {
                                String[] simbolosDerecha = produccionDerecha.split(" ");
                                for (int i = 0; i < simbolosDerecha.length; i++) {
                                    pila.pop();
                                }
                            }

                            int estadoDespuesReduccion = pila.peek();
                            int columnaNoTerminal = -1;
                            for (int j = 1; j < encabezado.length; j++) {
                                if (encabezado[j].equals(noTerminal)) {
                                    columnaNoTerminal = j;
                                    break;
                                }
                            }

                            if (columnaNoTerminal != -1) {
                                String nuevoEstadoStr = matriz[estadoDespuesReduccion + 1][columnaNoTerminal];
                                if (!nuevoEstadoStr.equals(" ")) {
                                    int nuevoEstado = Integer.parseInt(nuevoEstadoStr);
                                    pila.push(nuevoEstado);

                                    System.out.println("Reducción con la regla: " + regla + ". Se ingresó el no terminal " + noTerminal + " y se desplazó al estado: " + nuevoEstado);
                                    System.out.println("Movimiento de la pila: " + pila + "\n");
                                } else {
                                    System.out.println("Error: No se encontró transición para el no terminal " + noTerminal);
                                    break;
                                }
                            } else {
                                System.out.println("Error: No se encontró el no terminal correspondiente para la reducción.");
                                break;
                            }
                        } else if (accion.equals("Acepta")) {
                            System.out.println("Cadena aceptada.");
                            aceptado = true;
                            break;
                        }
                    } else {
                        System.out.println("Error: No hay acción para el símbolo terminal ingresado.");
                        break;
                    }
                } else {
                    System.out.println("Error: Símbolo terminal no encontrado en el encabezado.");
                    break;
                }
            }

            if (!aceptado) {
                System.out.println("Cadena no aceptada.");
            }
        }
    }
}
