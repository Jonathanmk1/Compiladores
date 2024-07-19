package AS;

import java.util.Scanner;

public class Tabla_sintactica {

    public void progra_tabla() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el numero de filas de su matriz: ");
        int f = s.nextInt();
        System.out.println("Ingrese el numero de columnas: ");
        int c = s.nextInt();
        String[][] matriz = new String[f][c];
        int i, j;

        //Visualizacion de la matriz
        System.out.println("Indique los valores de la matriz");
        for (i = 0; i < f; i++) { //filas
            for (j = 0; j < c; j++) {  //columnas
                System.out.println(i + "," + j + "::");
                matriz[i][j] = s.next();
            }
            System.out.println("");
        }

        for (i = 0; i < f; i++) { //filas
            for (j = 0; j < c; j++) {  //columnas
                System.out.print("\033[35m " + matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public void tabla_llenada() {
        String[][] matriz = {{"{", "}", ";", "a", "b", "c", "class", "int", "string", "$", "P", "C", "M", "I", "V", "T"},
        {" ", " ", " ", " ", " ", " ", "d3", " ", " ", " ", "1", "2", " ", " ", " ", " "}, {"", "", "", "", "", "", "", "", "", "ACEPTA", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "r1", "", "", "", "", "", ""}, {"", "", "", "d6", "d7", "d8", "", "", "", "", "", "", "4", "5", "", ""},
        {"", "", "", "", "", "", "", "", "", "r2", "", "", "", "", "", ""}, {"d9", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "r6", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "r7", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "r8", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", "d12", "d13", "", "", "", "", "", "10", "11"}

        };
//        System.out.printf("%-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s %-6s\n",
//                 "{", "}", ";", "a", "b", "c", "class", "int", "string", "$", "P", "C", "M", "I", "V", "T");

        for (int i = 0; i < 17; i++) { //filas
            System.out.print("--------------------------------------------------------------------------------------------------------------\n");
            for (int j = 0; j < 16; j++) { //columnas

                System.out.printf("%-7s", matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Tabla_sintactica ts = new Tabla_sintactica();

        ts.tabla_llenada();
    }

}
