package Ejercicios_Matrices;

import java.io.IOException;

public class Act_7 {

    public void media(float real[]) {
        float suma = 0, media;
        for (int i = 0; i < real.length; i++) {
            suma += real[i];
        }
        media = suma / real.length;
        System.out.println("La media es: " + media);
        varianza(real, media);
    }

    public void varianza(float real[], float media) {
        float dif = 0, at;

        for (int i = 0; i < real.length; i++) {
            at = real[i] - media;
            dif += at * at;
        }
        float varianza = dif / real.length;
        System.out.println("varianza: " + varianza);
        desviacionestandar(varianza);
    }

    public void desviacionestandar(float varianza) {
        float desviacion;
        desviacion = (float) Math.sqrt(varianza);
        System.out.println("Desviacion estandar: " + desviacion);
    }

    public void in() throws IOException {

        float num;
        String respuesta;
        int contador = 0;
        float[] real = new float[0];
        respuesta = Lectura.leerString("Quiere ingresar numeros? (escribe *SI* para inciar) - (escribe *NO* para salir)");
        while (respuesta.equalsIgnoreCase("si")) {
            num = Lectura.leerfloat("Ingrese el numero");
            float[] numr = new float[contador + 1];

            for (int i = 0; i < contador; i++) {
                numr[i] = real[i];
            }

            numr[contador] = num;
            real = numr;
            contador++;
            respuesta = Lectura.leerString("Quiere ingresar mas numeros? (escribe si) - no (para salir)");
        }
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        Lectura.imprimirString("Valores del Arreglo:\n");
        impr(real);
        media(real);
    }

    public void impr(float real[]) {

        for (int i = 0; i < real.length; i++) {
            System.out.println(real[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        Act_7 a7 = new Act_7();
        a7.in();

    }
}
