package vetores_matrizes.exercicios;

/*Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida, mostrar na tela
o maior número do vetor (supor não haver empates). Mostrar também a posição do maior elemento,
considerando a primeira posição como 0 (zero).*/

import java.util.Locale;
import java.util.Scanner;

public class MaiorPosicao {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n, posicaoMaior;
        double numeroMaior;

        System.out.print("Quantos números deseja digitar: ");
        n = sc.nextInt();

        double[] vetorNumeros = new double[n];

        for (int i = 0; i < vetorNumeros.length; i++) {
            System.out.print("Digite um número: ");
            vetorNumeros[i] = sc.nextDouble();
        }

        numeroMaior = vetorNumeros[0];
        posicaoMaior = 0;

        for (int i = 1; i < vetorNumeros.length; i++) {
            if (vetorNumeros[i] > numeroMaior) {
                numeroMaior = vetorNumeros[i];
                posicaoMaior = i;
            }
        }

        System.out.print("Maior número: " + numeroMaior);
        System.out.print("\nPosição no vetor do maior número: " + posicaoMaior);

        sc.close();
    }
}
