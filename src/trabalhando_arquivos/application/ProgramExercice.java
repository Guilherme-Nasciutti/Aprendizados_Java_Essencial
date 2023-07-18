package trabalhando_arquivos.application;

/*
 * Ler caminho do arquivo .csv
 * Separar os dados dos produtos (nome, preço, quantidade)
 * criar subpasta "out"
 * gerar novo arquivo "summary.csv" com apenas o nome e o valor total(preço * quantidade)
 * */

import trabalhando_arquivos.entites.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramExercice {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter file path: ");
        String sourceFileStr = scanner.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean sucess = new File(sourceFolderStr + "\\out").mkdir();

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                products.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                for (Product item : products) {
                    bw.write(item.getName() + ", " + String.format("$%.2f", item.totalValue()));
                    bw.newLine();
                }
                System.out.println(targetFileStr + " Created!");
            } catch (IOException error) {
                System.out.println("Error: " + error.getMessage());
            }
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
        scanner.close();
    }
}
