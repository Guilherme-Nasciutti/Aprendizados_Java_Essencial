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

        System.out.println("Entre com os dados do aluguel:");
        System.out.print("Modelo do carro: ");
        String modelCar = scanner.nextLine();
        System.out.print("Retirada (DD/MM/YYYY HH:MM): ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), dateFormat);
        System.out.print("Retorno (DD/MM/YYYY HH:MM): ");
        LocalDateTime finish = LocalDateTime.parse(scanner.nextLine(), dateFormat);

        CarRental carRental = new CarRental(start, finish, new Vehicle(modelCar));

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = scanner.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("Fatura: ");
        System.out.println("Pagamento basico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        scanner.close();
    }
}
