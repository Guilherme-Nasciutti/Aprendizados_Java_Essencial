package herança_polimorfismo.application;

import herança_polimorfismo.entites.Produto;
import herança_polimorfismo.entites.ProdutoImportado;
import herança_polimorfismo.entites.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramProduto {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();


        System.out.print("Quantos produtos serão digitados? ");
        int numeroProdutos = scanner.nextInt();

        for (int i = 1; i <= numeroProdutos; i++) {
            System.out.println("\n Dados do " + i + "° produto: ");
            System.out.print("Comum , Usado ou Importado ( C / U / I )? ");
            char resposta = scanner.next().toUpperCase().charAt(0);
            System.out.print("Nome: ");
            String nomeProduto = scanner.next();
            System.out.println("Preço: R$");
            double precoProduto = scanner.nextDouble();
            Produto produto = new Produto(nomeProduto, precoProduto);
            if (resposta == 'I') {
                System.out.print("Taxa Alfandegaria: R$");
                double taxaAlfandegaria = scanner.nextDouble();
                produtos.add(new ProdutoImportado(nomeProduto, precoProduto, taxaAlfandegaria));
            } else if (resposta == 'U') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                LocalDate dataDeFabricacao = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                produtos.add(new ProdutoUsado(nomeProduto, precoProduto, dataDeFabricacao));
            } else {
                produtos.add(new Produto(nomeProduto, precoProduto));
            }
        }
        System.out.println();
        System.out.println("Etiquetas de preço:");
        for (Produto produto : produtos) {
            System.out.println(produto.etiquetaDePreco());
        }

        scanner.close();
    }
}
