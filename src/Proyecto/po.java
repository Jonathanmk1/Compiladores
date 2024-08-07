package Proyecto;

import java.util.*;

public class po {

    private static final String[][] matriz = {
        {"", "{", "ϵ", "}", ";", "a", "b", "c", "class", "int", "String", "$", "P", "C", "M", "I", "V", "T"},
        {"0", "", "", "", "", "", "", "", "d3", "", "", "", "", "1", "2", "", "", ""},
        {"1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Acepta"},
        {"2", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r1"},
        {"3", "", "", "", "", "d6", "d7", "d8", "", "", "", "", "", "4", "5", "", "", ""},
        {"4", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r2"},
        {"5", "d9", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"6", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r6"},
        {"7", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r7"},
        {"8", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r8"},
        {"9", "", "", "", "", "", "", "", "", "d12", "d13", "", "", "", "", "10", "11", ""},
        {"10", "", "", "", "", "", "", "", "", "", "", "d14", "", "", "", "", "", ""},
        {"11", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "d16", "d17", "d18"},
        {"12", "", "", "", "r9", "r9", "r9", "", "", "", "", "", "", "", "", "", "", ""},
        {"13", "", "", "", "r10", "r10", "r10", "", "", "", "", "", "", "", "", "", "", ""},
        {"14", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "r3"},
        {"15", "d19", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"16", "", "", "", "r6", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"17", "", "", "", "r7", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"18", "", "", "", "r8", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"19", "", "", "", "", "r5", "", "", "", "", "", "", "", "", "", "", "", ""}
    };

    private static final String[] reglas = {
        "", // Regla 0 no usada
        "P -> C", // Regla 1
        "C -> class M", // Regla 2
        "M -> I { V }", // Regla 3
        "V -> ϵ", // Regla 4
        "V -> T I ;", // Regla 5
        "I -> a", // Regla 6
        "I -> b", // Regla 7
        "I -> c", // Regla 8
        "T -> int", // Regla 9
        "T -> String" // Regla 10
    };

    private static int findColumnIndex(String symbol) {
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(symbol)) {
                return i;
            }
        }
        return -1;
    }

    public static void procesarCadena(String input) {
        Stack<Integer> pila = new Stack<>();
        pila.push(0); // Estado inicial
        input += " $"; // Agregamos el símbolo de fin de cadena
        String[] tokens = input.split(" ");
        int index = 0;

        System.out.printf("%-20s %-40s %-20s\n", "Estado Actual", "Pila", "Cadena Procesada");

        while (true) {
            int estadoActual = pila.peek();
            String tokenActual = tokens[index];
            int colIndex = findColumnIndex(tokenActual);

            if (colIndex == -1) {
                System.out.println("Error: símbolo no reconocido '" + tokenActual + "'");
                return;
            }

            String accion = matriz[estadoActual + 1][colIndex];

            System.out.printf("%-20s %-40s %-20s\n", estadoActual, pila.toString(), String.join(" ", Arrays.copyOfRange(tokens, index, tokens.length)));

            if (accion.equals("")) {
                System.out.println("Error: acción no definida para el estado " + estadoActual + " y el símbolo " + tokenActual);
                return;
            }

            if (accion.startsWith("d")) {
                int nuevoEstado = Integer.parseInt(accion.substring(1));
                pila.push(colIndex); // símbolo
                pila.push(nuevoEstado); // nuevo estado
                index++;
            } else if (accion.startsWith("r")) {
                int numRegla = Integer.parseInt(accion.substring(1));
                String regla = reglas[numRegla];
                String[] partesRegla = regla.split(" -> ");
                String lhs = partesRegla[0];
                String rhs = partesRegla[1];
                String[] rhsSimbolos = rhs.equals("ϵ") ? new String[0] : rhs.split(" ");

                for (int i = 0; i < rhsSimbolos.length * 2; i++) {
                    pila.pop();
                }

                int estadoAnterior = pila.peek();
                int lhsColIndex = findColumnIndex(lhs);
                String gotoAccion = matriz[estadoAnterior + 1][lhsColIndex];
                int gotoEstado = Integer.parseInt(gotoAccion);

                pila.push(lhsColIndex); // símbolo
                pila.push(gotoEstado); // nuevo estado
            } else if (accion.equals("Acepta")) {
                System.out.println("Cadena aceptada.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena para procesar:");
        String input = scanner.nextLine();
        procesarCadena(input);
    }
}
