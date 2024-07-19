package Proyecto_analizador_sintatico;

import java.util.*;

public class need {

    private String[][] matriz;
    private String[] encabezado;
    private String[][] producciones;

    public need(String[][] matriz, String[] encabezado, String[][] producciones) {
        this.matriz = matriz;
        this.encabezado = encabezado;
        this.producciones = producciones;
    }

    public String analizarCadena(String input) {
        Stack<Integer> pila = new Stack<>();
        pila.push(0);

        // Concatenar el símbolo de fin de cadena
        input += "$";

        // Utilizar StringTokenizer para dividir la cadena en tokens y hacerla más fácil de relacionar con la tabla
        StringTokenizer tokenizer = new StringTokenizer(input, " {};$", true);

        // Lista para almacenar los tokens
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.trim().isEmpty()) {
                tokens.add(token);
            }
        }

        StringBuilder resultado = new StringBuilder();

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

                if (accion != null && !accion.equals(" ")) {
                    // Lógica adicional aquí...
                } else {
                    resultado.append("Error: No hay acción para el símbolo terminal ingresado.").append("\n");
                    break;
                }

            } else {
                resultado.append("Error: Símbolo terminal no encontrado en el encabezado.").append("\n");
                break;
            }
        }

        return resultado.toString();
    }
}
