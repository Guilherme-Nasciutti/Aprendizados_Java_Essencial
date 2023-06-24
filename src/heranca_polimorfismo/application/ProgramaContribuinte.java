package herança_polimorfismo.application;

import herança_polimorfismo.entites.Contribuinte;
import herança_polimorfismo.entites.PessoaFisica;
import herança_polimorfismo.entites.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaContribuinte {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Digite o numero de contribuintes a ser digitados: ");
        int numeroContribuintes = scanner.nextInt();

        for (int i = 1; i <= numeroContribuintes; i++) {
            System.out.println("Dados do " + i + "° contribuinte: ");
            System.out.print("Pessoa Fisica ou Juridica ( F / J)? ");
            char option = scanner.next().toUpperCase().charAt(0);
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Renda Anual: R$");
            double rendaAnual = scanner.nextDouble();
            if (option == 'F') {
                System.out.print("Despesas Medicas: R$");
                double despesasMedicas = scanner.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, despesasMedicas));
            } else {
                System.out.print("Numero de funcionarios: ");
                int numeroFuncionarios = scanner.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }

        double soma = 0.0;
        System.out.println();
        System.out.println("Impostos pagos: ");
        for (Contribuinte contribuinte : contribuintes) {
            double imposto = contribuinte.imposto();
            System.out.println(contribuinte.getNome() + ": R$" + String.format("%.2f", contribuinte.imposto()));
            soma += imposto;
        }

        System.out.println("Total de impostos: R$" + String.format("%.2f", soma));

        scanner.close();
    }
}
