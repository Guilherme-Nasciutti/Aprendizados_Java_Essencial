package poo.applications;

import poo.entites.Employee;

import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployee {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.println("Digite os dados do funcionário:");
        System.out.print("Nome: ");
        employee.name = sc.nextLine();
        System.out.print("Salário: ");
        employee.grossSalary = sc.nextDouble();
        System.out.print("Imposto: ");
        employee.tax = sc.nextDouble();

        System.out.println(employee);

        System.out.print("\nQual a porcentagem que será adicionada? ");
        double percentage = sc.nextDouble();
        employee.increaseSalary(percentage);

        System.out.println("\nDados Atualizados\n" + employee);

        sc.close();
    }

}
