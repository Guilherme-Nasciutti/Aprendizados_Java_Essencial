package generics_set_map.application;

import generics_set_map.services.PrintService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PrintService printService = new PrintService();

        System.out.print("How many values? ");
        int numberValues = sc.nextInt();

        for (int i = 0; i < numberValues; i++) {
          int value = sc.nextInt();
          printService.addValue(value);
        }

        printService.print();
        System.out.println("\nFirst: " + printService.first());

        sc.close();
    }
}
