package interfaces.application;

import interfaces.model.services.BrazilInterestService;
import interfaces.model.services.InterestService;
import interfaces.model.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class ProgramInterest {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService isBr = new BrazilInterestService();
        double paymentBrazil = isBr.payment(amount, months);
        InterestService isUsa = new UsaInterestService();
        double paymentUsa = isUsa.payment(amount, months);

        System.out.println("Payment after " + months + " months: ");
        System.out.printf("Brazil: R$%.2f%n", paymentBrazil);
        System.out.printf("USA: $%.2f%n", paymentUsa);

        sc.close();
    }
}
