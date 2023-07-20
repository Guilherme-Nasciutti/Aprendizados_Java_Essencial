package generics_set_map.application;

import generics_set_map.services.PrintService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PrintService<Integer> printService = new PrintService<>();

        System.out.print("How many values? ");
        int numberValues = sc.nextInt();

        for (int i = 0; i < numberValues; i++) {
            Integer value = sc.nextInt();
            printService.addValue(value);
        }

        printService.print();
        System.out.println("\nFirst: " + printService.first());

        System.out.println("----------");

        PrintService<String> printServiceString = new PrintService<>();

        System.out.print("How many names? ");
        numberValues = sc.nextInt();

        for (int i = 0; i < numberValues; i++) {
            String valueString = sc.next();
            printServiceString.addValue(valueString);
        }

        printServiceString.print();
        System.out.println("\nFirst: " + printServiceString.first());

        sc.close();
    }
}
