package as;

import java.util.Scanner;

public class Práctica1 {
    public static void main(String[] args) {
        String[][] matrix = new String[21][18];

        // Encabezados de columnas
        String[] headers = {"", "{", "}", ";", "a", "b", "c", "class", "int", "string", "$", "P", "C", "M", "V", "I", "T"};

        // Rellenar encabezados de columnas
        for (int j = 0; j < headers.length; j++) {
            matrix[0][j] = headers[j];
        }

        // Rellenar encabezados de filas
        for (int i = 1; i < 21; i++) {
            matrix[i][0] = Integer.toString(i - 1);
        }

        // Rellenar la tabla con los valores específicos
        matrix[1][7] = "d3";
        matrix[1][10] = "1";
        matrix[1][11] = "2";

        matrix[2][10] = "acepta";

        matrix[3][10] = "r1";

        matrix[4][4] = "d6";
        matrix[4][5] = "d7";
        matrix[4][6] = "d8";
        matrix[4][13] = "4";
        matrix[4][14] = "5";

        matrix[5][10] = "r2";

        matrix[6][1] = "d9";

        matrix[7][2] = "r6";

        matrix[8][2] = "r7";

        matrix[9][2] = "r8";

        matrix[10][8] = "d12";
        matrix[10][9] = "d13";
        matrix[10][15] = "10";
        matrix[10][16] = "11";

        matrix[11][2] = "d14";

        matrix[12][4] = "d16";
        matrix[12][5] = "d17";
        matrix[12][6] = "d18";
        matrix[12][14] = "15";

        matrix[13][3] = "r9";
        matrix[13][4] = "r9";
        matrix[13][5] = "r9";

        matrix[14][3] = "r10";
        matrix[14][4] = "r10";
        matrix[14][5] = "r10";

        matrix[15][10] = "r3";

        matrix[16][3] = "d19";

        matrix[17][3] = "r6";

        matrix[18][3] = "r7";

        matrix[19][3] = "r8";

        matrix[20][2] = "r10";

        // Imprimir la matriz
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 18; j++) {
                if (matrix[i][j] == null) {
                    System.out.print(String.format("%-7s", " "));
                } else {
                    System.out.print(String.format("%-7s", matrix[i][j]));
                }
            }
            System.out.println();
        }

        // Procesar entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fila:");
        int row = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.println("Ingrese la columna:");
        String column = scanner.nextLine();

        String result = getValue(matrix, row, column, headers);
        if (result == null) {
            System.out.println("No se encontró ningún valor en la posición especificada.");
        } else {
            System.out.println("El resultado es: " + result);
        }
    }

    // Método para obtener el valor en la posición especificada
    public static String getValue(String[][] matrix, int row, String column, String[] headers) {
        // Encontrar el índice de la columna
        int colIndex = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(column)) {
                colIndex = i;
                break;
            }
        }

        // Validar si se encontró la columna
        if (colIndex == -1) {
            System.out.println("Columna no válida.");
            return null;
        }

        // Validar si la fila está dentro del rango
        if (row < 0 || row >= 20) {  // Filas válidas son 0-19
            System.out.println("Fila no válida.");
            return null;
        }

        // Devolver el valor en la posición especificada
        return matrix[row + 1][colIndex];  // Sumar 1 porque la fila 0 es el encabezado
    }
}