
package compiladores;

import java.util.Scanner;

public class ANL {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String cadena;
        char c;
        
        System.out.println("Ingresa una cadena:");
        cadena = s.nextLine();
        
        // Toma un índice como argumento y devuelve el carácter en esa posición dentro de la cadena
        System.out.println("Resultado del análisis léxico:");
        for (int i = 0; i < cadena.length(); i++) {
            c = cadena.charAt(i);

            System.out.println(Character.toUpperCase(c));
            System.out.println(c);
        }
    }
}