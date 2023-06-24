package vetores_matrizes.exercicios.matrizes;

import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                matriz[l][c] = sc.nextInt();
            }
        }

        System.out.println("Diagonal Principal: ");
        for (int l = 0; l < matriz.length; l++) {
                System.out.print(matriz[l][l] + " ");
            }

        System.out.println();
        int contador = 0;

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                if (matriz[l][c] < 0) {
                    contador++;
                }
            }
        }
            System.out.println("Numeros Negativos: " + contador);

        sc.close();
    }
}
