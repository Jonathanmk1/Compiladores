package Ejercicios_Matrices;

import java.io.IOException;
import java.util.Scanner;

/*
10.6 Escribir un método que acepte como parámetro un arreglo que pueda 
contener números enteros duplicados; además, debe sustituir cada valor repetido por -5 y devolver el
vector modificado y el número de entradas modificadas.
 */
public class Act_8 {

    public static int[] dupli(int[] array) {
        int modificados = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != -5) {
                boolean esDuplicado = false;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        array[j] = -5;
                        esDuplicado = true;
                        modificados++;
                    }
                }
                if (esDuplicado) {
                    array[i] = -5;
                    modificados++;
                }
            }
        }
        System.out.println("Numero de entradas modificadas: " + modificados);
        return array;
    }

    public static void main(String[] args) throws IOException {
        int tam = Lectura.leerInt("Ingrese el tamano del arreglo: ");
        int[] arr = new int[tam];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Lectura.leerInt("Ingrese los elementos del arreglo pos[" + i + "]:");
        }

        System.out.print("Arreglo ingresado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] dupli = dupli(arr);

        System.out.print("Arreglo modificado: ");
        for (int num : dupli) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
