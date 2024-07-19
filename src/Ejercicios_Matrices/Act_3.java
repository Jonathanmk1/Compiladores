package Ejercicios_Matrices;

import java.io.IOException;
import java.util.Scanner;
//10.9 Escribir un método que intercambie la fila penúltima por la última de un arreglo de dos
//dimensiones, m x n.

public class Act_3 {
    Scanner s = new Scanner(System.in);
    
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
                Lectura.imprimirString(" " + mat[i][j]);
            }
            System.out.println("");
        }
    }

    public void intercambarf(int mat[][], int f, int c) {
        for (int j = 0; j < c; j++) {
            int temp = mat[f - 1][j];
            mat[f - 1][j] = mat[f - 2][j];
            mat[f - 2][j] = temp;
        }
        
        System.out.println("\n");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                Lectura.imprimirString(" " + mat[i][j]);
            }
            System.out.println("");
        }
    }

    public void inicio() throws IOException{
        int mat[][];
        int f;
        int c;
        f = Lectura.leerInt("\033[32mIngrese el numero de filas en entero:\033[0m ");
        
        c = Lectura.leerInt("\033[33mIngrese el numero de columnas en entero:\033[0m ");

        mat = new int[f][c];
        
        Act_3 a3 = new Act_3();
        a3.llenarmat(mat, f, c);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("MATRIZ ORIGINAL:\n");
        a3.impmat(mat, f, c);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("Matriz que intercambie la fila penúltima por la última:");
        a3.intercambarf(mat, f, c);
    }
    public static void main(String[] args) throws IOException {
        Act_3 a3 = new Act_3();
        a3.inicio();
    }
}
