package poo.applications;

import poo.entites.AccountBank;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAccountBank {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        AccountBank accountBank;

        System.out.println("Enter data account");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.println("\nDo you want to make an initial deposit? (Y/N) ? ");
        char option = sc.next().toLowerCase().charAt(0);
        if (option == 'y') {
            System.out.print("\nWhat amount do you want to deposit? ");
            double initialDeposit = sc.nextDouble();
            accountBank = new AccountBank(number, holder, initialDeposit);
            System.out.println(accountBank);
        } else {
            accountBank = new AccountBank(number, holder);
            System.out.println(accountBank);
        }

        System.out.print("\nWhat amount do you want to deposit? ");
        double amount = sc.nextDouble();
        accountBank.deposit(amount);
        System.out.println(accountBank);

        System.out.print("\nWhat amount do you want to withdraw? ");
        amount = sc.nextDouble();
        accountBank.withdrawn(amount);
        System.out.println(accountBank);

        sc.close();
    }
}
