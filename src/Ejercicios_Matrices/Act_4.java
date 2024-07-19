package Ejercicios_Matrices;

public class Act_4 {
//10.1 Escribir un programa que permita visualizar el triángulo de Pascal:
    public static void main(String[] args) {
        int nfilas = 7;
        int[] a = new int[1];
        for (int i = 1; i <= nfilas; i++) {
        for (int k = 0; k < nfilas - i; k++) {
            System.out.print(" ");
        }
            int[] x = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    x[j] = 1;
                } else {
                    x[j] = a[j] + a[j - 1];
                }
                System.out.print(x[j] + " ");
            }
            a = x;
            System.out.println();
        }
    }
}
