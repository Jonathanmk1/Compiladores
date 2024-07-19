/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios_Matrices;

/**
 *
 * @author USER
 */
public class prue {
    public static void main(String[] args) {
        // Matriz con los votos por cada candidato en cada distrito
        int[][] votos = {
                {194, 48, 206, 45},
                {180, 20, 320, 16},
                {221, 90, 140, 20},
                {432, 50, 821, 14},
                {820, 61, 946, 18}
        };

        // a) Imprimir la tabla con encabezados
        System.out.println("Distrito\tCandidato A\tCandidato B\tCandidato C\tCandidato D");
        for (int i = 0; i < votos.length; i++) {
            System.out.print((i + 1) + "\t\t");
            for (int j = 0; j < votos[i].length; j++) {
                System.out.print(votos[i][j] + "\t\t");
            }
            System.out.println();
        }

        // b) Calcular y imprimir el número total de votos por candidato y el porcentaje del total de votos
        int[] totalVotosPorCandidato = new int[4];
        int totalVotosEmitidos = 0;

        for (int i = 0; i < votos.length; i++) {
            for (int j = 0; j < votos[i].length; j++) {
                totalVotosPorCandidato[j] += votos[i][j];
                totalVotosEmitidos += votos[i][j];
            }
        }

        System.out.println("\nTotal de votos por candidato:");
        char candidato = 'A';
        for (int i = 0; i < totalVotosPorCandidato.length; i++) {
            double porcentaje = (totalVotosPorCandidato[i] * 100.0) / totalVotosEmitidos;
            System.out.printf("Candidato %c: %d votos (%.2f%%)\n", (char) (candidato + i), totalVotosPorCandidato[i], porcentaje);
        }

        // Encontrar el candidato más votado
        int maxVotos = 0;
        int indiceCandidatoGanador = -1;
        for (int i = 0; i < totalVotosPorCandidato.length; i++) {
            if (totalVotosPorCandidato[i] > maxVotos) {
                maxVotos = totalVotosPorCandidato[i];
                indiceCandidatoGanador = i;
            }
        }
        System.out.println("\nEl candidato más votado es el Candidato " + (char) (candidato + indiceCandidatoGanador));

        // c) Verificar si algún candidato recibió más del 50% de los votos
        boolean ganadorDirecto = false;
        for (int i = 0; i < totalVotosPorCandidato.length; i++) {
            if ((totalVotosPorCandidato[i] * 100.0) / totalVotosEmitidos > 50) {
                System.out.println("\nEl Candidato " + (char) (candidato + i) + " recibió más del 50% de los votos y es el ganador.");
                ganadorDirecto = true;
                break;
            }
        }

        // d) Si ningún candidato recibió más del 50% de los votos, imprimir los dos más votados
        if (!ganadorDirecto) {
            int primerLugar = -1, segundoLugar = -1;
            for (int i = 0; i < totalVotosPorCandidato.length; i++) {
                if (primerLugar == -1 || totalVotosPorCandidato[i] > totalVotosPorCandidato[primerLugar]) {
                    segundoLugar = primerLugar;
                    primerLugar = i;
                } else if (segundoLugar == -1 || totalVotosPorCandidato[i] > totalVotosPorCandidato[segundoLugar]) {
                    segundoLugar = i;
                }
            }
            System.out.println("\nNingún candidato recibió más del 50% de los votos.");
            System.out.println("Los candidatos que pasan a la segunda ronda son:");
            System.out.println("Candidato " + (char) (candidato + primerLugar));
            System.out.println("Candidato " + (char) (candidato + segundoLugar));
        }
    }
}
