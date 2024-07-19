package Ejercicios_Matrices;

import java.util.Random;
/*
Escribir un programa en el que se genere aleatoriamente un arreglo de 20 números enteros. 
El arreglo debe quedar de tal forma que la suma de los 10 primeros elementos sea
mayor que la suma de los 10 últimos. Mostrar el arreglo original y el arreglo con la 
distribución indicada.
*/
public class Act_10 {
    public static void main(String[] args) {
        
        int[] arreglo = new int[20];
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            arreglo[i] = random.nextInt(100);
        }
        
        System.out.println("Arreglo original: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println(); 

        // método de ordenación de burbuja
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19 - i; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        int p = 0;
        int u = 0;

        for (int i = 0; i < 10; i++) {
            p += arreglo[i];
            u += arreglo[10 + i];
        }

        System.out.println("\nArreglo ordenado de mayor a menor:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println(); // Salto de línea

        System.out.println("\nSuma de los primeros 10 elementos: " + p);
        System.out.println("Suma de los últimos 10 elementos: " + u);

        // Asegurarnos de que la suma de los primeros 10 sea mayor que la de los últimos 10
        if (p > u) {
            System.out.println("\nLa suma de los primeros 10 elementos es mayor que la suma de los últimos 10.");
        } else {
            System.out.println("\nError: La suma de los primeros 10 elementos no es mayor que la suma de los últimos 10.");
        }
    }
}
