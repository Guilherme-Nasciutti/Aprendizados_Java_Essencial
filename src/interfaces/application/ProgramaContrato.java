package interfaces.application;

import interfaces.model.entites.Contrato;
import interfaces.model.entites.Parcelamento;
import interfaces.model.services.ContratoService;
import interfaces.model.services.PagamentoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaContrato {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite os dados do contrato");
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        System.out.print("Data (DD/MM/AAAA): ");
        LocalDate data = LocalDate.parse(scanner.next(), formatoData);
        System.out.print("Valor do contrato: R$");
        double valorTotal = scanner.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorTotal);

        System.out.print("Qual o número de parcelas: ");
        int numeroParcelas = scanner.nextInt();

        ContratoService contratoService = new ContratoService(new PagamentoService());

        contratoService.processamentoContrato(contrato, numeroParcelas);

        System.out.println("\nParcelas");
        for (Parcelamento parcelamento : contrato.getParcelamentos()) {
            System.out.println(parcelamento);
        }

        scanner.close();
    }
}
