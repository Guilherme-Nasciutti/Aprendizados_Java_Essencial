package poo.applications;

import poo.entites.Product;

import java.util.Locale;
import java.util.Scanner;

public class ProgramProduct {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do produto");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Preço: $");
        double price = sc.nextDouble();
        System.out.print("Quantidade: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println(product);

        System.out.print("\nQuantos itens deseja adicionar ao estoque?");
        quantity = sc.nextInt();
        product.adicionarProduto(quantity);

        System.out.println(product);

        System.out.print("\nQuantos itens deseja remover do estoque?");
        quantity = sc.nextInt();
        product.removerProduto(quantity);

        System.out.println("\n" + product);

        sc.close();
    }
}
