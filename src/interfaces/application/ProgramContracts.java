package interfaces.application;

import interfaces.model.entites.Contract;
import interfaces.model.entites.Installment;
import interfaces.model.services.ContractService;
import interfaces.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramContracts {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract details:");
        System.out.print("Contract number: ");
        int number = scanner.nextInt();
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(scanner.next(), dateFormat);
        System.out.print("Contract value: $");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Number of installments: ");
        int numberInstallments = scanner.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, numberInstallments);

        System.out.println("\nInstallments:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        scanner.close();
    }
}
