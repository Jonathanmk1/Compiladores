package AL;

import AS.Lectura;
import java.io.IOException;
import java.util.*;

public class matShow_search {

    public String buscarEstado(String[][] matriz, String simbolo) {
        List<String> sim = Arrays.asList("{", "}", ";", "a", "b", "c", "class", "int", "string", "$", "P", "C", "M", "I", "V", "T");
        if (!sim.contains(simbolo)) {
            return "Simbolo inválido.";
        }

        for (int columna = 0; columna < matriz[0].length; columna++) {
            if (matriz[0][columna].equals(simbolo)) {
                return "El estado es: " + matriz[1][columna];
            }
        }

        return "Simbolo no encontrado en la matriz.";
    }

    public void inmat(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("---------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("%-4d", i-1);
            for (String mat : matriz[i]) {
                System.out.printf("%-9s", mat);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        matShow_search ms = new matShow_search();
        int resp;
        String[][] matriz = {{"{", "}", ";", "a", "b", "c", "class", "int", "string", "$", "P", "C", "M", "I", "V", "T"},
        {"", "", "", "", "", "", "", "d3", "", "", "", "1", "2", "", "", "", ""}, {"", "", "", "", "", "", "", "", "", "ACEPTA", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "r1", "", "", "", "", "", ""}, {"", "", "", "d6", "d7", "d8", "", "", "", "", "", "", "4", "5", "", ""},
        {"", " ","", "", "", "", "", "", "", "", "r2", "", "", "", "", "", ""}, {"d9", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "r6", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "r7", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "r8", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", "d12", "d13", "", "", "", "", "", "10", "11"},
        {"", "d14", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "", "", "d16", "d17", "d18", "", "", "", "", "", "", "", "15", "", ""},
        {"", "", "r9", "r9", "r9", "", "", "", "", "", "", "", "", "", "", ""}, {"", "", "r10", "r10", "r10", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "r3", "", "", "", "", "", ""}, {"", "", "d19", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "r6", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "", "r7", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "r8", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "r5", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
        };
        do {
            resp = Lectura.leerInt("Que desea vizualizar?: \n1= ver matriz \n2.=buscar una transiccion \n3.salir");
            switch (resp) {
                case 1:
                    ms.inmat(matriz);
                    break;
                case 2:
                    String simbolo = Lectura.leerString("Ingrese la cadena: ");
                    String resultado = ms.buscarEstado(matriz, simbolo);
                    System.out.println(resultado);
                    break;

            }
        } while (resp != 3);

    }
}
