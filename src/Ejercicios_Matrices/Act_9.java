package Ejercicios_Matrices;

public class Act_9 {

    public static void main(String[] args) {
        double porcentaje = 0;
        int[] sumcol;
        char candidato = 'A';
        int totalvotos = 0;
        int maxVotos = 0;
        char candidatoMasVotado = ' ';
        boolean hayGanador = false;

        int mat[][] = {{1, 194, 48, 206, 45}, {2, 180, 20, 320, 16},
        {3, 221, 90, 140, 20}, {4, 432, 50, 821, 14}, {5, 820, 61, 946, 18}};

        // Imprimir matriz
        System.out.printf("%-14s %-14s %-14s %-14s %-14s\n", "Distrito", "Candidato A", "Candidato B", "Candidato C", "Candidato D");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%-16d", mat[i][j]);
            }
            System.out.println();
        }

        // Arreglo para la suma de cada columna (sin agregar la del índice), la suma total de los votos, 
        // y el porcentaje obtenido
        sumcol = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                sumcol[j] += mat[i][j];
            }
        }

        for (int i = 1; i < sumcol.length; i++) {
            totalvotos += sumcol[i];
        }
        System.out.println("Total de votantes: " + totalvotos);

        candidato = 'A';
        for (int i = 1; i < sumcol.length; i++) {
            porcentaje = (sumcol[i] * 100.0) / totalvotos;
            System.out.println("La suma del candidato " + (char) (candidato + i-1) + " y el porcentaje de votacion obtenido es " + sumcol[i] + " votos y " + porcentaje + "%");

        }
        candidato = 'A';
        for (int i = 1; i < sumcol.length; i++) {
            porcentaje = (sumcol[i] * 100.0) / totalvotos;

            if (sumcol[i] > maxVotos) {
                maxVotos = sumcol[i];
                candidatoMasVotado = (char) (candidato + i - 1);
            }
            if (porcentaje > 50) {
                System.out.println("El candidato " + (char) (candidato + i - 1) + " es el ganador con mas del 50% de los votos.");
                hayGanador = true;
                break;
            }
        }

        if (!hayGanador) {
            System.out.println("No hay un ganador claro. Se necesitara una segunda vuelta entre los dos candidatos mas votados.");
            // Encontrar al segundo candidato más votado
            int segundoMaxVotos = 0;
            char segundoCandidato = ' ';
            for (int i = 1; i < sumcol.length; i++) {
                if (sumcol[i] > segundoMaxVotos && sumcol[i] != maxVotos) {
                    segundoMaxVotos = sumcol[i];
                    segundoCandidato = (char) (candidato + i - 1);
                }
            }
            System.out.println("Los dos candidatos mas votados son " + candidatoMasVotado + " y " + segundoCandidato);
        }
    }
}
