package enumeracoes_composicao.application;

import enumeracoes_composicao.entites.Department;
import enumeracoes_composicao.entites.HourContract;
import enumeracoes_composicao.entites.Worker;
import enumeracoes_composicao.entites.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramWorker {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the department's name: ");
        String departmentName = scanner.next();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = scanner.next();
        System.out.print("Level: ");
        String workerLevel = scanner.next().toUpperCase();
        System.out.print("Base salary: $");
        double baseSalary = scanner.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("\nHow many contracts to this worker? ");
        int numberContracts = scanner.nextInt();

        for (int i = 1; i <= numberContracts; i++) {
            System.out.println("\nEnter contract #" + i + " data:");
            System.out.print("Date: ");
            Date contractDate = dateFormat.parse(scanner.next());
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scanner.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scanner.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        scanner.close();
    }
}
