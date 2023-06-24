package enumeracoes_composicao.application;

import enumeracoes_composicao.entites.Client;
import enumeracoes_composicao.entites.Order;
import enumeracoes_composicao.entites.OrderItem;
import enumeracoes_composicao.entites.Product;
import enumeracoes_composicao.entites.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class ProgramOrder {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = scanner.next();
        System.out.print("Email: ");
        String clientEmail = scanner.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = dateFormat.parse(scanner.next());
        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("\nEnter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.next().toUpperCase());
        Order order = new Order(new Date(), status, client);

        System.out.print("\nHow many items to this order? ");
        int numberItems = scanner.nextInt();

        for (int i = 1; i <= numberItems; i++) {
            System.out.println("\nEnter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = scanner.next();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println("Order Sumary:");
        System.out.println(order);

        scanner.close();
    }
}
