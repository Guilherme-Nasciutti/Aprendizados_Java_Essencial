package herança_polimorfismo.application;

import herança_polimorfismo.entites.Contribuinte;
import herança_polimorfismo.entites.Funcionario;
import herança_polimorfismo.entites.FuncionarioTerceirizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaFuncionario {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Qual a quantidade de funcionários? ");
        int numeroFuncionarios = scanner.nextInt();

        for (int i = 1; i <= numeroFuncionarios; i++) {
            System.out.println("\nDados do " + i + "° funcionário: ");
            System.out.print("Funcionário terceirizado (S/N) ?  ");
            char resposta = scanner.next().toUpperCase().charAt(0);
            System.out.print("Nome: ");
            scanner.nextLine();
            String nomeFuncionario = scanner.nextLine();
            System.out.print("Horas: ");
            int horas = scanner.nextInt();
            System.out.print("Valor por hora: ");
            double valorPorHora = scanner.nextDouble();
            if (resposta == 'S') {
                System.out.print("Despesas adicionais: ");
                double despesaAdicional = scanner.nextDouble();
                funcionarios.add(new FuncionarioTerceirizado(nomeFuncionario, horas, valorPorHora, despesaAdicional));
            } else {
                funcionarios.add(new Funcionario(nomeFuncionario, horas, valorPorHora));
            }
        }

        System.out.println();
        System.out.println("Pagamentos:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - R$" + String.format("%.2f", funcionario.pagamento()));
        }

        scanner.close();
    }
}
