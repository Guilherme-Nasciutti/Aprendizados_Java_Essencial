package vetores_matrizes.exercicios;

/*Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois N números inteiros
e armazene-os em um vetor. Em seguida, mostrar na tela todos os números negativos lidos.*/

import java.util.Locale;
import java.util.Scanner;

public class NumerosNegativos {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o tamanho do vetor que deseja criar?");
        int n = sc.nextInt();
        int[] vetorNumeros = new int[n];

        for (int indicador = 0; indicador < n; indicador++) {
            System.out.print("Digite um número inteiro: ");
            vetorNumeros[indicador] = sc.nextInt();
        }

        System.out.println("Numeros negativos:");

        for (int indicador = 0; indicador < n; indicador++) {
            if (vetorNumeros[indicador] < 0) {
                System.out.println(vetorNumeros[indicador]);
            }
        }

        sc.close();
    }
}
