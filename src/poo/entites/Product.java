package poo.entites;

public class Product {

    public String name;
    public double price;
    public int quantity;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double valorTotalEmStock() {
        return quantity * price;
    }

    public void adicionarProduto(int quantity) {
        this.quantity += quantity;
    }

    public void removerProduto(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return "\nDados do produto no estoque\n"
                + "\nNome: "
                + name
                + ", \nQuantidade: "
                + quantity
                + String.format(" unidades. \nPreço: $%.2f", valorTotalEmStock());
    }

}
