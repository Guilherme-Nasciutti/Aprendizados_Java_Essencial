package vetores_matrizes.exercicios;

/*Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida:
 Imprimir todos os elementos do vetor
 Mostrar na tela a soma e a média dos elementos do vetor*/


import java.util.Locale;
import java.util.Scanner;

public class SomaVetor {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n;
        double soma, media;

        System.out.print("Quantos numeros deseja calcular: ");
        n = sc.nextInt();
        double[] vetorNumeros = new double[n];

        for (int indicador = 0; indicador < n; indicador++) {
            System.out.print("Digite um número: ");
            vetorNumeros[indicador] = sc.nextDouble();
        }

        soma = 0;

        for (int indicador = 0; indicador < n; indicador++) {
            soma += vetorNumeros[indicador];
        }

        media = soma / n;

        System.out.printf("Soma dos números: %.2f", soma);
        System.out.printf("\nMédia calculada: %.2f", media);

        sc.close();
    }
}
