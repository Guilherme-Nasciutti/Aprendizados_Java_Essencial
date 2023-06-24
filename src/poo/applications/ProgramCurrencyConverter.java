package poo.applications;

import poo.entites.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;


/*Aplicação para comprar um valor em doláres pagando em reais. Exercicio sobre os membros estáticos*/

public class ProgramCurrencyConverter {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o valor atual do dollár? ");
        double precoDollar = sc.nextDouble();
        System.out.println("Quantos dolláres deseja comprar? ");
        double valor = sc.nextDouble();

        double valorTotal = CurrencyConverter.dollarToReal(valor, precoDollar);

        System.out.printf("Valor a ser pago em reais: R$%.2f", valorTotal);

        sc.close();
    }

}
