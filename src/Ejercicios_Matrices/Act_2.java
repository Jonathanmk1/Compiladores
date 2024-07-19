package Ejercicios_Matrices;

public class Act_2 {

    public void matOrig(int matriz[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-5d", matriz[i][j]);
                //System.out.print(" " + matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public float Suma(int matriz[][]) {
        float suma = 0;
        for (int i = 0; i < 4; i++) { 
            for (int j = 0; j < 5; j++) { 
                if (i != j) {
                    suma +=matriz[i][j];
                }
            }
        }
        return suma;
    }

    public void inicio() {
        System.out.println("""
                           suma de todos los elementos que no pertenecen a la diagonal principal 
                           """);
        int matriz[][] = {{4, 7, -5, 4, 9}, {0, 3, -2, 6, -2}, {1, 2, 4, 1, 1}, {6, 1, 0, 3, -4}};
        Act_2 a2 = new Act_2();
        System.out.printf("%-16s", "\033[36mMatriz Original:\033[0m \n");
        a2.matOrig(matriz);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        float suma = a2.Suma(matriz);
        System.out.println("La suma de los elementos que NO estan en la diagonal es: " + suma);
    }
    public static void main(String[] args) {
        Act_2 a2 = new Act_2();
        a2.inicio();
    }
}
