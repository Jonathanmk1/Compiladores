package Ejercicios_Matrices;

import java.io.IOException;

/*
    10.3 Escribir un programa que lea las dimensiones de una matriz, 
    la visualice y encuentre su
    mayor y su menor elemento y sus posiciones respectivas.
 */
public class Act_6 {

    static Act_6 a6 = new Act_6();

    public void llenarmat(int mat[][], int f, int c) throws IOException {
        Lectura.imprimirString("Indique los valores de la matriz :)\n");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                Lectura.imprimirString("\033[36m--->posicion " + i + "," + j + "::\033[0m");
                mat[i][j] = Lectura.leerInt("");
            }
        }
    }

    public void impmat(int mat[][], int f, int c) {
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    public void mayor(int mat[][], int m, int n) {
        int max = mat[0][0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("\nMayor: " + max + "\nY en la posicion: [" + x + ", " + y + "]");
    }

    public void menor(int mat[][], int m, int n) {
         int men = mat[0][0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < men) {
                    men = mat[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("\nMenor: " +men + "\nY en la posicion: [" + x + ", " + y + "]");
    }

    public void in() throws IOException {
        int mat[][];
        int m = Lectura.leerInt("Ingrese el numero de filas: ");
        int n = Lectura.leerInt("Ingrese el numero de columnas: ");
        mat = new int[m][n];
        a6.llenarmat(mat, m, n);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("MATRIZ ORIGINAL:\n");
        a6.impmat(mat, m, n);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("Numero mayor y su posicion:");
        a6.mayor(mat, m, n);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("Numero menor y su posicion:");
        a6.menor(mat, m, n);
    }

    public static void main(String[] args) throws IOException {
        a6.in();
    }
}
