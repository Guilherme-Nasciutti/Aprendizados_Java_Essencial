package herança_polimorfismo.application;

import herança_polimorfismo.entites.Company;
import herança_polimorfismo.entites.Individual;
import herança_polimorfismo.entites.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramTaxPayer {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the numbers of tax payers: ");
        int numberPayers = scanner.nextInt();

        for (int i = 1; i <= numberPayers; i++) {
            System.out.println("\nTax payer #" + i + " data:");
            System.out.print("Individual or company ( I/C )? ");
            char option = scanner.next().toUpperCase().charAt(0);
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Anual Income: $");
            double anualIncome = scanner.nextDouble();
            if (option == 'I') {
                System.out.print("Health expenditures: $");
                double healthExpenditures = scanner.nextDouble();
                taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberEmployees = scanner.nextInt();
                taxPayers.add(new Company(name, anualIncome, numberEmployees));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("Taxes Paid: ");
        for (TaxPayer taxPayer : taxPayers) {
            double tax = taxPayer.tax();
            System.out.println(taxPayer.getName() + ": $" + String.format("%.2f", taxPayer.tax()));
            sum += tax;
        }

        System.out.println();
        System.out.println("Total Taxes: $" + String.format("%.2f", sum));

        scanner.close();
    }
}
