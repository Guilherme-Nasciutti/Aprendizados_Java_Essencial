package interfaces.application;

import interfaces.model.entites.CarRental;
import interfaces.model.entites.Vehicle;
import interfaces.model.services.BrazilTaxService;
import interfaces.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental details");
        System.out.print("Car model: ");
        String modelCar = scanner.nextLine();
        System.out.print("Vehicle removal (DD/MM/YYYY HH:MM): ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), dateFormat);
        System.out.print("Vehicle return (DD/MM/YYYY HH:MM): ");
        LocalDateTime finish = LocalDateTime.parse(scanner.nextLine(), dateFormat);

        CarRental carRental = new CarRental(start, finish, new Vehicle(modelCar));

        System.out.print("Enter the price per hour: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Enter the price per day: ");
        double pricePerDay = scanner.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("\nINVOICE: ");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        scanner.close();
    }
}
