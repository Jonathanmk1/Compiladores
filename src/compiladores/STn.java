
package compiladores;

import java.util.Scanner;
import java.util.StringTokenizer;

public class STn {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String prueba;
        String lenguaje;
        StringTokenizer particionesCadena = new StringTokenizer("" );
        
//        lenguaje= "COMO separar las palabras con espacios";
//        
//        StringTokenizer particionesCadena = new StringTokenizer(lenguaje, " ");
//        
//        while(particionesCadena.hasMoreElements()){
//            System.out.println("Particion: " + particionesCadena.nextElement());
//        }
//        
//        lenguaje = "jona, miguel| isai 10; jjjss 987";
//        
//        particionesCadena = new StringTokenizer(lenguaje, ",|;");
//        
//        while(particionesCadena.hasMoreElements()){
//            System.out.println("Particion: " + particionesCadena.nextElement());
//        }
//        
        System.out.println("Ingresa lo que sea: \n");
        prueba = s.nextLine();
        
        particionesCadena = new StringTokenizer(prueba, " ");
        
        while(particionesCadena.hasMoreElements()){
            System.out.println("Particion: " + particionesCadena.nextElement());
        }
    }
}
