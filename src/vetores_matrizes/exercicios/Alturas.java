package vetores_matrizes.exercicios;

/*Fazer um programa para ler nome, idade e altura de N pessoas. Depois, mostrar na
tela a altura média das pessoas, e mostrar também a porcentagem de pessoas com menos de 16 anos,
bem como os nomes dessas pessoas caso houver.*/

import vetores_matrizes.exercicios.entites.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Alturas {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
//
//        int n, menores16;
//        double alturaTotal, alturaMedia, percentualMenores16;
//
//        System.out.print("Quantas pessoas deseja adicionar? ");
//        n = sc.nextInt();
//
//        Pessoa[] vetorPessoa = new Pessoa[n];
//
//        for (int i = 0; i < vetorPessoa.length; i++) {
//            sc.nextLine();
//            System.out.print("Nome: ");
//            String nome = sc.nextLine();
//            System.out.print("Idade: ");
//            int idade = sc.nextInt();
//            System.out.print("Altura: ");
//            double altura = sc.nextDouble();
//            vetorPessoa[i] = new Pessoa(nome, idade, altura);
//        }
//
//        menores16 = 0;
//        alturaTotal = 0;
//
//        for (int i = 0; i < vetorPessoa.length; i++) {
//            if (vetorPessoa[i].getIdade() < 16) {
//                menores16++;
//            }
//            alturaTotal += vetorPessoa[i].getAltura();
//        }
//
//        alturaMedia = alturaTotal / vetorPessoa.length;
//        percentualMenores16 = ((double) menores16 / vetorPessoa.length) * 100.00;
//
//        System.out.printf("Altura média das pessoas: %.1f", alturaMedia);
//        System.out.printf("\nPercentual de pessoas com menos de 16 anos: %.2f\n", percentualMenores16);
//
//        for (int i = 0; i < vetorPessoa.length; i++) {
//            if (vetorPessoa[i].getIdade() < 16) {
//                System.out.println(vetorPessoa[i].getNome());
//            }
//        }

        int n, menores16;
        double alturaTotal, alturaMedia, percentualMenores16;

        System.out.print("Quantas pessoas deseja adicionar? ");
        n = sc.nextInt();

        Pessoa[] vetorPessoas = new Pessoa[n];

        for (int ind = 0; ind < vetorPessoas.length; ind++) {
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            vetorPessoas[ind] = new Pessoa(nome, idade, altura);
        }

        menores16 = 0;
        alturaTotal = 0;

        for (int ind = 0; ind < vetorPessoas.length; ind++) {
            if (vetorPessoas[ind].getIdade() < 16) {
                menores16++;
            }
            alturaTotal += vetorPessoas[ind].getAltura();
        }

        alturaMedia = alturaTotal / vetorPessoas.length;
        percentualMenores16 = ((double) menores16 / vetorPessoas.length) * 100.00;

        System.out.printf("Altura media das pessoas registradas: %.2f", alturaMedia);
        System.out.printf("\nPercentual das pessoas menores de 16 anos: %.1f\n", percentualMenores16);

        for (int ind = 0; ind < vetorPessoas.length; ind++) {
            if (vetorPessoas[ind].getIdade() < 16) {
                System.out.println(vetorPessoas[ind].getNome());
            }
        }

        sc.close();
    }

}
