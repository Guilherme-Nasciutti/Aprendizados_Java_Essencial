package vetores_matrizes.program;

import vetores_matrizes.entites.Product;

import java.util.Locale;
import java.util.Scanner;

public class ProgramProductVector {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos produtos deseja armazenar? ");
        int n = sc.nextInt();
        Product[] vetorProduto = new Product[n];

        for (int indicador = 0; indicador < vetorProduto.length; indicador++) {
            sc.nextLine();
            System.out.print("Digite o nome do produto: ");
            String name = sc.nextLine();
            System.out.print("Digite o preço do produto: $");
            double price = sc.nextDouble();
            vetorProduto[indicador] = new Product(name, price);
        }

        double soma = 0;

        for (int indicador = 0; indicador < vetorProduto.length; indicador++) {
            soma += vetorProduto[indicador].getPrice();
        }

        double mediaValores = soma / vetorProduto.length;

        System.out.printf("A media dos produtos são: $%.2f", mediaValores);

        sc.close();
    }
}
