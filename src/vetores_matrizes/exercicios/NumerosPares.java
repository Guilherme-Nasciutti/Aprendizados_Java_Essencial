package vetores_matrizes.exercicios;

/*Faça um programa que leia N números inteiros e armazene-os em um vetor.
Em seguida, mostre na tela todos os números pares, e também a quantidade de números pares.*/

import java.util.Locale;
import java.util.Scanner;

public class NumerosPares {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n,numerosPares;

        System.out.print("Quanto números deseja digitar? ");
        n = sc.nextInt();

        int[] vetorNumeros = new int[n];

        for (int i=0; i< vetorNumeros.length; i++){
            System.out.print("Digite um numero inteiro: ");
            vetorNumeros[i] = sc.nextInt();
        }

        numerosPares = 0;

        for (int i=0; i < vetorNumeros.length; i++){
            if (vetorNumeros[i] % 2 == 0){
                numerosPares ++;
            }
        }

        System.out.println("Quantidade de numeros pares: " + numerosPares);

        for (int i=0; i< vetorNumeros.length; i++){
            if (vetorNumeros[i] % 2 == 0){
                System.out.println(vetorNumeros[i]);
            }
        }

        sc.close();
    }
}
