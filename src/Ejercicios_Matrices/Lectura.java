
package Ejercicios_Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Lectura {
    //recibe y si regresa
    public static int leerInt(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        int n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Integer.parseInt(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero entero");
            }
        } while (error);
        return n;
    }
    public static byte leerbyte(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        byte n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Byte.parseByte(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero byte (-128 - 127)");
            }
        } while (error);
        return n;
    }
    public static short leershort(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        short n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Short.parseShort(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero short");
            }
        } while (error);
        return n;
    }
    public static long leerlong(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        long n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Long.parseLong(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero long");
            }
        } while (error);
        return n;
    }
    public static float leerfloat(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        float n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Float.parseFloat(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero float");
            }
        } while (error);
        return n;
    }
    public static double leersdouble(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        double n = 0;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = Double.parseDouble(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es un Numero double");
            }
        } while (error);
        return n;
    }
    public static String leerString(String cad) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(isr);
        String n = null;
        boolean error = true;
        do {

            try {
                System.out.println(cad);
                n = String.valueOf(t.readLine());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("No es una cadena");
            }
        } while (error);
        return n;
    }
    
    public static void imprimirString(String cad){
        System.out.print(cad);
    }
    public static void imprimirStringDgl(String cad){
        JOptionPane.showMessageDialog(null, cad);
    }
    
}