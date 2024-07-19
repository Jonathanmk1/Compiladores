package Ejercicios_Matrices;

import java.io.IOException;

public class Act_5 {

    public static void main(String[] args) throws IOException {
        int n;
        int[][] A;
        int f, c;

        do {
            n = Lectura.leerInt("Ingrese un numero impar: ");

            if (n % 2 == 0) {
                n = Lectura.leerInt("n no es impar, ingrese nuevamente un numero impar");
                
            }
            if (n > 11) {
                System.out.println("n es mayor que 11, ingrese nuevamente un numero menor o igual a 11 y que sea impar");
            } else {
                A = new int[n][n];
                int num = 1;
                int fila = 0, col = n / 2;

                while (num <= n * n) {
                    A[fila][col] = num;
                    num++;
                    f = fila;
                    c = col;

                    fila = fila - 1;
                    col = col + 1;
                    if (fila == -1) {
                        fila = n - 1;
                    }
                    if (col == n) {
                        col = 0;
                    }
                    if (A[fila][col] != 0) {
                        fila = f + 1;
                        col = c;
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%-5d", A[i][j]);
                    }
                    System.out.println();
                } 
            }
        } while (n < 12 || n > 11);
    }
}
