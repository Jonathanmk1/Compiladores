package Ejercicios_Matrices;

public class Act_1 {
//10.7  Escribir un programa que lea el siguiente arreglo:  

    public void matriz(int[][] matriz) {
        //int matriz[][] = {{4,7,1,3,5},{2,0,6,9,7},{3,1,2,6,4}};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public void matriztranspuesta(int matriz[][]) {
        
        int[][] mt = new int[matriz[0].length][matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mt[j][i] = matriz[i][j];
            }
        }
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt[i].length; j++) {
                System.out.print(" " + mt[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Act_1 a = new Act_1();
        int matriz[][] = {{4, 7, 1, 3, 5}, {2, 0, 6, 9, 7}, {3, 1, 2, 6, 4}};
        System.out.printf("%-16s", "\033[36mMatriz Original:\033[0m \n");
        a.matriz(matriz);
        System.out.println("\033[35m---------------------------------------------------\033[0m");
        System.out.printf("%-16s", "\033[34mMatriz transpuesta:\033[0m \n");
        a.matriztranspuesta(matriz);
    }

}














/*
public void ejercicio2(){
    //int[][] matriz = {{9, 7, 1, 7}, {2, 3, 0, 6}, {3, 1, 2, 8}, {1, 2, 3, 4}};
    
    int[][] matriz = {{9, 7, 1}, {2, 3, 0}, {3, 1, 2}, {1, 2, 3}};
    
    for (int i = 0; i < 4; i++) { //filas
        for (int j = 0; j < 3; j++) { //columnas
            
            
            System.out.print(" " + matriz[i][j]);
            
        }
        System.out.println("");
        
    }
}
    public static void main(String[] args){
    Matriz m = new Matriz();
    System.out.println("\n---------------------------------\n");
    m.ejercicio2();
    System.out.println("\033[33m-------------------");
    
    }
*/
