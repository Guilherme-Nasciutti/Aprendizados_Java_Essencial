package herança_polimorfismo.application;

import herança_polimorfismo.entites.ImportedProduct;
import herança_polimorfismo.entites.Product;
import herança_polimorfismo.entites.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramProduct {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the numbers of products: ");
        int numberProducts = scanner.nextInt();

        for (int i = 1; i <= numberProducts; i++) {
            System.out.println("Product #" + i + " data");
            System.out.print("Common, used or imported ( C/U/I )");
            char option = scanner.next().toUpperCase().charAt(0);
            System.out.print("Name: ");
            String nameProduct = scanner.next();
            System.out.print("Price: $");
            double priceProduct = scanner.nextDouble();
            if (option == 'I') {
                System.out.print("Customs Fee: $");
                double customsFee = scanner.nextDouble();
                products.add(new ImportedProduct(nameProduct, priceProduct, customsFee));
            } else if (option == 'U') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(nameProduct, priceProduct, manufactureDate));
            } else {
                products.add(new Product(nameProduct, priceProduct));
            }
        }

        System.out.println();
        System.out.println("Price tags: ");
        for (Product product : products){
            System.out.println(product.priceTag());
        }


        scanner.close();
    }
}
